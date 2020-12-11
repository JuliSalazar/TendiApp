package com.example.tendi.generalUser;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tendi.R;


public class PerfilUserFragment extends Fragment {

    private TextView name;
    private TextView phone;
    private TextView state;
    private TextView money;
    private String nombre;
    private String number;
    private String estatus;
    private String cash;

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

        View root = inflater.inflate(R.layout.fragment_perfil_user, container, false);

        name = root.findViewById(R.id.nombreusuario);
        phone = root.findViewById(R.id.numerotell);
        state = root.findViewById(R.id.estadoCuenta);
        money = root.findViewById(R.id.dinero);

        nombre = "Nombre: Valentina Ramirez";

        SpannableStringBuilder ss = new SpannableStringBuilder(nombre);
        ForegroundColorSpan fscBlack = new ForegroundColorSpan(Color.DKGRAY);
        ss.setSpan(fscBlack, 7, 25, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

      name.setText(ss);

        number = "Telefono: 312 397 8127";

        SpannableStringBuilder ss2 = new SpannableStringBuilder(number);
               ss2.setSpan(fscBlack, 10, 22, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        phone.setText(ss2);

        estatus = "Estado de la cuenta: Activo";

        SpannableStringBuilder ss3 = new SpannableStringBuilder(estatus);
        ss3.setSpan(fscBlack, 21, 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        state.setText(ss3);

        cash = "$ 28.000";

        SpannableStringBuilder ss4 = new SpannableStringBuilder(cash);
        ForegroundColorSpan fscGreen = new ForegroundColorSpan(Color.parseColor("#38BF7E"));
        ss4.setSpan(fscGreen, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        money.setText(ss4);
        return root;
    }
}