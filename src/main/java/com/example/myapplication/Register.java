package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    public TextView TV2;


    public TextView first1;
    public TextView last1;
    public TextView email1;
    public TextView password1;
    public TextView repass;
    public Button btn4;
    public String first1Holder, last1Holder, email1Holder, password1Holder, repassHolder, SQLiteDataBaseQueryHolder;
    Boolean EditTextEmptyHold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TV2 = findViewById(R.id.TV2);
        first1 = findViewById(R.id.first1);
        last1 = findViewById(R.id.last1);
        email1 = findViewById(R.id.email1);
        password1 = findViewById(R.id.password1);
        repass = findViewById(R.id.repass);
        btn4 = findViewById(R.id.btn4);
        TV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                String First1 = first1.getText().toString();
                String Last1 = last1.getText().toString();
                String Email1 = email1.getText().toString();
                String Password1 = password1.getText().toString();
                String Repass = repass.getText().toString();
                if (password1.getText().toString().equals(repass.getText().toString()) && !first1.getText().toString().equals("") && !last1.getText().toString().equals("") && !email1.getText().toString().equals("") && !password1.getText().toString().equals("") && !repass.getText().toString().equals("")) {
                    SharedPreferences sp = getSharedPreferences("myapp", MODE_PRIVATE);
                    SharedPreferences.Editor ed = sp.edit();
                    ed.putString("First", First1);
                    ed.putString("Last", Last1);
                    ed.putString("Email", Email1);
                    ed.putString("Password", Password1);
                    ed.putString("Repass", Repass);
                    ed.apply();
                    Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this,Login.class);
                    startActivity(intent);
                }
                else if(password1.getText().toString().equals(repass.getText().toString())){
                    Toast.makeText(Register.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Register.this, "Match the Password ", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}