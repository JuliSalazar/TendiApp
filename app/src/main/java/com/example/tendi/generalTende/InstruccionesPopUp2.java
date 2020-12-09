package com.example.tendi.generalTende;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tendi.R;

public class InstruccionesPopUp2 extends AppCompatActivity {

    private TextView infoTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones_pop_up2);



        infoTV = findViewById(R.id.infotv);


        infoTV.setText("Te daré una breve guía para esta sección, pero si quieres puede saltarla");


        DisplayMetrics medidas = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);
         int ancho = medidas.widthPixels;
        int alto = medidas.heightPixels;

     //   getWindow().setLayout((int) (ancho*0.9), (int) (alto));
    }
}