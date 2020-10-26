package com.example.tendi.tendero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tendi.R;

public class RegistroTendero extends AppCompatActivity {

    private ImageButton backBTN;
    private Button continueBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tendero);

        backBTN = findViewById(R.id.backBTN);
        continueBTN = findViewById(R.id.continueBTN);

        continueBTN.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, RegistroTendero2.class);
                    startActivity(i);
                }
        );

        backBTN.setOnClickListener(
                (v)->{
                    finish();
                }
        );
    }
}