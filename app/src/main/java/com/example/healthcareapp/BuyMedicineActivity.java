package com.example.healthcareapp;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"package 1: medicine1","","","","758"},
                    {"package 2: medicine2","","","","759"},
                    {"package 3: medicine3","","","","780"},
                    {"package 4: medicine4","","","","723"},
                    {"package 5: medicine5","","","","654"}
            };

    private String[] package_detail =
            {
                    "fbsajkdbf\n" +
                            "asdvsdv\n" +
                            "vdsava\n" +
                            "fvsdvad\n" +
                            "efdavfd\n" +
                            "eregfd\n" +
                            "bfdbfgd\n" +
                            "bnhgnd\n"

            };


    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonCartBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class)});
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(BuyMedicineActivity.this, HomeActivity.class)});
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Cons Fee " + packages[i][4] + "/-");
            list.add(item);

        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineActivityDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",packages[i][1]);
                it.putExtra("text3",packages[i][2]);
                startActivity(it);
            }
        });

    }
}