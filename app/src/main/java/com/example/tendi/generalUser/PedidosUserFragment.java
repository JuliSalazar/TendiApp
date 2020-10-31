package com.example.tendi.generalUser;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tendi.R;


public class PedidosUserFragment extends Fragment {

    public PedidosUserFragment() {
        // Required empty public constructor
    }

    public static PedidosUserFragment newInstance() {
        PedidosUserFragment fragment = new PedidosUserFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pedidos_user, container, false);
    }
}