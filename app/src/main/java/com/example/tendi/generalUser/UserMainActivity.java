package com.example.tendi.generalUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.tendi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserMainActivity extends AppCompatActivity {

    private HomeUserFragment homeUserFragment;
    private PedidosUserFragment pedidosUserFragment;
    private PerfilUserFragment perfilUserFragment;
    private BottomNavigationView navBarU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        navBarU = findViewById(R.id.navBarU);


        homeUserFragment = HomeUserFragment.newInstance();
        pedidosUserFragment = PedidosUserFragment.newInstance();
        perfilUserFragment = PerfilUserFragment.newInstance();

        showFragment(homeUserFragment);

        navBarU.setOnNavigationItemSelectedListener(
                (menuItem) ->{
                    switch (menuItem.getItemId()){
                        case R.id.homeU:
                            showFragment(homeUserFragment);
                            break;
                        case R.id.pedidosU:
                            showFragment(pedidosUserFragment);
                            break;
                        case R.id.perfilU:
                            showFragment(perfilUserFragment);
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
}