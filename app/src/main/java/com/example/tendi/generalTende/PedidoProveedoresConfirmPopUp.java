package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;

import com.example.tendi.R;

public class PedidoProveedoresConfirmPopUp extends AppCompatActivity {

    private Button aceptarBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_proveedores_confirm_pop_up);

        aceptarBTN = findViewById(R.id.aceptarPopUpBTN);

        aceptarBTN.setOnClickListener((v)->{finish();});

        DisplayMetrics medidas = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);
        int ancho = medidas.widthPixels;
        int alto = medidas.heightPixels;
       // getWindow().setLayout((int) (ancho), (int) (alto*0.5));
    }
}