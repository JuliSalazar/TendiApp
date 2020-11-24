package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.tendi.R;
import com.example.tendi.model.Producto;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ComprarProductActivity extends AppCompatActivity {

    //ACTIVIDAD DE COMPRAR PRODUCTOS DE PROVEEDORES

    private Spinner spinner;
    //Para el RecyclerView
    private RecyclerView comprarProductosVL;
    private LinearLayoutManager layoutManager;
    private ComprarProductAdapter comprarProductAdapter;
    private FirebaseFirestore db;
    private CollectionReference productosRef;
    private ImageButton backBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_product);

        backBTN = findViewById(R.id.backComprarProductosBTN);

        comprarProductAdapter = new ComprarProductAdapter();
        comprarProductosVL = findViewById(R.id.comprarProductoRecyclerView);
        comprarProductosVL.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        comprarProductosVL.setAdapter(comprarProductAdapter);
        comprarProductosVL.setLayoutManager(layoutManager);
        db = FirebaseFirestore.getInstance();
         productosRef = db.collection("Productos");

         spinner =  findViewById(R.id.spinnercategories);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.optionsCategories, R.layout.spinner_item_defaulttendi);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_item_defaulttendi);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        updateProducts();

        backBTN.setOnClickListener((v)->{finish();});

    }

    public void updateProducts(){
        comprarProductAdapter.clearList();
        productosRef.get().addOnCompleteListener(
                task->{
                    for (DocumentSnapshot doc: task.getResult().getDocuments()){
                        Producto dbProduct = doc.toObject(Producto.class);
                        dbProduct.setId(doc.getId());
                        comprarProductAdapter.addProducto(dbProduct);
                    }
                }
        );

    }

}