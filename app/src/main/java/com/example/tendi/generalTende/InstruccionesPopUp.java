package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.example.tendi.R;
import com.example.tendi.usuario.Usuario;

public class InstruccionesPopUp extends AppCompatActivity {

    private TextView bienvenidaTV;
    private String nameUser;
    private String text;
    private String text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones_pop_up);

        nameUser =  getIntent().getExtras().getString("userName");

        bienvenidaTV = findViewById(R.id.bienvenidaTV);

        text = nameUser ;
        text2 = "! te doy la bienvenida a tu sección de ventas";

        SpannableStringBuilder ss = new SpannableStringBuilder(text);
        ss.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD),0 , nameUser.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableStringBuilder ss2 = new SpannableStringBuilder(text2);
        ss2.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD),27 , 44, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String here= "¡Hola "+ss+ss2;

        bienvenidaTV.setText(here);


        DisplayMetrics medidas = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);
         int ancho = medidas.widthPixels;
        int alto = medidas.heightPixels;

     //   getWindow().setLayout((int) (ancho*0.9), (int) (alto));
    }
}