package com.example.nowtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sFormat2 = new SimpleDateFormat("hh:mm:ss");
    TextView textView;
    Button refBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.tv);
        refBtn = (Button)findViewById(R.id.btn);

        refBtn.setOnClickListener(this);
    }
    public String getTime(){
        long now = System.currentTimeMillis();
        Date date = new Date();
        return sFormat.format(date) + sFormat2.format(date);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                textView.setText(getTime());
                break;
            default:
                break;
        }
    }
}