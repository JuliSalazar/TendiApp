package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tendi.R;

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
                   /*Gson gson = new Gson();
                   String tenderCel = celuET.getText().toString();
                   String tenderContra = contraET.getText().toString();
                   HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();
                  // https.GETrequest(Constants.BASEURL+ "Tenderos/");*/
                   Intent i = new Intent(this, HomeActivity.class);
                   startActivity(i);
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