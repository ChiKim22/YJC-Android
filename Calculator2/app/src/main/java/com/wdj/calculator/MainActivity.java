package com.wdj.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnDivR;
    TextView resultText;
    String n1, n2;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Calculator");

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDivR = (Button) findViewById(R.id.btnDivR);

        resultText = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = edit1.getText().toString();
                n2 = edit2.getText().toString();
                if (n1.isEmpty() || n2.isEmpty()){
                    Toast.makeText(getApplicationContext(), "숫자를 적어주세요...", Toast.LENGTH_SHORT).show();
                }else {
                    result = Double.parseDouble(n1) + Double.parseDouble(n2);
                    resultText.setText("계산 결과 : " + result.toString());
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = edit1.getText().toString();
                n2 = edit2.getText().toString();
                if (n1.isEmpty() || n2.isEmpty()){
                    Toast.makeText(getApplicationContext(), "숫자를 적어주세요...", Toast.LENGTH_SHORT).show();
                }else {
                    result = Double.parseDouble(n1) - Double.parseDouble(n2);
                    resultText.setText("계산 결과 : " + result.toString());
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = edit1.getText().toString();
                n2 = edit2.getText().toString();
                if (n1.isEmpty() || n2.isEmpty()){
                    Toast.makeText(getApplicationContext(), "숫자를 적어주세요...", Toast.LENGTH_SHORT).show();
                }else {
                    result = Double.parseDouble(n1) * Double.parseDouble(n2);
                    resultText.setText("계산 결과 : " + result.toString());
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = edit1.getText().toString();
                n2 = edit2.getText().toString();
                if(n2.equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로는 나눌 수 없어요...", Toast.LENGTH_SHORT).show();
                }else if (n1.isEmpty() || n2.isEmpty()){
                    Toast.makeText(getApplicationContext(), "숫자를 적어주세요...", Toast.LENGTH_SHORT).show();
                }else {
                    result = Double.parseDouble(n1) / Double.parseDouble(n2);
                    resultText.setText("계산 결과 : " + result.toString());
                }
            }
        });

        btnDivR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = edit1.getText().toString();
                n2 = edit2.getText().toString();

                if(n2.equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로는 나눌 수 없어요...", Toast.LENGTH_SHORT).show();
                }else if (n1.isEmpty() || n2.isEmpty()){
                    Toast.makeText(getApplicationContext(), "숫자를 적어주세요...", Toast.LENGTH_SHORT).show();
                }else {
                    result = Double.parseDouble(n1) % Double.parseDouble(n2);
                    resultText.setText("나머지 : " + result.toString());
                }
            }
        });


    }
}