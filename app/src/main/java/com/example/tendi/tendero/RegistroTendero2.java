package com.example.tendi.tendero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tendi.R;
import com.example.tendi.generalTende.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroTendero2 extends AppCompatActivity {

    private ImageButton backBTN;
    private Button finalizarBTN;

    //FirebaseDatabase database = FirebaseDatabase.getInstance();
    //DatabaseReference myRef = database.getReference("message");

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tendero2);

        backBTN = findViewById(R.id.backBTN);
        finalizarBTN = findViewById(R.id.finalizarBTN);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        finalizarBTN.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, HomeActivity.class);
                    //Intent data = new Intent();
                    //setResult(RESULT_OK, data);
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