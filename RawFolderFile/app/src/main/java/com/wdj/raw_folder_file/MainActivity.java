package com.wdj.raw_folder_file;

import java.io.IOException;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRead;
        final EditText edtRaw;
        btnRead = (Button) findViewById(R.id.btnRead);
        edtRaw = (EditText) findViewById(R.id.edtRaw);

        btnRead.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    //★ 입력하기
                    InputStream inputS = getResources().openRawResource(R.raw.raw_test);
                    // 리소스를 가져옴, 경로를 지정.
                    byte[] txt = new byte[inputS.available()];
                    // 리소스에서 가져오기 때문에 바이트 사이즈가 아닌 읽어온 파일의 바이트 수만큼 자동으로 생성해줌.


                    inputS.read(txt);
                    edtRaw.setText(new String(txt));
                    inputS.close();
                } catch (IOException e) {
                }
            }
        });
    }
}