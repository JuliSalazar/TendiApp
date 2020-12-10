package com.example.tendi.generalTende;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tendi.R;


public class PerfilFragment extends Fragment {


    private TextView propietariotv;
    private TextView dinerotv;
    private String text;
    private String dinero;

    public PerfilFragment() {
        // Required empty public constructor
    }

    public static PerfilFragment newInstance() {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        propietariotv = root.findViewById(R.id.textView56);
        dinerotv = root.findViewById(R.id.textView60);


        text = "Propietario: Oscar Giraldo";
        SpannableStringBuilder ss = new SpannableStringBuilder(text);
        ForegroundColorSpan fscBlack = new ForegroundColorSpan(Color.DKGRAY);
        ss.setSpan(fscBlack,13, 26, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        propietariotv.setText(ss);


        dinero = "$ 1’547.500";
        SpannableStringBuilder ss2 = new SpannableStringBuilder(dinero);
        ForegroundColorSpan fscGreen = new ForegroundColorSpan(Color.parseColor("#38BF7E"));
        ss2.setSpan(fscGreen,0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        dinerotv.setText(ss2);


        return root;


    }
}