package com.wdj.activity_calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Activity Calculator");

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);

                Intent intent = new Intent(getApplicationContext(), Second.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));

                RadioGroup rdoGroup = (RadioGroup) findViewById(R.id.rdoGroup);

                switch (rdoGroup.getCheckedRadioButtonId()){
                    case R.id.btnAdd:
                        intent.putExtra("Cal", "+");
                        break;
                    case R.id.btnSub:
                        intent.putExtra("Cal", "-");
                        break;
                    case R.id.btnMul:
                        intent.putExtra("Cal", "*");
                        break;
                    case R.id.btnDiv:
                        intent.putExtra("Cal", "/");
                        break;
                    default:
                        break;
                }

                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            int result = data.getIntExtra("result", 0);
            Toast.makeText(getApplicationContext(), "Result : " + result, Toast.LENGTH_SHORT).show();
        }
    }
}
