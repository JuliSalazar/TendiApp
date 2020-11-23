package com.example.tendi.generalUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.tendi.R;
import com.example.tendi.usuario.Usuario;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserMainActivity extends AppCompatActivity {

    private HomeUserFragment homeUserFragment;
    private PedidosUserFragment pedidosUserFragment;
    private PerfilUserFragment perfilUserFragment;
    private BottomNavigationView navBarU;
    private Usuario myUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        navBarU = findViewById(R.id.navBarT);


        homeUserFragment = HomeUserFragment.newInstance();
        pedidosUserFragment = PedidosUserFragment.newInstance();
        perfilUserFragment = PerfilUserFragment.newInstance();

        myUser = (Usuario) getIntent().getExtras().getSerializable("myUser");

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
        Bundle bund = new Bundle();
        bund.putSerializable("user",myUser);
        fragment.setArguments(bund);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerU,fragment);
        transaction.commit();
    }
}