package com.wdj.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Switch chkAgree;
    RadioGroup rg1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    ImageView imgPet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Watching Pet Image");

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (Switch) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rg1 = (RadioGroup) findViewById(R.id.RdoGroup1);
        rdoDog = (RadioButton) findViewById(R.id.RdoDog);
        rdoCat = (RadioButton) findViewById(R.id.RdoCat);
        rdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);

        imgPet = (ImageView) findViewById(R.id.imgView);


        rdoDog.setOnClickListener(radio_listener);
        rdoCat.setOnClickListener(radio_listener);
        rdoRabbit.setOnClickListener(radio_listener);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree.isChecked() == true){
                    text2.setVisibility(android.view.View.VISIBLE);
                    rg1.setVisibility(android.view.View.VISIBLE);
                    imgPet.setVisibility(android.view.View.VISIBLE);
                }else{
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rg1.setVisibility(android.view.View.INVISIBLE);
                    imgPet.setVisibility(android.view.View.INVISIBLE);;
                }
            }
        });
    }

    View.OnClickListener radio_listener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (rg1.getCheckedRadioButtonId()) {
                case R.id.RdoDog :
                    imgPet.setImageResource(R.drawable.dog);
                    break;
                case R.id.RdoCat :
                    imgPet.setImageResource(R.drawable.cat);
                    break;
                case R.id.RdoRabbit :
                    imgPet.setImageResource(R.drawable.rabbit);
                    break;
                default:
                    Toast.makeText(getApplicationContext(),
                            "동물을 먼저 선택하세요.", Toast.LENGTH_SHORT).show();
            }
        }
    };
}