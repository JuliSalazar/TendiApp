package com.example.tendi.general;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

import com.example.tendi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private AsistenteFragment asistenteFragment;
    private InventarioFragment inventarioFragment;
    private PerfilFragment perfilFragment;
    private BottomNavigationView navBar;

    private ImageButton pedidosBTN;
    private PedidosFragment pedidosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navBar = findViewById(R.id.navBar);

        pedidosBTN = findViewById(R.id.pedidosBTN);

        homeFragment = HomeFragment.newInstance();
        asistenteFragment = AsistenteFragment.newInstance();
        inventarioFragment = InventarioFragment.newInstance();
        perfilFragment = PerfilFragment.newInstance();

        pedidosFragment = PedidosFragment.newInstance();
        showFragment(asistenteFragment);

        if(pedidosBTN != null){

            pedidosBTN.setOnClickListener(
                    (v)->{
                        Log.e("desdeActivity","HOLA");
                       // showFragment(pedidosFragment);
                    }
            );
        }


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
}