package com.example.tendi.model;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tendi.R;

public class ProductView extends RecyclerView.ViewHolder {

private CardView productView;
private CardView imgProduct;
private TextView productViewTV;
private TextView priceViewTV;

    public ProductView(CardView productView) {
        super(productView);
        this.productView = productView;
        productViewTV = productView.findViewById(R.id.productVTV);
        priceViewTV = productView.findViewById(R.id.priceVTV);

    }

    public CardView getProductView() {
        return productView;
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
