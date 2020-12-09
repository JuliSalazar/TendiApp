package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.tendi.R;

public class BeneficioCredito extends AppCompatActivity {

    private ImageButton arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficio_credito);

        arrowBack = findViewById(R.id.backBeneficioCreditoBtn);

        arrowBack.setOnClickListener(
                (v) -> {
                    finish();
                }
        );
    }
}