package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Cars extends AppCompatActivity {
    public ImageView car1,car2, car3, car4, car5, car6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        car1 = findViewById(R.id.car1);
        car2 = findViewById(R.id.car2);
        car3 = findViewById(R.id.car3);
        car4 = findViewById(R.id.car4);
        car5 = findViewById(R.id.car5);
        car6 = findViewById(R.id.car6);
        SharedPreferences sp = getSharedPreferences("myapp", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        car1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cars.this, Details1.class);
                int cost = 150;
                ed.putInt("cost",cost);
                ed.apply();
                startActivity(intent);
            }
        });
        car2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cars.this, Details1.class);
                String cost = "100";
                ed.putString("cost",cost);
                ed.apply();
                startActivity(intent);
            }
        });
        car3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cars.this, Details1.class);
                String cost = "190";
                ed.putString("cost",cost);
                ed.apply();
                startActivity(intent);
            }
        });
        car4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cars.this, Details1.class);
                String cost = "250";
                ed.putString("cost",cost);
                ed.apply();
                startActivity(intent);
            }
        });
        car5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cars.this, Details1.class);
                String cost = "300";
                ed.putString("cost",cost);
                ed.apply();
                startActivity(intent);
            }
        });
        car6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cars.this, Details1.class);
                String cost = "400";
                ed.putString("cost",cost);
                ed.apply();
                startActivity(intent);
            }
        });

    }
}