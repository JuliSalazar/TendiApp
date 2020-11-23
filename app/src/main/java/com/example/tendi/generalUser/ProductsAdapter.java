package com.example.tendi.generalUser;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tendi.R;
import com.example.tendi.model.ProductView;
import com.example.tendi.model.Producto;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductView> {

    private ArrayList<Producto> productos;


    public ProductsAdapter() {
        this.productos = new ArrayList<>();
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
        ConstraintLayout rowroot = (ConstraintLayout) row;
        ProductView productView = new ProductView(rowroot);
        return productView;


    }

    @Override
    public void onBindViewHolder(@NonNull ProductView holder, int position) {
        Producto producto = productos.get(position);
        holder.getNombre().setText(producto.getNombre());
        holder.getPrecio().setText("$ "+producto.getPrecio());
        Glide.with(holder.getContainer()).load(producto.getImg()).into(holder.getImgProduct());
        holder.setProducto(producto);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public void clearList() {
        productos.clear();
        this.notifyDataSetChanged();
    }




}
