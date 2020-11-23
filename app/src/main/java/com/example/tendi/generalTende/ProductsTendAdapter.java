package com.example.tendi.generalTende;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tendi.R;
import com.example.tendi.model.ProductView;
import com.example.tendi.model.Producto;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductsTendAdapter extends RecyclerView.Adapter<ProductInvetView> implements ProductInvetView.onProductItemAction{

    private ArrayList<Producto> productos;

    public ProductsTendAdapter() {
        this.productos = new ArrayList<>();
    }

    public void addProduct(Producto producto){
        productos.add(producto);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductInvetView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.productviewinvent,parent,false);
        ConstraintLayout rowroot = (ConstraintLayout) row;
        ProductInvetView productInvetView = new ProductInvetView(rowroot);
        productInvetView.setListener(this);
        return productInvetView;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductInvetView holder, int position) {
        Producto producto = productos.get(position);
        holder.getName().setText(producto.getNombre());
       // holder.getUnits().setText();
        Glide.with(holder.getRoot()).load(producto.getImg()).into(holder.getImg());
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

    @Override
    public void editProduct(Producto product, View v) {
        Intent i = new Intent(v.getContext(), EditProductActivity.class);
        i.putExtra("producto", (Serializable) product);
        v.getContext().startActivity(i);

    }
}
