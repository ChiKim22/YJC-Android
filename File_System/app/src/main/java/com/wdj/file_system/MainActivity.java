package com.wdj.file_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnWirte, btnRead;
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWirte = (Button) findViewById(R.id.btnWrite);
        btnRead = (Button) findViewById(R.id.btnRead);
        ed1 = (EditText) findViewById(R.id.ed1);

        btnWirte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // try catch 문으로 오류를 처리해 줘야 함.
                try {
                    FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    // 파일을  때에는 Byte 형으로, 쓸 때에는 Byte 에서 다른 형으로 형 변환 필요.

                    String str = ed1.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close(); // 파일을 닫아줌.
                    Toast.makeText(getApplicationContext(),
                            "file.txt Create Complete.",
                                        Toast.LENGTH_SHORT).show();

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[] txt = new byte[38]; // 읽을 때 byte 배열 형으로 읽어서 이를 String 으로 변환해서 출력 해준다.
                    inFs.read(txt);
                    String str = new String(txt);

                    Toast.makeText(getApplicationContext(), "content : " + str, Toast.LENGTH_SHORT).show();
                } catch (IOException e){
                    Toast.makeText(getApplicationContext(),
                            "No File...", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}