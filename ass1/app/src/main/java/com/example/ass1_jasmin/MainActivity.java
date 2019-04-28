package com.example.ass1_jasmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.drawable.ColorDrawable;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.DatePicker;
import android.util.Log;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText et_name, et_reg_email, et_Date;
    Button btn_register;


    private static final String TAG = "MainActivity";
    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText) findViewById(R.id.et_name);
        et_reg_email = (EditText) findViewById(R.id.et_reg_email);
        et_Date = (EditText) findViewById(R.id.et_Date);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getBaseContext(), Dashborad.class); /* Intent : masseging object */
                                                                                /* ليش ما حطيت زيس هنا؟ */ /*لانو مستعملة on click */
                                                                                 /*لانو عنا إنَّر كلاس */
                String nameValue = et_name.getText().toString();
                String emailValue = et_reg_email.getText().toString();
                String dateValue = et_Date.getText().toString();
                intent.putExtra("YourName", nameValue);
                intent.putExtra("YourEmail", emailValue);
                intent.putExtra("YourBirthDate", dateValue);
                startActivity(intent);
            }
        });

        mDisplayDate = (EditText) findViewById(R.id.et_Date);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
        /*Calender*/

    }
}
