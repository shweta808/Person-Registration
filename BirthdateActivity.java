package com.example.shwetashahane.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.*;
import android.content.*;
import android.widget.DatePicker;
import java.lang.*;

public class BirthdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthdate);
        Button doneBdButton=(Button) findViewById(R.id.doneBdButton);
        doneBdButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setDateFromDatePicker();
            }
        });
        Button cancelBdButton=(Button) findViewById(R.id.cancelBdButton);
        cancelBdButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setCancelDateFromDatePicker();
            }
        });
    }
    public void setDateFromDatePicker(){
        Log.i("BirthDate", "Got Date");
        Intent toPassBack = getIntent();
        DatePicker datePicker=(DatePicker)findViewById(R.id.datePicker);
        int year=datePicker.getYear();
        int month=datePicker.getMonth();
        int day=datePicker.getDayOfMonth();
        StringBuilder s=new StringBuilder().append(month + 1).append("/").append(day).append("/").append(year).append("");
        String birthdate=new String(s);
        Log.i("dateselected",birthdate);
        toPassBack.putExtra("BD", birthdate);
        setResult(RESULT_OK, toPassBack);
        finish();
    }
    public void setCancelDateFromDatePicker(){
        finish();
    }
}
