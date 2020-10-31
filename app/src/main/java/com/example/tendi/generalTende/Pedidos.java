package com.example.tendi.generalTende;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tendi.R;
import com.example.tendi.util.Constants;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public class Pedidos extends AppCompatActivity {

    private ImageButton dellateBTN;
    private ImageButton arrowWhiteBTN;
    private TextView nameTV;
    private TextView priceTV;
    private DatabaseReference ref = Constants.refDB.child("Tenderos").child("1234").child("Pedidos");
    private DetallePedidoFragment detallePedidoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);



        detallePedidoFragment = DetallePedidoFragment.newInstance();

        dellateBTN = findViewById(R.id.detalleBTN);
        arrowWhiteBTN = findViewById(R.id.arrowWhiteBTN);
        nameTV = findViewById(R.id.nameTV);
        priceTV = findViewById(R.id.priceTV);


        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                nameTV.setText(dataSnapshot.child("Name").getValue().toString());
                priceTV.setText(dataSnapshot.child("Precio").getValue().toString());
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

        dellateBTN.setOnClickListener(
                (v)->{
                    showFragment(detallePedidoFragment);
                }
        );

    }
    public void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragConta,fragment);
        transaction.commit();
    }
}