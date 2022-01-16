package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Details1 extends AppCompatActivity {

    public TextView tvCity, tvcost;
    public EditText FullName, DriveID, PhNo, Hours, StartDate, EndDate;
    public Button booking, getcost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details1);
        tvCity = findViewById(R.id.tvCity);
        booking = findViewById(R.id.booking);
        FullName= findViewById(R.id.FullName);
        DriveID = findViewById(R.id.DriveID);
        PhNo= findViewById(R.id.PhNo);
        Hours = findViewById(R.id.Hours);
        StartDate = findViewById(R.id.StartDate);
        EndDate = findViewById(R.id.EndDate);
        getcost = findViewById(R.id.getcost);
        tvcost = findViewById(R.id.tvcost);
        SharedPreferences sp = getSharedPreferences("myapp", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        tvCity.setText(sp.getString("city", ""));
        getcost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Hours.getText().toString().isEmpty()) {
                    Toast.makeText(Details1.this, "Enter Number of Hours", Toast.LENGTH_SHORT).show();
                } else {
                    int total = Integer.parseInt(Hours.getText().toString()) * Integer.parseInt(sp.getString("cost", ""));
                    tvcost.setText(Integer.toString(total));
                }
            }
        });
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String fullName = FullName.getText().toString();
                String driveID = DriveID.getText().toString();
                String phNo = PhNo.getText().toString();
                String hours = Hours.getText().toString();
                String startDate = StartDate.getText().toString();
                String endDate = EndDate.getText().toString();
                ed.putString("fullName", fullName);
                ed.putString("driveID", driveID);
                ed.putString("phNo", phNo);
                ed.putString("hours", hours);
                ed.putString("startDate", startDate);
                ed.putString("endDate", endDate);
                ed.apply();
                if(fullName.isEmpty() || driveID.isEmpty() || phNo.isEmpty() || hours.isEmpty() || startDate.isEmpty() || endDate.isEmpty()){
                    Toast.makeText(Details1.this, "Please Provide All Details", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(tvcost.getText().toString().isEmpty()){
                        int total = Integer.parseInt(Hours.getText().toString()) * Integer.parseInt(sp.getString("cost", ""));
                        tvcost.setText(Integer.toString(total));
                        Intent intent = new Intent(Details1.this, FinalPage.class);
                        Toast.makeText(Details1.this, "Booked Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(Details1.this, FinalPage.class);
                        Toast.makeText(Details1.this, "Booked Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }
            }
        });
    }
}