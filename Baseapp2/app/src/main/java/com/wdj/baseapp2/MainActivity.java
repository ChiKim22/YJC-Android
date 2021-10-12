package com.wdj.baseapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4; // YJU, Call, Photo, Finish

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //(Button) 형 변환 연산자는 오류를 줄이기 위해 정확하게 버튼형으로 변환.

        btn1 = (Button) findViewById(R.id.btnYju);
        btn2 = (Button) findViewById(R.id.btnCall);
        btn3 = (Button) findViewById(R.id.btnPhoto);
        btn4 = (Button) findViewById(R.id.btnEnd);

        btn1.setOnClickListener(new View.OnClickListener() { // 익명 내부 클래스 (일반적인 방법)
            @Override
            public void onClick(View v) {
                // Intent 의 정보를 엑티비티에 띄어준다
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yju.ac.kr"));
                startActivity(mIntent);
                btn1.setBackgroundColor(Color.BLUE);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/01031023807"));
                startActivity(mIntent);
                btn2.setBackgroundColor(Color.CYAN);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(mIntent);
                btn3.setBackgroundColor(Color.YELLOW);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                btn4.setBackgroundColor(Color.RED);
            }
        });

    }
}