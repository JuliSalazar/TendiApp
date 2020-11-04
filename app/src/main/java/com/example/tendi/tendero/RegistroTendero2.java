package com.example.tendi.tendero;

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
import com.example.tendi.util.Constants;
import com.example.tendi.util.HTTPSWebUtilDomi;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

public class RegistroTendero2 extends AppCompatActivity {

    private ImageButton backBTN;
    private Button finalizarBTN;

    private EditText negocioName;
    private EditText direcEDT;
    private EditText rutEDT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tendero2);

        backBTN = findViewById(R.id.backBTN);
        finalizarBTN = findViewById(R.id.finalizarBTN);

        negocioName = findViewById(R.id.negocioNameEDT);
        direcEDT = findViewById(R.id.direcEDT);
        rutEDT = findViewById(R.id.rutEDT);

        Tendero tend = (Tendero) getIntent().getExtras().getSerializable("tend");
        Log.e("CONSOLA", tend.getName());


        finalizarBTN.setOnClickListener(
                (v)->{
                    Negocio nego = new Negocio(negocioName.getText().toString(), direcEDT.getText().toString(),rutEDT.getText().toString());
                    tend.setNegocio(nego);
                    Gson gson = new Gson();
                    String json = gson.toJson(tend);
                    HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();
                    new Thread(
                            ()->{
                                https.PUTrequest(Constants.BASEURL+"Tenderos/"+tend.getCelular()+".json",json);
                            }
                    ).start();
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