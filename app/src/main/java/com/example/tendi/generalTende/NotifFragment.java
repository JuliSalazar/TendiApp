package com.example.tendi.generalTende;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tendi.R;
import com.example.tendi.generalUser.TendActivity;


public class NotifFragment extends Fragment {

private Button gopedidos;

    public NotifFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NotifFragment newInstance() {
        NotifFragment fragment = new NotifFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_notif, container, false);

        gopedidos = root.findViewById(R.id.goPedido);

        gopedidos.setOnClickListener(
                (v)->{
                    Intent i = new Intent(getActivity(), Pedidos.class);
                    startActivity(i);
                }
        );
       return root;
    }


}