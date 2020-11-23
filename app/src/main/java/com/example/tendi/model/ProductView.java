package com.example.tendi.model;

import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tendi.R;

public class ProductView extends RecyclerView.ViewHolder {

    //ESTE ES EL VIEW DE LOS PRODUCTOS EN LA TIENDA VISTA DESDE EL COMPRADOR

private ConstraintLayout productView;
private CardView imgProduct;
private TextView productViewTV;
private TextView priceViewTV;

    public ProductView(ConstraintLayout productView) {
        super(productView);
        this.productView = productView;
        productViewTV = productView.findViewById(R.id.nameProductTV);
        priceViewTV = productView.findViewById(R.id.cantidadProductTV);

    }

    public CardView getImgProduct() {
        return imgProduct;
    }

    public TextView getProductViewTV() {
        return productViewTV;
    }

    public TextView getPriceViewTV() {
        return priceViewTV;
    }
}
