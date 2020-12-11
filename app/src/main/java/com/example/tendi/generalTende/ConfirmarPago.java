package com.example.tendi.generalTende;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.tendi.R;

public class ConfirmarPago extends AppCompatActivity {

    private Button confirmarBTN;
    private Button denegarBTN;
    private TextView nameProduct;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pago);

        nameProduct = findViewById(R.id.nameProductoConfirmarTV);
        nameProduct.setText(getIntent().getExtras().getString("nameProduct"));

       // invent = new InventarioFragment();
        confirmarBTN = findViewById(R.id.confirmPayBTN);
        confirmarBTN.setOnClickListener((v)->{

            /*Obtiene el Fragment manager
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
           // invent.setArguments(bundle);
          //  ft.replace(R.id.fragmentContainerT, invent);
            ft.commit();
            Bundle bundle = new Bundle();
            bundle.putString("confirmPago", "Pedido a proveedor");
            InventarioFragment fragobj = new InventarioFragment();
            fragobj.setArguments(bundle);
            */
            Intent intent = new Intent(this, HomeActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("confirmPago", "Pedido a proveedor");

            startActivity(intent);
            finish();
        });

        denegarBTN = findViewById(R.id.deniedPayBTN);
        denegarBTN.setOnClickListener((v)->{finish();});

    }
}