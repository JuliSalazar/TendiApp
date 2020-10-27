package com.example.tendi.general;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.RemoteViews;

import com.example.tendi.R;
import com.example.tendi.util.Constants;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public class HomeActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private AsistenteFragment asistenteFragment;
    private InventarioFragment inventarioFragment;
    private PerfilFragment perfilFragment;
    private BottomNavigationView navBar;

    private DatabaseReference ref =  Constants.refDB.child("Tenderos").child("1234").child("Pedidos");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navBar = findViewById(R.id.navBar);


        homeFragment = HomeFragment.newInstance();
        asistenteFragment = AsistenteFragment.newInstance();
        inventarioFragment = InventarioFragment.newInstance();
        perfilFragment = PerfilFragment.newInstance();

        showFragment(asistenteFragment);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                notfication(dataSnapshot.child("Name").getValue().toString());

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

        navBar.setOnNavigationItemSelectedListener(
                (menuItem) ->{
                    switch (menuItem.getItemId()){
                        case R.id.home:
                            showFragment(homeFragment);
                            break;
                        case R.id.asistent:
                            showFragment(asistenteFragment);
                            break;
                        case R.id.invent:
                            showFragment(inventarioFragment);
                            break;

                        case R.id.perfil:
                            showFragment(perfilFragment);
                            break;

                    }
                    return true;
                }
        );


    }


    public void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer,fragment);
        transaction.commit();
    }

    private void notfication(String name){
        Log.e("NOTI", name);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel =
                    new NotificationChannel("n", "n", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"n")
                .setContentText("Tendi")
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.logotendi)
                .setContentText(name+" Solicitó un pedido.");
                //.setContent(customNotfi(name));
               /*

        builder = builder.setContent(customNotfi(name));*/
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(999, builder.build());

    }
    private RemoteViews customNotfi(String title){
        RemoteViews rV = new RemoteViews(getApplicationContext().getPackageName(),R.layout.notification);
        rV.setTextViewText(R.id.nameNotif, title);
        return rV;
    }

}