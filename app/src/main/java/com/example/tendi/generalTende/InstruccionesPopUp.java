package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.example.tendi.R;
import com.example.tendi.usuario.Usuario;

public class InstruccionesPopUp extends AppCompatActivity {

    private TextView bienvenidaTV;
    private String nameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones_pop_up);

        nameUser =  getIntent().getExtras().getString("userName");

        bienvenidaTV = findViewById(R.id.bienvenidaTV);

        bienvenidaTV.setText("¡Hola "+ nameUser + "! te doy la bienvenida a tu sección de ventas");

        DisplayMetrics medidas = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);
         int ancho = medidas.widthPixels;
        int alto = medidas.heightPixels;
     //   getWindow().setLayout((int) (ancho*0.9), (int) (alto));
    }
}