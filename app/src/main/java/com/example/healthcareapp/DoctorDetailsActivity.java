package com.example.healthcareapp;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1=
            {
                    {"Doctor Name : 1","Hospital Address : q1","Exp: 5yrs","Mobile No:12345","100"},
                    {"Doctor Name : 2","Hospital Address : q2","Exp: 6yrs","Mobile No:12345","300"},
                    {"Doctor Name : 3","Hospital Address : q3","Exp: 7yrs","Mobile No:12345","400"},
                    {"Doctor Name : 4","Hospital Address : q4","Exp: 8yrs","Mobile No:12345","700"},
                    {"Doctor Name : 4","Hospital Address : q5","Exp: 3yrs","Mobile No:12345","900"},
            };
    private String[][] doctor_details2=
            {
                    {"Doctor Name : 11","Hospital Address : q11","Exp: 5yrs","Mobile No:12345","100"},
                    {"Doctor Name : 22","Hospital Address : q22","Exp: 6yrs","Mobile No:12345","300"},
                    {"Doctor Name : 33","Hospital Address : q33","Exp: 7yrs","Mobile No:12345","400"},
                    {"Doctor Name : 44","Hospital Address : q44","Exp: 8yrs","Mobile No:12345","700"},
                    {"Doctor Name : 45","Hospital Address : q55","Exp: 3yrs","Mobile No:12345","900"},
            };
    private String[][] doctor_details3=
            {
                    {"Doctor Name : 111","Hospital Address : q111","Exp: 5yrs","Mobile No:12345","100"},
                    {"Doctor Name : 222","Hospital Address : q222","Exp: 6yrs","Mobile No:12345","300"},
                    {"Doctor Name : 333","Hospital Address : q333","Exp: 7yrs","Mobile No:12345","400"},
                    {"Doctor Name : 444","Hospital Address : q444","Exp: 8yrs","Mobile No:12345","700"},
                    {"Doctor Name : 455","Hospital Address : q555","Exp: 3yrs","Mobile No:12345","900"},
            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name : 1111","Hospital Address : q1111","Exp: 5yrs","Mobile No:12345","100"},
                    {"Doctor Name : 2222","Hospital Address : q2222","Exp: 6yrs","Mobile No:12345","300"},
                    {"Doctor Name : 3333","Hospital Address : q3333","Exp: 7yrs","Mobile No:12345","400"},
                    {"Doctor Name : 4444","Hospital Address : q4444","Exp: 8yrs","Mobile No:12345","700"},
                    {"Doctor Name : 4555","Hospital Address : q5555","Exp: 3yrs","Mobile No:12345","900"},
            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name : 11111","Hospital Address : q11111","Exp: 5yrs","Mobile No:12345","100"},
                    {"Doctor Name : 22222","Hospital Address : q2222","Exp: 6yrs","Mobile No:12345","300"},
                    {"Doctor Name : 33333","Hospital Address : q33333","Exp: 7yrs","Mobile No:12345","400"},
                    {"Doctor Name : 44444","Hospital Address : q44444","Exp: 8yrs","Mobile No:12345","700"},
                    {"Doctor Name : 45555","Hospital Address : q55555","Exp: 3yrs","Mobile No:12345","900"},
            };



    TextView tv;
    Button btn;

    String[][] doctor_details = {};

    ArrayList list;

    SimpleAdapter sa;

    HashMap<String, String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians") ==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician") ==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist") ==0)
                doctor_details = doctor_details3;
        else
       if(title.compareTo("Surgeon") ==0)
                doctor_details = doctor_details4;
       else
               doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class)});
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
             item = new HashMap<String, String>();
             item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fee "+doctor_details[i][4]+"/-");
            list.add(item);

        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("line1",doctor_details[i][0]);
                it.putExtra("line2",doctor_details[i][1]);
                it.putExtra("line3",doctor_details[i][2]);
                it.putExtra("line4",doctor_details[i][3]);
                it.putExtra("line5",doctor_details[i][4]);
                startActivity(it);
            }
        });




    }
}