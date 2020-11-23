package com.example.tendi.generalTende;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tendi.R;
import com.example.tendi.model.Producto;

public class ProductInvetView extends RecyclerView.ViewHolder implements View.OnClickListener {

    //ESTE ES EL VIEW DE LOS PRODUCTOS EN EL INVENTARIO DEL TENDERO

    private ConstraintLayout root;
    private ImageView img;
    private TextView name;
    private Button units;
    private ImageButton editProduct;
    private onProductItemAction listener;
    private Producto producto;

    public ProductInvetView(ConstraintLayout root) {
        super(root);
        this.root = root;
        name = root.findViewById(R.id.nameProductTV);
        img = root.findViewById(R.id.imgProductInvent);
        units = root.findViewById(R.id.undsBTN);
        editProduct = root.findViewById(R.id.editProductBTN);

        editProduct.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.editProductBTN:
                if (listener!=null){
                    listener.editProduct(this.producto,this.root);
                }
                break;
        }
    }

    public interface onProductItemAction{
        void editProduct(Producto product, View v);
    }

    public void setProducto(Producto product) {
        this.producto = product;
    }


    public void setListener(onProductItemAction listener) {
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

    public Button getUnits() {
        return units;
    }

    public ImageButton getEditProduct() {
        return editProduct;
    }
}
