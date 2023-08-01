package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class LabTestActivity extends AppCompatActivity {

    private String[][] package =
    {
        {"package 1: 1","","","","758"},
        {"package 2: 2","","","","758"},
        {"package 3: 3","","","","758"},
        {"package 4: 4","","","","758"},
        {"package 5: 5","","","","758"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
    }
}