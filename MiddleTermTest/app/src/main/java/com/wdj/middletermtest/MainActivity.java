package com.wdj.middletermtest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2;
    Button btnAdd, btnSub;
    String n1, n2;
    Button[] numberBtns = new Button[10];
    Integer[] numBtns = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
                    R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn0};
    Integer result;
    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);

        tv1 = findViewById(R.id.tv1);

        for(int i = 0; i < numBtns.length; i++){
            numberBtns[i] = findViewById(numBtns[i]);
        }

        for(int i=0; i<numBtns.length; i++){
            final int index;
            index = i;

            numberBtns[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(ed1.isFocused() == true){
                        n1 = ed1.getText().toString() + numberBtns[index].getText().toString();
                        ed1.setText(n1);
                    }else if (ed2.isFocused() == true){
                        n2 = ed2.getText().toString() + numberBtns[index].getText().toString();
                        ed2.setText(n2);
                    }else {
                        Toast.makeText(getApplicationContext(), "Plz Select One.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = ed1.getText().toString();
                n2 = ed2.getText().toString();
                result = Integer.parseInt(n1) + Integer.parseInt(n2);
                tv1.setText("Result : " + result.toString());
            }
        });
    }
}