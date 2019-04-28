package com.example.ass1_jasmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Dashborad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashborad);
        Intent i  = getIntent();

       String  name = i.getExtras().getString("YourName"," ");
        String  Email = i.getExtras().getString("YourEmail"," ");
        String  Date = i.getExtras().getString("YourBirthDate"," ");

        TextView et_name =  findViewById(R.id.tv_name);
        TextView et_reg_email  =  findViewById(R.id.tv_email);
        TextView et_Date =  findViewById(R.id.tv_date);

        et_name.setText(name);
        et_reg_email.setText(Email);
        et_Date.setText(Date);

    }

}
