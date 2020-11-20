package com.example.tendi.generalUser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tendi.R;
import com.example.tendi.util.Constants;
import com.google.firebase.database.DatabaseReference;

public class BolsaDeCompra extends AppCompatActivity {

    private DatabaseReference myRef = Constants.refDB.child("Tenderos").child("1234").child("Pedidos");

    private ImageButton backBtn;
    private ImageButton deleteBtn;
    private Button payBtn;
    private Button pushBtn;
    private Button removeBtn;
    private TextView cant;
    private TextView price1TV;
    private int index;
    private int price;
    private String inde;
    private String t;
    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolsa_de_compra);

        backBtn = findViewById(R.id.backBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        pushBtn = findViewById(R.id.pushBtn);
        removeBtn = findViewById(R.id.removeBtn);
        cant = findViewById(R.id.cantidadTV);
        price1TV = findViewById(R.id.price1TV);
        payBtn = findViewById(R.id.payBtn);

        backBtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, TendActivity.class);
                    startActivity(i);
                }
        );

        deleteBtn.setOnClickListener(
                (v)->{
                    index = 0;
                    inde = String.valueOf(index);
                    cant.setText(inde);
                    total = index * 800;
                    t = String.valueOf(total);
                    price1TV.setText("$ " +t);
                }
        );

        pushBtn.setOnClickListener(
                (v)->{
                    index += 1;
                    inde = String.valueOf(index);
                    cant.setText(inde);
                    total = index * 800;
                    t = String.valueOf(total);
                    price1TV.setText("$ " +t);
                }
        );

        removeBtn.setOnClickListener(
                (v)->{
                    index -= 1;
                    inde = String.valueOf(index);
                    cant.setText(inde);
                    total = index * 800;
                    t = String.valueOf(total);
                    price1TV.setText("$ " +t);
                }
        );

        payBtn.setOnClickListener(
                (v)->{

                    total = index * 800;
                    myRef.child("Name").setValue("Ramon Rasputin");
                    myRef.child("Producto").setValue("Galleta Festival Vainilla");
                    myRef.child("Precio").setValue(t);

                    t = String.valueOf(total);


                }
        );
    }
}