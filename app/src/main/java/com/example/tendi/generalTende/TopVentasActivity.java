package com.example.tendi.generalTende;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.tendi.R;

public class TopVentasActivity extends AppCompatActivity {

    private ImageButton backTopVentasBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_ventas);

        backTopVentasBtn = findViewById(R.id.backTopVentasBtn);

        backTopVentasBtn.setOnClickListener(
                (v) -> {
                    finish();
                }
        );
    }
}