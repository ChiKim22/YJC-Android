package com.wdj.data_handling_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView tvID,tvPassword;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        setTitle("데이터 전달 확인");

        tvID = findViewById(R.id.tvId);
        tvPassword = findViewById(R.id.tvPassword);

        btnReturn = findViewById(R.id.btnReturn);

        //★ 입력하기
        Intent intent = getIntent();

        String inID = intent.getStringExtra("id");
        Integer inPassword = intent.getIntExtra("password", 0);
        // Integer형으로 받을때는 기본값을 지정해줘야함.

        tvID.setText("ID : " + inID.toString());
        tvPassword.setText("Password : " + inPassword.toString());


        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}