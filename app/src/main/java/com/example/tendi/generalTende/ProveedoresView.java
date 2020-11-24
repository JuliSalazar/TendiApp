package com.example.tendi.generalTende;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tendi.R;
import com.example.tendi.model.Producto;
import com.example.tendi.model.Proveedor;

public class ProveedoresView extends RecyclerView.ViewHolder implements View.OnClickListener{

    //ESTE ES EL VIEW DE LOS PROVEEDORES EN PANTALLA DE COMPRA DE PRODUCTOS CON PROVEEDORES DEL TENDERO

    private ConstraintLayout root;
    private ImageView img;
    private TextView name;
    private TextView pUnidad;
    private TextView pDocena;
    private TextView pCargo;
    private ProveedoresView.onProveedorItemAction listener;
    private Proveedor proveedor;

    public ProveedoresView(ConstraintLayout root) {
        super(root);
        this.root = root;
        img = root.findViewById(R.id.imgProveedor);
        name = root.findViewById(R.id.nombreProveedor);
        pUnidad = root.findViewById(R.id.precioUnidadTVProveedor);
        pDocena = root.findViewById(R.id.precioDocenaTVProveedor);
        pCargo = root.findViewById(R.id.precioCargoTVProveedor);
        this.root.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.showDetail(this.proveedor,this.root);
        }
    }

    public interface onProveedorItemAction{
        void showDetail(Proveedor proveedor, View v);
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setListener(onProveedorItemAction listener) {
        this.listener = listener;
    }

    public ConstraintLayout getRoot() {
        return root;
    }

    public ImageView getImg() {
        return img;
    }

    public TextView getName() {
        return name;
    }

    public TextView getpUnidad() {
        return pUnidad;
    }

    public TextView getpDocena() {
        return pDocena;
    }

    public TextView getpCargo() {
        return pCargo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
}
