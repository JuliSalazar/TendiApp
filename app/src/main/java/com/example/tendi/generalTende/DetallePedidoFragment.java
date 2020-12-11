package com.example.tendi.generalTende;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tendi.R;
import com.example.tendi.util.Constants;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;


public class DetallePedidoFragment extends Fragment {


    private TextView pedidoFrom;
    private TextView totalpriceTV;
    private TextView totalpriceTV2;
    private TextView productTV;
    private TextView priceproduTV;

    private DatabaseReference ref;
    private DataSnapshot datas;

    private Button confirm;

    public DetallePedidoFragment() {
        // Required empty public constructor
    }


    public static DetallePedidoFragment newInstance() {
        DetallePedidoFragment fragment = new DetallePedidoFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detalle_pedido, container, false);

        ref = Constants.refDB.child("Tenderos").child("1234").child("Pedidos");
        pedidoFrom = root.findViewById(R.id.pedidoFromTV);
        totalpriceTV = root.findViewById(R.id.totalpriceTV);
        totalpriceTV2 = root.findViewById(R.id.totalprice2TV);
        priceproduTV = root.findViewById(R.id.priceInfoTV);
        productTV = root.findViewById(R.id.productTV);


        confirm = root.findViewById(R.id.confirmBTN);



        confirm.setOnClickListener(
                (v)->{
                    ref.child("Pedido").child("Estado").setValue("confirmado");
                    Toast.makeText(getContext(), "¡Pedido Confirmado!", Toast.LENGTH_LONG).show();
                    confirm.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.finan));
                    confirm.setText(getResources().getText(R.string.pediListo));
                }
        );

        pedidoFrom.setText("Valentina Ramirez");
        totalpriceTV.setText("$ 800");
        productTV.setText("Galletas vainillas");
        priceproduTV.setText("$ 800");
        totalpriceTV2.setText("$ 800");


        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return root;
    }
}