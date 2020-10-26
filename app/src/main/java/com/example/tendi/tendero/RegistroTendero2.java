package com.example.tendi.tendero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tendi.general.AsistenteFragment;
import com.example.tendi.R;
import com.example.tendi.general.HomeActivity;

public class RegistroTendero2 extends AppCompatActivity {

    private ImageButton backBTN;
    private Button finalizarBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tendero2);

        backBTN = findViewById(R.id.backBTN);
        finalizarBTN = findViewById(R.id.finalizarBTN);

        finalizarBTN.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, HomeActivity.class);
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