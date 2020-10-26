package com.example.tendi.general;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tendi.R;


public class AsistenteFragment extends Fragment {
    
    //State


    public AsistenteFragment() {
        // Required empty public constructor
    }

    public static AsistenteFragment newInstance() {
        AsistenteFragment fragment = new AsistenteFragment();
        Bundle args = new Bundle();
      //  args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_asistente, container, false);
    }
}