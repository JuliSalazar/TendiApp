package com.example.tendi.InicioRegistro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tendi.R;

public class Registro1 extends AppCompatActivity {

    private ImageButton backBTN;
    private Button tenderBTN;
    private Button userBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro1);

        //Referenciar botones
        backBTN = findViewById(R.id.backBTN);
        tenderBTN = findViewById(R.id.tenderBTN);
        userBTN = findViewById(R.id.userBTN);

        //Acciones

        backBTN.setOnClickListener(
                (v)->{
                    finish();
                }
        );

        tenderBTN.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, RegistroTendero.class);
                    startActivity(i);
                }
        );
        userBTN.setOnClickListener(
                (v)->{
                     Intent i = new Intent(this, RegistroComprador.class);
                     startActivity(i);
                }
        );

    }
}