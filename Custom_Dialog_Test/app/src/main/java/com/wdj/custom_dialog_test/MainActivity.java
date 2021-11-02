package com.wdj.custom_dialog_test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText mainName, mainEmail, edName, edEmail;
    TextView tvToast;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainName = (EditText) findViewById(R.id.mainName);
        mainEmail = (EditText) findViewById(R.id.mainEmail);

        btn1 = (Button) findViewById(R.id.btnDialog);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("User Infomation");
                dig.setIcon(R.drawable.ic_menu_allfriends);
                dig.setView(dialogView);

                edName = (EditText) dialogView.findViewById(R.id.edName);
                edEmail = (EditText) dialogView.findViewById(R.id.edEmail);
                edName.setText(mainName.getText().toString());
                edEmail.setText(mainEmail.getText().toString());

                dig.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mainName.setText(edName.getText().toString());
                        mainEmail.setText(edEmail.getText().toString());
                    }
                });
                dig.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this, R.layout.toast, null);
                        tvToast = (TextView) toastView.findViewById(R.id.toastText1);
                        tvToast.setText("Cancelled");
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dig.show();
            }
        });
    }
}