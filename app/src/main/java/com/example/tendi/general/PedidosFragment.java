package com.example.tendi.general;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tendi.R;


public class PedidosFragment extends Fragment {


    public PedidosFragment() {
        // Required empty public constructor
    }

    public static PedidosFragment newInstance() {
        PedidosFragment fragment = new PedidosFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pedidos, container, false);
    }
}