package com.example.tendi.generalTende;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tendi.R;


public class InventarioFragment extends Fragment {


    public InventarioFragment() {
        // Required empty public constructor
    }

    public static InventarioFragment newInstance() {
        InventarioFragment fragment = new InventarioFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventario, container, false);
    }
}