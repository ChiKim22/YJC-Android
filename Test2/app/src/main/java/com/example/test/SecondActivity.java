package com.example.test;

import android.content.Intent;
import android.os.*;
import android.util.Log;
import android.widget.TextView;

import androidx.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        ActionBar actBar = getSupportActionBar();
        actBar.setTitle("Second Activity!!");

        TextView tv2 = (TextView)findViewById(R.id.text2);
        Intent intent = getIntent();
        tv2.setText(intent.getStringExtra("JHK"));



    }
}
