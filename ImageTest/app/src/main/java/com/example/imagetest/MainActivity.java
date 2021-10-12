package com.example.imagetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static com.example.imagetest.R.drawable.apple2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onClick(View view){
        ImageView imgV = (ImageView)findViewById(R.id.imgView);

        imgV.setImageResource(R.drawable.apple2);
    }
}