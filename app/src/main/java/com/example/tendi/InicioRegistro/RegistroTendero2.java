package com.example.tendi.InicioRegistro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.tendi.R;
import com.example.tendi.generalTende.HomeActivity;
import com.example.tendi.model.Negocio;
import com.example.tendi.model.Tendero;
import com.example.tendi.usuario.Usuario;
import com.example.tendi.util.Constants;
import com.example.tendi.util.HTTPSWebUtilDomi;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

public class RegistroTendero2 extends AppCompatActivity {

    private ImageButton backBTN;
    private Button finalizarBTN;

    private EditText negocioName;
    private EditText direcEDT;
    private EditText rutEDT;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tendero2);

        backBTN = findViewById(R.id.backBTN);
        finalizarBTN = findViewById(R.id.finalizarBTN);

        negocioName = findViewById(R.id.negocioNameEDT);
        direcEDT = findViewById(R.id.direcEDT);
        rutEDT = findViewById(R.id.rutEDT);

        Usuario user = (Usuario) getIntent().getExtras().getSerializable("tend");

        finalizarBTN.setOnClickListener(
                (v)->{
                    Negocio nego = new Negocio(negocioName.getText().toString(), direcEDT.getText().toString(),rutEDT.getText().toString());
                    db.collection("Usuarios").document(user.getCelular()).set(user);
                    db.collection("Negocios").document(user.getCelular()).set(nego);
                    Intent i = new Intent(this, HomeActivity.class);
                    startActivity(i);
                    //finish();
                }
        );

        backBTN.setOnClickListener(
                (v)->{
                    finish();
                }
        );
    }
}