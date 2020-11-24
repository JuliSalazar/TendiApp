package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

import com.example.tendi.R;
import com.example.tendi.model.Producto;
import com.example.tendi.model.Proveedor;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProveedoresActivity extends AppCompatActivity {

    private ImageButton backBTN;
    //Para el RecyclerView
    private RecyclerView proveedoresVL;
    private LinearLayoutManager layoutManager;
    private ProveedoresAdapter proveedoresAdapter;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference proveedoresRef;
    //producto pedido
    private Producto myProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);

        backBTN = findViewById(R.id.backProveedoresBTN);
        backBTN.setOnClickListener((v)->{finish();});
        //recyclerview
        proveedoresAdapter = new ProveedoresAdapter();
        proveedoresVL = findViewById(R.id.proveedoresRecyclerV);
        proveedoresVL.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        proveedoresVL.setAdapter(proveedoresAdapter);
        proveedoresVL.setLayoutManager(layoutManager);


        myProduct = (Producto) getIntent().getExtras().getSerializable("miProducto");
        proveedoresAdapter.setProducto(myProduct);
        proveedoresRef = db.collection("Productos").document(myProduct.getId()).collection("Proveedores");
        updateProveedores();
    }
    public void updateProveedores(){
        proveedoresAdapter.clearList();
        proveedoresRef.get().addOnCompleteListener(
                task->{
                    for (DocumentSnapshot doc: task.getResult().getDocuments()){
                      //  Log.e("AQUI", String.valueOf(task.getResult().size()));
                        Proveedor dbProveedor = doc.toObject(Proveedor.class);
                        dbProveedor.setId(doc.getId());
                        proveedoresAdapter.addProveedor(dbProveedor);
                    }
                }
        );

    }
}