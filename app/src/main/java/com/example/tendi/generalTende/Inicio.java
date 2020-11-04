package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tendi.R;
import com.example.tendi.model.Tendero;
import com.example.tendi.usuario.Usuario;
import com.example.tendi.util.Constants;
import com.example.tendi.util.HTTPSWebUtilDomi;
import com.google.firebase.database.DatabaseReference;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class Inicio extends AppCompatActivity {

    private Button iniciarBTN;
    private EditText celuET;
    private EditText contraET;

    private TextView registrarText;
    private TextView recuperarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    
        //Referenciar para cambiar colores de textview

        registrarText = findViewById(R.id.registrarTV);
        recuperarText = findViewById(R.id.recuperarTV);

        String text = getColoredSpanned("¿Quieres ser parte de Tendi?", "#777777");
        String action = getColoredSpanned("Regístrate","#FE811E");

        registrarText.setText(Html.fromHtml(text+" "+action));

        String textRecu = getColoredSpanned("¿Olvidaste tu contraseña?", "#8F8F8F");
        String actionRecu = getColoredSpanned("Recupérala","#777777");

        recuperarText.setText(Html.fromHtml(textRecu+" "+"<u>"+actionRecu+"</u>"));

        //Referenciar botones y edittext
        iniciarBTN = findViewById(R.id.iniciarBTN);
        celuET = findViewById(R.id.celularET);
        contraET = findViewById(R.id.contraET);

        iniciarBTN.setOnClickListener(
               (v)->{
                   String edtCel = celuET.getText().toString();
                   String edtContra = contraET.getText().toString();
                   //Si el usuario no pone nada en los EDT entonces aparece el mensaje de error
                   Gson gson = new Gson();
                   if(edtCel.equals("")){
                       celuET.setHint("Ingresa un número de celular");
                       celuET.setHintTextColor(getResources().getColor(R.color.colorError));
                       if (edtContra.equals("")){
                           contraET.setHint("Ingresa tu contraseña");
                           contraET.setHintTextColor(getResources().getColor(R.color.colorError));
                       }
                   }else{
                       HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();
                       new Thread(
                               ()->{
                                   //Aqui se hace la autenticacion del numero del cel y la contraseña
                                   String respTend = https.GETrequest(Constants.BASEURL+ "Tenderos/"+ edtCel + ".json");
                                   //Si no esta en la rama de tenderos, miro la de usuarios
                                   if(respTend.equals("null")){
                                       String respUser = https.GETrequest(Constants.BASEURL+ "Usuarios/"+ edtCel + ".json");
                                       // si no esta en la rama de usuarios no existe
                                       if(respUser.equals("null")) {
                                           runOnUiThread(
                                                   () -> {
                                                       celuET.setText("");
                                                       contraET.setText("");
                                                       celuET.setHint("No existe el usuario");
                                                       celuET.setHintTextColor(getResources().getColor(R.color.colorError));
                                                   }
                                           );

                                       }else{//si existe en usuarios, creo el usuario para autenticar
                                           Log.e("CONSOLA", respUser);
                                           Usuario u = gson.fromJson(respUser, Usuario.class);
                                           //   t = gson.fromJson(resp, Tendero.class);
                                       }

                                   }else{ //si existe en tenderos, hago la autenticación y paso de pantalla
                                       Tendero t = gson.fromJson(respTend, Tendero.class);
                                       if(t.getContra().equals(edtContra)){
                                           Intent i = new Intent(this, HomeActivity.class);
                                           startActivity(i);
                                       }else {
                                           runOnUiThread(
                                                   ()->{
                                                       contraET.setText("");
                                                       contraET.setHint("Contraseña incorrecta");
                                                       contraET.setHintTextColor(getResources().getColor(R.color.colorError));
                                                   }
                                           );
                                       }
                                   }//termina else tenderos
                               }
                       ).start();
                   }
               }
        );

        registrarText.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, Registro1.class);
                    startActivity(i);
                }
        );

    }
    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }
}