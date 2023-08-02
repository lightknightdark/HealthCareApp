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

public class LabTestDetailsActivity extends AppCompatActivity {

    TextView tvPackageName, tvTotalCost;

    EditText edDetails;

    Button btnAddToCart , btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName = findViewById(R.id.textViewLDPPackageName);
        tvTotalCost = findViewById(R.id.editTextLDTTotalCost);
        edDetails = findViewById(R.id.editTextLDTTextMultiLine);
        btnAddToCart =  findViewById(R.id.buttonCartCheckOut);
        btnBack = findViewById(R.id.buttonLDTBack);

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        tvTotalCost.setText(intent.getStringExtra("text2"));
        edDetails.setText("Total cost :" +intent.getStringExtra("text3")+"/");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(LabTestDetailsActivity.this, LabTestActivity.class)});
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
                String username  =  sharedPreferences.getString("username","").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());


                Database db  = new Database(getApplicationContext(), "healthcareapp",null,1);

                if(db.checkCart(username,product)==1){
                    Toast.makeText(getApplicationContext() , "Product already added", Toast.LENGTH_SHORT).show();
                }else {
                    db.addCart(username,product,price,"lab");
                    Toast.makeText(getApplicationContext() , "record inserted to cart", Toast.LENGTH_SHORT).show();
                    startActivities(new Intent[]{new Intent(LabTestDetailsActivity.this, LabTestActivity.class)});
                }
            }
        });


    }
}