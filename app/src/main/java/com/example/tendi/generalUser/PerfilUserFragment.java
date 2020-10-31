package com.example.tendi.generalUser;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tendi.R;


public class PerfilUserFragment extends Fragment {


    public PerfilUserFragment() {
        // Required empty public constructor
    }

    public static PerfilUserFragment newInstance() {
        PerfilUserFragment fragment = new PerfilUserFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil_user, container, false);
    }
}