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


public class PedidosUserFragment extends Fragment {

    private TextView timeTv;
    private TextView totalpago;
    private String tiempo;
    private String pago;

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
        View root = inflater.inflate(R.layout.fragment_pedidos_user, container, false);

        timeTv = root.findViewById(R.id.timer);
        totalpago = root.findViewById(R.id.totalprecio);

        tiempo = "Hace 1 minuto";

        SpannableStringBuilder ss = new SpannableStringBuilder(tiempo);
        StyleSpan bold = new StyleSpan(android.graphics.Typeface.BOLD);
        ss.setSpan(bold, 5, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        timeTv.setText(ss);

        pago = "Total a pagar: $ 2.000";

        SpannableStringBuilder ss2 = new SpannableStringBuilder(pago);
        ForegroundColorSpan fscOrange = new ForegroundColorSpan(Color.parseColor("#FE811E"));
        ss2.setSpan(fscOrange,15 , 22, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        totalpago.setText(ss2);
        return root;
    }
}