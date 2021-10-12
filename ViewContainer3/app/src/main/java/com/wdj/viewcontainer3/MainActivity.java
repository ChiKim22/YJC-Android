package com.wdj.viewcontainer3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper vFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final ViewFlipper vFilpper;
//        전역으로 하지 않을때는 선언 시 final 필요.

        Button btnStart, btnStop;

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        vFlipper = (ViewFlipper) findViewById(R.id.vFilpper);
        vFlipper.setFlipInterval(2000);

        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                vFlipper.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });
    }
}