package com.example.tendi.generalTende;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tendi.R;
import com.example.tendi.model.Producto;

public class ComprarProductView extends RecyclerView.ViewHolder implements View.OnClickListener{

    //ESTE ES EL VIEW DE LOS PRODUCTOS EN PANTALLA DE COMPRA DE PRODUCTOS CON PROVEEDORES DEL TENDERO

    private ConstraintLayout root;
    private ImageView img;
    private TextView name;
    private ComprarProductView.onProductItemAction listener;
    private Producto producto;

    public ComprarProductView(ConstraintLayout root) {
        super(root);
        this.root = root;
        img = root.findViewById(R.id.comprarproductimg);
        name = root.findViewById(R.id.comprarproductoTV);
        this.root.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.showProveedor(this.producto,this.root);
        }

    }

    public interface onProductItemAction{
        void showProveedor(Producto product, View v);
    }

    public void setListener(onProductItemAction listener) {
        this.listener = listener;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    public Producto getProducto() {
        return producto;
    }
}
