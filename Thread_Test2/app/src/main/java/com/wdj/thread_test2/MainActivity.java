package com.wdj.thread_test2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar pb1, pb2;
        final Button btn;
        final TextView tv1, tv2;

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        pb1 = (ProgressBar) findViewById(R.id.pb1);
        pb2 = (ProgressBar) findViewById(R.id.pb2);
        btn = (Button) findViewById(R.id.button1);


        //★ 입력하기.  btn 클릭시 100번 반복.

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    public void run() {
                        for(int i=pb1.getProgress(); i < 100; i=+2){
                            runOnUiThread(new Runnable() { // 외부 위젯을 스레드 내에서 변경할 때, 사용.
                                                            // 일반적으로는 계산을 제외하면 변경 할 수 없음.
                                @Override
                                public void run() {
                                    pb1.setProgress(pb1.getProgress()+2);
                                    tv1.setText("Progress 1 : " + pb1.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();

                new Thread(){
                    public void run() {
                        for(int i=pb2.getProgress(); i < 100; i++){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    pb2.setProgress(pb2.getProgress()+1);
                                    tv2.setText("Progress 1 : " + pb2.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();
            }
        });
    }
}