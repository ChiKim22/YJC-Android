package com.example.hello_android;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 메인 엑티비티의 Java와 XML 을 연결해주는 코드. R. resource

        btn1.findViewById(R.id.btn1);
        btn2.findViewById(R.id.btn2);
        
    }

}