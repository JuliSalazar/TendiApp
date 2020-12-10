package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tendi.R;
import com.example.tendi.model.Producto;
import com.example.tendi.model.Proveedor;

public class DetalleCompraProveedor extends AppCompatActivity {

    private Producto myproducto;
    private Proveedor myproveedor;

    //Elementos visuales
    private ImageView imgProveedor;
    private TextView nameProveedor;
    //
    private ImageView imgProducto;
    private TextView nameProductoProve;
    private TextView pUnidProvee;
    private TextView pDocenaProvee;
    private TextView pCargoProvee;

    private Button continuarBTN;

    private ImageButton backBTNDetalleProve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_compra_proveedor);

        myproducto = (Producto) getIntent().getExtras().getSerializable("elProducto");
        myproveedor = (Proveedor) getIntent().getExtras().getSerializable("elProveedor");

        //referenciar views
        imgProveedor = findViewById(R.id.imgDetalleProveedores);
        nameProveedor = findViewById(R.id.nameDetalleProveedor);

        imgProducto = findViewById(R.id.imgProductoDetalleProve);
        nameProductoProve = findViewById(R.id.productNameDetalleProve);
        pUnidProvee = findViewById(R.id.pUnidDetalleProve);
        pDocenaProvee = findViewById(R.id.pDocenaDetalleProve);
        pCargoProvee = findViewById(R.id.pCargoDetalleProve);

        continuarBTN = findViewById(R.id.continuarCompraProveedorBTN);

        backBTNDetalleProve = findViewById(R.id.backDetalleProveBTN);
        backBTNDetalleProve.setOnClickListener((v)->{finish();});

        //set variables
        Glide.with(this).load(myproveedor.getImg()).into(imgProveedor);
        nameProveedor.setText(myproveedor.getNombre());

        Glide.with(this).load(myproducto.getImg()).into(imgProducto);
        nameProductoProve.setText(myproducto.getNombre());
        pUnidProvee.setText("$ "+ myproveedor.getPrecioUnidad());
        pDocenaProvee.setText("$ "+ myproveedor.getPrecioDocena());
        pCargoProvee.setText("$ "+ myproveedor.getPrecioCargo());

        continuarBTN.setOnClickListener((v)->{
            Intent intent = new Intent(this,ConfirmarPago.class);
            intent.putExtra("nameProduct", myproducto.getNombre());
            startActivityForResult(intent,17);
        });

    }
}