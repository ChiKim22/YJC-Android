package com.wdj.adapter_gridviewmovieposter;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Movie Poster");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        // MyGridAdapter 생성
        MyGridAdapter gridAdapter = new MyGridAdapter(this); // Context C
        gv.setAdapter(gridAdapter);


    }

    // BaseAdapter에서 상속받아서 MyGridAdapter를 정의.
    public class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context c) {
            context = c;
        }

        Integer[] posterID = { R.drawable.mov01, R.drawable.mov02,
                R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10, R.drawable.mov01,
                R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
                R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
                R.drawable.mov10 };

        String[] posterTitle = { "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3","정직한 후보",
                "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨",
                "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3","정직한 후보",
                "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨",
                "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3","정직한 후보",
                "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨"};


        // getCount(), getView() - Most Important, getItem()

        @Override
        public int getCount() {
            return posterID.length; // 30 번 돔.
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //영화 포스터의 개수(40개)만큼 반복됨. 영화 포스터를 그리드 뷰의 각 칸마다 보여주는 기능.
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                //이미지 변수 생성, 이미지뷰(영화포스터) 크기를 200x300 크기로 설정
                ImageView imageview = new ImageView(context);
                imageview.setLayoutParams(new GridView.LayoutParams(200, 300));

                //이미지 뷰를 각 그리드뷰의 중앙에 배치
                imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageview.setPadding(5, 5, 5, 5);

                //이미지 뷰에 영화 포스터 1개(파라미미터로 넘어온 position 위치 지정
                imageview.setImageResource(posterID[position]);


                //getView 메서드의 파라미터인 position을 클릭 리스너 안에서 사용하기 위해 pos 변수에 대입
                final int pos = position; // 내부 listener 에서는 바로 사용 불가 final을 붙여 정의해야됨.

                // 각각 영화 포스터 클릭하면 대화상자 나오고 영화 포스터 원래 크기로 보여지도록
                imageview.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        View dialogView = (View) View.inflate(
                                MainActivity.this, R.layout.dialog, null);
                        AlertDialog.Builder dlg = new AlertDialog.Builder(
                                MainActivity.this);
                        ImageView ivPoster = (ImageView) dialogView
                                .findViewById(R.id.ivPoster);
                        ivPoster.setImageResource(posterID[pos]);
                        ivPoster.setPadding(5, 5, 5, 5);
                        dlg.setTitle(posterTitle[pos]);
                        dlg.setView(dialogView);
                        dlg.setNegativeButton("닫기", null);
                        dlg.show();
                    }
                });
                return imageview;
        }
    }

}
