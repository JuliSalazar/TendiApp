package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.tendi.R;

public class BeneficioCredito extends AppCompatActivity {

    private ImageView arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficio_credito);

        arrowBack = findViewById(R.id.backArrowTV);

        arrowBack.setOnClickListener(
                (v) -> {
                    finish();
                }
        );
    }
}