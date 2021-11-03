package com.wdj.file_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnWirte, btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWirte = (Button) findViewById(R.id.btnWrite);
        btnRead = (Button) findViewById(R.id.btnRead);

        btnWirte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // try catch 문으로 오류를 처리해 줘야 함.
                try {
                    FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    // 파일을  때에는 Byte 형으로, 쓸 때에는 Byte 에서 다른 형으로 형 변환 필요.

                    String str = "Android!";
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),
                            "file.txt Create Complete.",
                                        Toast.LENGTH_SHORT).show();

                }catch (IOException e){

                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[] txt = new byte[38];
                    inFs.read(txt);
                    String str = new String(txt);

                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                } catch (IOException e){
                    Toast.makeText(getApplicationContext(),
                            "No File...", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}