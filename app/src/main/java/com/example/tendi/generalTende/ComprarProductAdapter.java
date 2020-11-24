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
import com.example.tendi.model.Producto;

import java.io.Serializable;
import java.util.ArrayList;

public class ComprarProductAdapter extends RecyclerView.Adapter<ComprarProductView> implements ComprarProductView.onProductItemAction{

    private ArrayList<Producto> productos;

    public ComprarProductAdapter() {
        this.productos = new ArrayList<>();
    }

    public void addProducto(Producto producto){
        productos.add(producto);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ComprarProductView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.compraproductoview,parent,false);
        ConstraintLayout CLroot = (ConstraintLayout) root;
        ComprarProductView comprarProductView = new ComprarProductView(CLroot);
        comprarProductView.setListener(this);
        return comprarProductView;
    }

    @Override
    public void onBindViewHolder(@NonNull ComprarProductView holder, int position) {

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
    public void showProveedor(Producto product, View v) {
        Intent i = new Intent(v.getContext(), Proveedor.class);
        i.putExtra("producto", (Serializable) product);
        v.getContext().startActivity(i);
    }
}
