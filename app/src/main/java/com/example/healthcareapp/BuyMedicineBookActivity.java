package com.example.healthcareapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class BuyMedicineBookActivity extends AppCompatActivity {

    EditText edname, edaddress, edcontact, edpincode;
    Button btnBooking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        edname =findViewById(R.id.editTextTBMBFullname);
        edaddress = findViewById(R.id.editTextTBMBAddress);
        edpincode = findViewById(R.id.editTextTBMBPincode);
        edcontact = findViewById(R.id.editTextTBMBContact);
        btnBooking = findViewById(R.id.buttonTBMBBooking);

        Intent intent = getIntent();
        String[] price = intent.getStringArrayExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
      //  String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
                String username  =  sharedPreferences.getString("username","").toString();
                Database db = new Database(getApplicationContext(),"healthcarapp",null,1);

                db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontact.getText().toString(),Integer.parseInt(edpincode.getText().toString()),date.toString(),"",Float.parseFloat(price[1]),"medicine");
                db.removeCart(username,"medicine");
                Toast.makeText(getApplicationContext(),"your booking is done sucesfully",Toast.LENGTH_LONG).show();
                startActivities(new Intent[]{new Intent(BuyMedicineBookActivity.this, HomeActivity.class)});
            }
        });
    }
}