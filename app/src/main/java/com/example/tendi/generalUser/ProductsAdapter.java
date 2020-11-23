package com.example.tendi.generalUser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tendi.R;
import com.example.tendi.model.ProductView;
import com.example.tendi.model.Producto;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductView> {

    private ArrayList<Producto> productos;


    public ProductsAdapter() {
        productos = new ArrayList<>();

      //  productos.add(new Producto("Oreo","800"));

    }

    public void  addProduct(Producto producto){
        productos.add(producto);
        this.notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ProductView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.productrow, null);
        CardView rowroot = (CardView) row;
        ProductView productView = new ProductView(rowroot);

        return productView;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductView holder, int position) {
        holder.getProductViewTV().setText(productos.get(position).getId());
        holder.getPriceViewTV().setText(productos.get(position).getPrecio());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }





}
