package com.example.tendi.generalTende;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.tendi.R;


public class AsistenteFragment extends Fragment implements View.OnClickListener{

    private ImageButton pedidosBTN;
    private PedidosFragment pedidosFragment;
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
        View root = inflater.inflate(R.layout.fragment_asistente, container, false);
        // Inflate the layout for this fragment
        pedidosBTN = root.findViewById(R.id.pedidosBTN);
        pedidosBTN.setOnClickListener(this);


        return root;
    }

    public ImageButton getPedidosBTN() {
        return pedidosBTN;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pedidosBTN:
                Intent intent = new Intent(getActivity(),Pedidos.class);
                startActivity(intent);
                /* Crear fragmento de tu clase
                Fragment fragment = new PedidosFragment();
                // Obtener el administrador de fragmentos a través de la actividad
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                // Definir una transacción
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                // Remplazar el contenido principal por el fragmento
                fragmentTransaction.replace(R.id.fragmentContainer, fragment);
                fragmentTransaction.addToBackStack(null);
                // Cambiar
                fragmentTransaction.commit();*/
                break;
        }
    }
}