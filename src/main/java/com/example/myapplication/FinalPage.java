package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalPage extends AppCompatActivity {
 public TextView Name, PhNum, DrivingID, Mail, SDate, LDate, TCost, Home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        Name = findViewById(R.id.Name);
        PhNum = findViewById(R.id.PhNum);
        DrivingID = findViewById(R.id.DrivingID);
        Mail = findViewById(R.id.Mail);
        SDate = findViewById(R.id.SDate);
        LDate = findViewById(R.id.LDate);
        TCost = findViewById(R.id.TCost);
        Home = findViewById(R.id.Home);
        SharedPreferences sp = getSharedPreferences("myapp", MODE_PRIVATE);
        Name.setText(sp.getString("fullName", ""));
        PhNum.setText(sp.getString("phNo", ""));
        DrivingID.setText(sp.getString("driveID", ""));
        Mail.setText(sp.getString("Email", ""));
        SDate.setText(sp.getString("startDate", ""));
        LDate.setText(sp.getString("endDate", ""));
        TCost.setText(Integer.toString(Integer.parseInt(sp.getString("hours", "")) * Integer.parseInt(sp.getString("cost", ""))));
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalPage.this, MainPage.class);
                startActivity(intent);
            }
        });
    }
}