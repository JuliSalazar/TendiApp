package com.example.tendi.generalTende;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tendi.R;
import com.example.tendi.model.Producto;
import com.example.tendi.model.Proveedor;

import java.io.Serializable;
import java.util.ArrayList;

public class ProveedoresAdapter extends RecyclerView.Adapter<ProveedoresView> implements ProveedoresView.onProveedorItemAction{

    private ArrayList<Proveedor> proveedores;
    private Producto producto;

    public ProveedoresAdapter() {
        this.proveedores = new ArrayList<>();
    }

    public void addProveedor(Proveedor proveedor){
        proveedores.add(proveedor);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProveedoresView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.proveedorview,parent,false);
        ConstraintLayout CLroot = (ConstraintLayout) root;
        ProveedoresView proveedoresView = new ProveedoresView(CLroot);
        proveedoresView.setListener(this);
        return proveedoresView;
    }

    @Override
    public void onBindViewHolder(@NonNull ProveedoresView holder, int position) {
        Proveedor proveedor = proveedores.get(position);
        holder.getName().setText(proveedor.getNombre());
        holder.getpUnidad().setText("$ "+proveedor.getPrecioUnidad());
        holder.getpDocena().setText("$ "+proveedor.getPrecioDocena());
        holder.getpCargo().setText("$ "+proveedor.getPrecioCargo());
        Glide.with(holder.getRoot()).load(proveedor.getImg()).into(holder.getImg());
        holder.setProveedor(proveedor);

    }

    @Override
    public int getItemCount() {
        return proveedores.size();
    }

    public void clearList() {
        proveedores.clear();
        this.notifyDataSetChanged();
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public void showDetail(Proveedor proveedor, View v) {
        Intent i = new Intent(v.getContext(), DetalleCompraProveedor.class);
        i.putExtra("elProveedor", (Serializable) proveedor);
        i.putExtra("elProducto", (Serializable) this.producto);
        v.getContext().startActivity(i);
    }
}
