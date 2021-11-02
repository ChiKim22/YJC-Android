package com.wdj.dialog_test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button btn1;
    String[] itBrands = {"Apple", "Samsung", "Microsoft", "LG", "Nvidia", "AMD" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("IT Brands");

        tv1 = (TextView) findViewById(R.id.tv1);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("IT Brands");
                dig.setSingleChoiceItems(itBrands, 0,  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv1.setText(itBrands[which]);
                    }
                });
                dig.setIcon(R.mipmap.ic_launcher);
                dig.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "You Clicked OK",Toast.LENGTH_SHORT).show();
                    }
                }); // 뒤에 리스너의 동작에 관련하기 때문에, 포지티브나 네가티브는 크게 상관 없음.
                dig.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You Clicked Cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                dig.show();
            }
        });

    }
}