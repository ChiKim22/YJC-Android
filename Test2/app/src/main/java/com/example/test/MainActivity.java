package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = (TextView)findViewById(R.id.text1);
        Log.d(this.getClass().getName(), (String)tv1.getText());

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent itnt = new Intent(MainActivity.this, SecondActivity.class);
                itnt.putExtra("JHK", "010-1234-5678");

                startActivity(itnt);

//                finish();
            }
        });
    }
    public void OnclickHandler(View View){
        Intent itnt2 = new Intent(this,SecondActivity.class);
        itnt2.putExtra("JHK", "010-1234-5678");

        startActivity(itnt2);
    }
}