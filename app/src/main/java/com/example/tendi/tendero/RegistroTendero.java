package com.example.tendi.tendero;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.tendi.R;
import com.example.tendi.model.Tendero;

import java.util.UUID;

public class RegistroTendero extends AppCompatActivity {

    private ImageButton backBTN;
    private Button continueBTN;

    private EditText nameEDT;
    private EditText lastnameEDT;
    private EditText celEDT;

    private static final int CODE = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tendero);

        backBTN = findViewById(R.id.backBTN);
        continueBTN = findViewById(R.id.continueBTN);

        nameEDT = findViewById(R.id.nameEDT);
        lastnameEDT = findViewById(R.id.lastnameEDT);
        celEDT = findViewById(R.id.celEDT);

        continueBTN.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, RegistroTendero2.class);
                    Tendero tend = new Tendero(UUID.randomUUID().toString(), nameEDT.getText().toString()+lastnameEDT.getText().toString(), celEDT.getText().toString());
                    i.putExtra("tend", (Parcelable) tend);
                    startActivityForResult(i, CODE);
                }
        );

        backBTN.setOnClickListener(
                (v)->{
                    finish();
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE && resultCode == RESULT_OK) {

        }
    }
}