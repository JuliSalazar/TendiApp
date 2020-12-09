package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tendi.R;

public class BeneficioAhorroActivity extends AppCompatActivity {

    private ImageButton arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficio_ahorro);

        arrowBack = findViewById(R.id.backBeneficioAhorroBtn);

        arrowBack.setOnClickListener(
                (v) -> {
                    finish();
                }
        );
    }
}