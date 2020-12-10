package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.RemoteViews;

import com.example.tendi.R;
import com.example.tendi.usuario.Usuario;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private AsistenteFragment asistenteFragment;
    private InventarioFragment inventarioFragment;
    private NotifFragment notiFragment;
    private PerfilFragment perfilFragment;
    private BottomNavigationView navBar;
    private Usuario myUser;
    private ImageButton pedidosBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navBar = findViewById(R.id.navBarT);

        asistenteFragment = AsistenteFragment.newInstance();
        inventarioFragment = InventarioFragment.newInstance();
        notiFragment = NotifFragment.newInstance();
        perfilFragment = PerfilFragment.newInstance();
        pedidosBTN= findViewById(R.id.pedidosBTN);




        if(getIntent().getExtras().getSerializable("NewTend") != null){
            myUser = (Usuario) getIntent().getExtras().getSerializable("NewTend");
            Intent i = new Intent(this, InstruccionesPopUp.class);
            i.putExtra("userName",myUser.getName());
            startActivityForResult(i, 14);
        }else{
            myUser = (Usuario) getIntent().getExtras().getSerializable("myUser");
          /*  Intent i = new Intent(this, InstruccionesPopUp.class);
            i.putExtra("userName",myUser.getName());
            startActivityForResult(i, 13);*/
        }

        Log.e("CONSOLA", String.valueOf(getIntent().getExtras().getSerializable("myUser")));
        Log.e("CONSOLA", String.valueOf(getIntent().getExtras().getSerializable("NewTend")));

        showFragment(asistenteFragment);

        pedidosBTN.setOnClickListener(
                (v) -> {
                    Intent intent = new Intent(this,Pedidos.class);
                    startActivity(intent);
                }
        );


        navBar.setOnNavigationItemSelectedListener(
                (menuItem) ->{
                    switch (menuItem.getItemId()){
                        case R.id.pedidosU:
                            showFragment(asistenteFragment);
                            break;
                        case R.id.invent:
                            showFragment(inventarioFragment);
                            break;

                        case R.id.notif:
                            showFragment(notiFragment);
                            break;

                        case R.id.perfilU:
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
        transaction.replace(R.id.fragmentContainerU,fragment);
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