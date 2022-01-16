package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.telecom.Call;
import android.view.Menu;
import  android.view.MenuItem;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainPage extends AppCompatActivity {
    public TextView textview;
    public LinearLayout ll1, ll2, ll3;
    public ImageView hyd, delhi, mumbai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
//        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        hyd = findViewById(R.id.hyd);
        delhi = findViewById(R.id.delhi);
        mumbai = findViewById(R.id.mumbai);
        SharedPreferences sp = getSharedPreferences("myapp", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        hyd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainPage.this, "Hyderabad", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainPage.this, Cars.class);
                String city = "Hyderabad";
                ed.putString("city", city);
                ed.apply();
                startActivity(intent);
            }
        });
        delhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainPage.this, "Delhi", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainPage.this, Cars.class);
                String city = "Delhi";
                ed.putString("city", city);
                ed.apply();
                startActivity(intent);
            }
        });
        mumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainPage.this, "Mumbai", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainPage.this, Cars.class);
                String city = "Mumbai";
                ed.putString("city", city);
                ed.apply();
                startActivity(intent);
            }
        });

    }
}