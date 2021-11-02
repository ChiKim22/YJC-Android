package com.wdj.middleterm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText ed1;
    ImageView imgView;
    String rotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.ed1);
        imgView = (ImageView) findViewById(R.id.imgView);

        rotation = ed1.getText().toString();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Rotate:
                imgView.setRotation(Float.parseFloat(rotation));
                return true;
            case R.id.dog:
                imgView.setImageResource(R.drawable.dog);
                break;
            case R.id.cat:
                imgView.setImageResource(R.drawable.cat);
                break;
            case R.id.rabbit:
                imgView.setImageResource(R.drawable.rabbit);
                break;
        }
        return false;
    }


}