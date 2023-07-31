package com.example.healthcareapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btn;
    TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword =  findViewById(R.id.editTextLoginPassword);
        btn =  findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username  = edUsername.getText().toString();
                String password  = edPassword.getText().toString();
                Database db  = new Database(getApplicationContext(),"healthcareapp",null,1);
                if(username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(), "PLease all details", Toast.LENGTH_SHORT).show();
                }else {
                    if(db.login(username,password) == 1){
                        Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.apply();
                        startActivities(new Intent[]{new Intent(LoginActivity.this, HomeActivity.class)});
                    }
                    Toast.makeText(getApplicationContext(), "Invalid username and password", Toast.LENGTH_SHORT).show();
                }

            }
        });


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(LoginActivity.this, RegisterActivity.class)});
            }
        });
    }
}