package com.example.tendi.generalTende;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.transition.Transition;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tendi.R;


public class AsistenteFragment extends Fragment{

    private int progress;

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


        Button ventasBtn = root.findViewById(R.id.ventasBtn);
        Button finanzasBtn = root.findViewById(R.id.finanzasBtn);
        Button beneficiosBtn = root.findViewById(R.id.beneficiosBtn);

        Button ventasBtnClickable = root.findViewById(R.id.ventasBtnClickable);
        Button finanzasBtnClickable = root.findViewById(R.id.finanzasBtnClickable);
        Button beneficiosBtnClickable = root.findViewById(R.id.beneficiosBtnClickable);

        LinearLayout progressBarValue = root.findViewById(R.id.progressBarValue);
        TextView progresText = root.findViewById(R.id.progressValueTV);
        progress = 10;
        progresText.setText(progress+" %");

        ImageView creditos = root.findViewById(R.id.creditosImageView);
        //progressBarValue.setLayoutParams(new LinearLayout.LayoutParams(40,progress));



        creditos.setOnClickListener(
                (v) -> {
                    Intent intent = new Intent(getActivity(),BeneficioCredito.class);
                    startActivity(intent);
                }
        );

        ventasBtnClickable.setOnClickListener(
                (v) -> {
                    ventasBtn.setVisibility(View.VISIBLE);
                    finanzasBtn.setVisibility(View.INVISIBLE);
                    beneficiosBtn.setVisibility(View.INVISIBLE);
                    ventasBtn.performClick();
                    ventasBtnClickable.setClickable(false);
                    finanzasBtnClickable.setClickable(true);
                    beneficiosBtnClickable.setClickable(true);
                }
        );

        finanzasBtnClickable.setOnClickListener(
                (v) -> {
                    ventasBtn.setVisibility(View.INVISIBLE);
                    finanzasBtn.setVisibility(View.VISIBLE);
                    beneficiosBtn.setVisibility(View.INVISIBLE);
                    finanzasBtn.performClick();
                    ventasBtnClickable.setClickable(true);
                    finanzasBtnClickable.setClickable(false);
                    beneficiosBtnClickable.setClickable(true);
                }
        );

        beneficiosBtnClickable.setOnClickListener(
                (v) -> {
                    ventasBtn.setVisibility(View.INVISIBLE);
                    finanzasBtn.setVisibility(View.INVISIBLE);
                    beneficiosBtn.setVisibility(View.VISIBLE);
                    beneficiosBtn.performClick();
                    ventasBtnClickable.setClickable(true);
                    finanzasBtnClickable.setClickable(true);
                    beneficiosBtnClickable.setClickable(false);
                }
        );

        return root;
    }

}