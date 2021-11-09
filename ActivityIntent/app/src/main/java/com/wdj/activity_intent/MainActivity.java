package com.wdj.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button btnNewActivity;
    RadioButton rdoSecond, rdoThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewActivity = (Button) findViewById(R.id.btnNewActivity);

        rdoSecond = (RadioButton) findViewById(R.id.rdoSecond);
        rdoThird = (RadioButton) findViewById(R.id.rdoThird);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //인텐트 종류 : 몀시적 (직접 사용할 엑티비티를 직접 적어야됨), 암시적 (동작만 지정하면 알아서 함.)

                Intent intent; // 명시적 인텐트
                // 불러줄 엑티비티를 호출 뒤에 .class를 붙여줘야.
                // 단 이는 데이터를 전달해 주는것은 아님. 데이터를 전달하려면 Intent를 사용해줘야 함.

                if(rdoSecond.isChecked() == true){
                    intent = new Intent(getApplicationContext(), secondActivity.class);
                }else{
                    intent = new Intent(getApplicationContext(), thirdActivity.class);
                }


                startActivity(intent);
            }
        });
    }
}