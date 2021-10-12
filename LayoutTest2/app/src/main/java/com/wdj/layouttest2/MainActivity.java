package com.wdj.layouttest2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.LTGRAY);
        setContentView(baseLayout);

        EditText ed1 = new EditText(this);
        ed1.setTextColor(Color.BLACK);
        baseLayout.addView(ed1);

        Button btn1 = new Button(this);
        btn1.setText("Button1");
        btn1.setTextColor(Color.BLACK);
        btn1.setBackgroundColor(Color.WHITE);
        baseLayout.addView(btn1);

        TextView tv1 = new TextView(this);
        tv1.setText("");
        tv1.setTextSize(30);
        tv1.setTextColor(Color.BLACK);
        baseLayout.addView(tv1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Using Java Code. (without XML)",
                        Toast.LENGTH_SHORT).show();

                tv1.setText(ed1.getText());
            }
        });
    }
}