package com.example.tendi.InicioRegistro;

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
import com.example.tendi.generalTende.HomeActivity;
import com.example.tendi.generalUser.UserMainActivity;
import com.example.tendi.model.Tendero;
import com.example.tendi.usuario.Usuario;
import com.example.tendi.util.Constants;
import com.example.tendi.util.HTTPSWebUtilDomi;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.gson.Gson;

public class Inicio extends AppCompatActivity {

    private Button iniciarBTN;
    private EditText celuET;
    private EditText contraET;

    private TextView registrarText;
    private TextView recuperarText;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

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
                   if(edtCel.isEmpty()){
                       celuET.setHint("Ingresa un número de celular");
                       celuET.setHintTextColor(getResources().getColor(R.color.colorError));
                       if (edtContra.isEmpty()){
                           contraET.setHint("Ingresa tu contraseña");
                           contraET.setHintTextColor(getResources().getColor(R.color.colorError));
                       }
                   }else{
                       CollectionReference usersRef = db.collection("Usuarios");
                       Query query = usersRef.whereEqualTo("celular", edtCel);
                       query.get().addOnCompleteListener(
                               task -> {
                                   if (task.isSuccessful()){
                                       if (task.getResult().size() > 0){
                                           for (QueryDocumentSnapshot document : task.getResult()){
                                               Usuario dbUser = document.toObject(Usuario.class);
                                               if(dbUser.getContra().equals(edtContra)){
                                                   if(dbUser.isTendero()){
                                                       Intent i = new Intent(this, HomeActivity.class);
                                                       goToHome(dbUser,i);
                                                   }else{
                                                       Intent i = new Intent(this, UserMainActivity.class);
                                                       goToHome(dbUser,i);
                                                   }
                                               }else{
                                                   contraET.setText("");
                                                   contraET.setHint("Contraseña incorrecta");
                                                   contraET.setHintTextColor(getResources().getColor(R.color.colorError));
                                               }
                                           }
                                       }else{
                                           celuET.setText("");
                                           contraET.setText("");
                                           celuET.setHint("No existe el usuario");
                                           celuET.setHintTextColor(getResources().getColor(R.color.colorError));
                                       }
                                   }
                               }
                       );
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

    public void goToHome(Usuario user, Intent i){
        i.putExtra("myUser", user);
        startActivity(i);
    }

    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }
}