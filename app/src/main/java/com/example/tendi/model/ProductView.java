package com.example.tendi.model;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tendi.R;

public class ProductView extends RecyclerView.ViewHolder {

    //ESTE ES EL VIEW DE LOS PRODUCTOS EN LA TIENDA VISTA DESDE EL COMPRADOR

private ConstraintLayout container;
private ImageView imgProduct;
private TextView nombre;
private TextView precio;
private Producto producto;

    public ProductView(ConstraintLayout container) {
        super(container);
        this.container = container;
        nombre = container.findViewById(R.id.nameProductUserTV);
        precio = container.findViewById(R.id.priceProductUserTV);
        imgProduct = container.findViewById(R.id.imgProductUser);

    }

    public ConstraintLayout getContainer() {
        return container;
    }

    public void setProducto(Producto product) {
        this.producto = product;
    }

    public ImageView getImgProduct() {
        return imgProduct;
    }

    public TextView getNombre() {
        return nombre;
    }

    public TextView getPrecio() {
        return precio;
    }
}
