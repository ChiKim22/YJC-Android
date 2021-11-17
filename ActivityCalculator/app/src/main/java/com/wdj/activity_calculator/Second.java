package com.wdj.activity_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("deprecation")
public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second Activity");

        Intent inIntent = getIntent();
        String cal = (inIntent.getStringExtra("Cal"));
        int calValue = 0;

        if(cal.equals("+")) {
            calValue = inIntent.getIntExtra("Num1", 0) +
                    inIntent.getIntExtra("Num2", 0); // int형의 경우에는 디폴트 값이 필요함.
        }else if(cal.equals("-")){
            calValue = inIntent.getIntExtra("Num1", 0) -
                    inIntent.getIntExtra("Num2", 0);
        }else if(cal.equals("*")){
            calValue = inIntent.getIntExtra("Num1", 0) *
                    inIntent.getIntExtra("Num2", 0);
        }else{
            calValue = inIntent.getIntExtra("Num1", 0) /
                    inIntent.getIntExtra("Num2", 0);
        }

        final int retValue = calValue;

//        Button btnReturn = (Button) findViewById(R.id.btnReturn);
//        btnReturn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);

                outIntent.putExtra("result", retValue);
                setResult(RESULT_OK, outIntent);
                finish();
//            }
//        });
    }
}