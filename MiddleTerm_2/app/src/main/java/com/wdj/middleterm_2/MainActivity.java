package com.wdj.middleterm_2;// 본인 패키지 이름으로 변경하세요.

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.wdj.middleterm_2.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //전역변수 선언
    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간 예약");

        // 버튼
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        // 크로노미터
        chrono = (Chronometer) findViewById(R.id.chronometer1);

        // 라디오버튼 2개
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        // FrameLayout의 2개 위젯
        tPicker = (TimePicker) findViewById(R.id.timePicker1);
        calView = (CalendarView) findViewById(R.id.calendarView1);

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        // 처음에는 타임 피커와 캘린더뷰 2개를 안보이게 설정하는 코드 입력
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);


        //<날짜 설정> 라디오 버튼 클릭하면 캘린더만 보이도록 설정
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });



        //<시간 설정> 라디오 버튼 클릭하면 타임피커만 보이도록 설정
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });



        // <예약 시작> 버튼 클릭하면 크로노미터 초기화 및 시작
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.start();
            }
        });



        // <캘린더 뷰>에서 날짜를 선택하면 예약된 연, 월, 일이 전역 변수에 대입된다.
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month;
                selectDay = dayOfMonth;
            }
        });




        // <예약 완료> 버튼을 클릭하면 크로노미터 정지 . 날짜, 시간 텍스트뷰로 예약한 날짜,시간을 보여준다.

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                tvYear.setText(selectYear);
                tvMonth.setText(selectMonth);
                tvDay.setText(selectDay);
                tvHour.setText(tPicker.getCurrentHour());
                tvMinute.setText(tPicker.getCurrentMinute());
            }
        });



    }

}
