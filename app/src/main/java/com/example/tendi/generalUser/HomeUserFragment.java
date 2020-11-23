package com.example.tendi.generalUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tendi.R;
import com.example.tendi.usuario.Usuario;

import java.lang.reflect.Array;


public class HomeUserFragment extends Fragment {

    private ImageButton la11Btn;
    private TextView welcome;
    private Usuario myUser;

    public HomeUserFragment() {
        // Required empty public constructor
    }
    public static HomeUserFragment newInstance() {
        HomeUserFragment fragment = new HomeUserFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View root = inflater.inflate(R.layout.fragment_home_user, container, false);
        la11Btn = root.findViewById(R.id.la11Btn);
        welcome = root.findViewById(R.id.welcomeTV);
        if (getArguments()!=null){
            myUser = (Usuario) getArguments().getSerializable("user");
            String[] nameUser =  myUser.getName().split(" ");
            welcome.setText("¡Hola " + nameUser[0]+ "!");
        }

        la11Btn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(getActivity(), TendActivity.class);
                    startActivity(i);
                }
        );
        return root;
    }
}