package com.example.tendi.generalUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tendi.R;
import com.example.tendi.model.Producto;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class TendActivity extends AppCompatActivity {


    private ImageButton returnBtn;
    private ImageButton bolsaBtn;
    private Button addBtn;
    private TextView indexTV;
    private TextView dineroTV;
    private Button bebidaBtn;
    private Button mecatoBtn;
    private Button panBtn;
    private Button granoBtn;
    private Button fyvBtn;
    private Button aseoBtn;
    private RecyclerView productViewList;
    private GridLayoutManager layoutManager;
    private ProductsAdapter productsAdapter;
    private FirebaseFirestore db;
    private CollectionReference productsRef;
    private int index;
    private String inde;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);

        returnBtn = findViewById(R.id.returnBtn);
        bolsaBtn = findViewById(R.id.bolsaBtn);
        addBtn = findViewById(R.id.addProductBtnUser);
        indexTV = findViewById(R.id.indexTV);
        bebidaBtn = findViewById(R.id.bebidaBtn);
        mecatoBtn = findViewById(R.id.mecatoBtn);
        panBtn = findViewById(R.id.panBtn);
        granoBtn = findViewById(R.id.granoBtn);
        fyvBtn = findViewById(R.id.fyvBtn);
        aseoBtn = findViewById(R.id.aseoBtn);
        dineroTV = findViewById(R.id.dineroTV);

        returnBtn.setOnClickListener(

                (v)->{

                    finish();
                }

        );


        bolsaBtn.setOnClickListener(

                (v)->{
                    Intent i = new Intent(this, BolsaDeCompra.class);
                    startActivity(i);
                }
        );

       addBtn.setOnClickListener(
                (v) -> {
                    index += 1;
                    inde = String.valueOf(index);
                    Log.e(">>>", String.valueOf(index));
                    indexTV.setText(inde);



                }
        );

        

        int r = 254;
        int g = 129;
        int b = 30;

        int grey = 189;


        bebidaBtn.setOnClickListener(
                (v) -> {

                    if(bebidaBtn.getTextColors().equals(Color.rgb(r,g,b))){
                        bebidaBtn.setTextColor(Color.rgb(grey,grey,grey));
                    }else{
                        bebidaBtn.setTextColor(Color.rgb(r,g,b));
                    }







                    //bebidaBtn.setTextColor(Color.rgb(r,g,b));
                }
        );
        mecatoBtn.setOnClickListener(
                (v) -> {
                    mecatoBtn.setTextColor(Color.rgb(r,g,b));
                }
        );
        panBtn.setOnClickListener(
                (v) -> {
                    panBtn.setTextColor(Color.rgb(r,g,b));
                }
        );
        granoBtn.setOnClickListener(
                (v) -> {
                    granoBtn.setTextColor(Color.rgb(r,g,b));
                }
        );
        fyvBtn.setOnClickListener(
                (v) -> {
                    fyvBtn.setTextColor(Color.rgb(r,g,b));
                }
        );
        aseoBtn.setOnClickListener(
                (v) -> {
                    aseoBtn.setTextColor(Color.rgb(r,g,b));
                }
        );


        productViewList = findViewById(R.id.productViewInvetListTend);
        layoutManager = new GridLayoutManager(this,2);
        productViewList.setLayoutManager(layoutManager);
        productsAdapter = new ProductsAdapter();
        db = FirebaseFirestore.getInstance();
        productViewList.setAdapter(productsAdapter);
        productViewList.setLayoutManager(layoutManager);
        productViewList.setHasFixedSize(true);
        productsRef = db.collection("Productos");

        updateProducts();

    }

    public void updateProducts(){
        productsAdapter.clearList();
        productsRef.get().addOnCompleteListener(
                task->{
                    for (DocumentSnapshot doc: task.getResult().getDocuments()){
                        Log.e("Consola", doc.getId());
                        Producto dbProduct = doc.toObject(Producto.class);
                        dbProduct.setId(doc.getId());
                        productsAdapter.addProduct(dbProduct);
                    }
                }
        );

    }
}