package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tendi.R;

public class BeneficioCreditosActivity extends AppCompatActivity {

    private ImageButton arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficio_creditos);

        arrowBack = findViewById(R.id.backBeneficioCreditosBtn);

        arrowBack.setOnClickListener(
                (v) -> {
                    finish();
                }
        );
    }
}