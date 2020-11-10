package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.tendi.R;

public class BeneficioCredito extends AppCompatActivity {

    ImageView arrowBack = findViewById(R.id.backArrowTV);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficio_credito);

        arrowBack.setOnClickListener(
                (v) -> {
                    finish();
                }
        );
    }
}