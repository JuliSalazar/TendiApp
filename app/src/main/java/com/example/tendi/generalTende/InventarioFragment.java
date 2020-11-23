package com.example.tendi.generalTende;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tendi.R;
import com.example.tendi.model.Producto;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class InventarioFragment extends Fragment {

    private RecyclerView productsViewList;
    private GridLayoutManager layoutManager;
    private ProductsTendAdapter adapater;
    private FirebaseFirestore db;
    private CollectionReference productsRef;

    public InventarioFragment() {
        // Required empty public constructor
    }

    public static InventarioFragment newInstance() {
        InventarioFragment fragment = new InventarioFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_inventario, container, false);

        productsViewList = root.findViewById(R.id.productViewInvetList);
        layoutManager = new GridLayoutManager(root.getContext(),2);
        adapater  = new ProductsTendAdapter();
        db = FirebaseFirestore.getInstance();
        productsViewList.setAdapter(adapater);
        productsViewList.setLayoutManager(layoutManager);
        productsViewList.setHasFixedSize(true);
        productsRef = db.collection("Productos");

        updateProducts();

        // Inflate the layout for this fragment
        return root;
    }
    public void updateProducts(){
        adapater.clearList();
        productsRef.get().addOnCompleteListener(
                task->{
                    for (DocumentSnapshot doc: task.getResult().getDocuments()){
                        Log.e("Consola", doc.getId());
                        Producto dbProduct = doc.toObject(Producto.class);
                        dbProduct.setId(doc.getId());
                        adapater.addProduct(dbProduct);
                    }
                }
        );

    }
}