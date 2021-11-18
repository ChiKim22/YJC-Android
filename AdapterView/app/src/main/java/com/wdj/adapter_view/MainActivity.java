package com.wdj.adapter_view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("US Drama");

        final ArrayList<String> mid = new ArrayList<>();

//        final String[] mid = { "Heroes", "24Hour", "Lost", "The Lost Room", "Smallville", "Detective Monk",
//                "Big Bang", "Friends", "Dexter", "Glee", "Gossip Girl", "Taken", "Super Natural", "V" };

        ListView list = (ListView) findViewById(R.id.listView1);

        final EditText addDrama = (EditText) findViewById(R.id.addDrama);
        Button addBtn = (Button) findViewById(R.id.btnAdd);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mid);
//        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // Add choice Mode
        list.setAdapter(adapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mid.add(addDrama.getText().toString());
                adapter.notifyDataSetChanged(); // add drama list
            }
        });


//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "Drama Name : " + mid[position], Toast.LENGTH_SHORT).show();
//            }
//        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mid.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}