package com.wdj.autotextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"CSI-NewYork", "CSI-LasVegas",
                            "CSI-Miami", "Friends", "Fringe", "Lost"};

        AutoCompleteTextView atv = (AutoCompleteTextView)
                                    findViewById(R.id.autoCompleteTV);

        MultiAutoCompleteTextView mtv = (MultiAutoCompleteTextView)
                                         findViewById(R.id.multiAutoCompleteTV);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                                                         android.R.layout.simple_dropdown_item_1line, items);

        atv.setAdapter(adapter);

        // (,) 를 생성해서 구분지어줌.
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        mtv.setTokenizer(token);
        mtv.setAdapter(adapter);
    }
}