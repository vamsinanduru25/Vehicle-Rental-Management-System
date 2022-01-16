package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public TextView TV1, email2, password2;
    public Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TV1 = findViewById(R.id.TV1);
        email2 = findViewById(R.id.email2);
        password2 = findViewById(R.id.password2);
        btn3 = findViewById(R.id.btn3);
        TV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
        SharedPreferences sp = getSharedPreferences("myapp", MODE_PRIVATE);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email2.getText().toString().equals(sp.getString("Email", "")) && password2.getText().toString().equals(sp.getString("Password", "")) && !email2.getText().toString().equals("") && !password2.getText().toString().equals("")){
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainPage.class);
                    startActivity(intent);
                }
                else if(email2.getText().toString().equals("") && password2.getText().toString().equals("")){
                    Toast.makeText(Login.this, "Fill Details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Login.this, "GO To Register Page", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}