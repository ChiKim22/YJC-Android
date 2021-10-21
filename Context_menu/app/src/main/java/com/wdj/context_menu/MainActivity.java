package com.wdj.context_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);

        // 버튼들을 컨텍스트 메뉴를 띄우게 하기 위해서 등록
        registerForContextMenu(btn1);
        registerForContextMenu(btn2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // View v 현재 클릭된 버튼을 판별해줌.
        super.onCreateContextMenu(menu, v, menuInfo);
        // Inflate 별개의 xml 파일을 나타나게 해줌. 단 메뉴가 동적일 경우에는 자바 코드로 사용해줘야함.
        MenuInflater mInflater = getMenuInflater();

        if(v == btn1){
            menu.setHeaderTitle("Change Background");
            mInflater.inflate(R.menu.menu, menu);
        }else if(v == btn2){
            mInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                btn1.setTextColor(Color.RED);
                btn1.setBackgroundColor(Color.BLACK);
                btn2.setTextColor(Color.RED);
                btn2.setBackgroundColor(Color.BLACK);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                btn1.setTextColor(Color.GREEN);
                btn1.setBackgroundColor(Color.BLACK);
                btn2.setTextColor(Color.GREEN);
                btn2.setBackgroundColor(Color.BLACK);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                btn1.setTextColor(Color.BLUE);
                btn1.setBackgroundColor(Color.WHITE);
                btn2.setTextColor(Color.BLUE);
                btn2.setBackgroundColor(Color.WHITE);
                return true;
            case R.id.subRotate:
                btn2.setRotation(45);
                return true;
            case R.id.subSize:
                btn2.setScaleX(1.5f);
                btn2.setScaleY(1.5f);
                return true;
            case R.id.backRotate:
                btn2.setRotation(0);
                return true;
            case R.id.normalScale:
                btn2.setScaleX(1.0f);
                btn2.setScaleY(1.0f);
                return true;
        }
        return false;
    }
}