package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tendi.R;

public class BeneficioBonosActivity extends AppCompatActivity {

    private ImageButton arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficio_bonos);

        arrowBack = findViewById(R.id.backBeneficioBonosBtn);

        arrowBack.setOnClickListener(
                (v) -> {
                    finish();
                }
        );
    }
}