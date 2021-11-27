package com.wdj.personal_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton searchBtn, callBtn, msgBtn, mapBtn, camBtn;
    EditText search;
    ConstraintLayout background;
    int bgImg[] = {R.drawable.dora1, R.drawable.dora2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Simple Home");
        background = (ConstraintLayout) findViewById(R.id.background);

        searchBtn = (ImageButton) findViewById(R.id.btnSearch);
        searchBtn.setImageResource(R.drawable.ic_baseline_search_24);
        searchBtn.setBackgroundResource(0);

        callBtn = (ImageButton) findViewById(R.id.btnPhone);
        msgBtn = (ImageButton) findViewById(R.id.btnMsg);
        mapBtn = (ImageButton) findViewById(R.id.btnMap);
        camBtn = (ImageButton) findViewById(R.id.btnPhoto);



        search = (EditText) findViewById(R.id.edSearch);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, search.getText().toString());
                startActivity(intent);
//                Toast.makeText(getApplicationContext(), search.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL_BUTTON);
                startActivity(intent);
            }
        });

        msgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "");
                intent.setData(Uri.parse("smsto:"+ Uri.encode("")));
                startActivity(intent);
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://maps.google.co.kr/maps?q="
                        + 35.89578 + "," + 128.62244 + "&z=15"); // YJU Location
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        camBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        background.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                    background.setBackgroundResource(bgImg[1]);
                return false;
            }
        });

    }
}