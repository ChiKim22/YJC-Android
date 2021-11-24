package com.wdj.adapter_spinnermovie;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity  {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("스피너 테스트");

        final String[] movie = { "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3","정직한 후보",
                "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨" };

        final Integer[] posterID = { R.drawable.mov01, R.drawable.mov02,
                R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10 };

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter;
        //simple_spinner_dropdown_item
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, movie);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;

                ImageView imgView = (ImageView) findViewById(R.id.imgView);
                imgView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imgView.setImageResource(posterID[pos]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });

    }
}
