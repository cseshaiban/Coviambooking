package com.coviam.booking;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by mohammedshaiban on 5/6/16.
 */
public class SecondActivity extends AppCompatActivity {

    EditText fromDate,fromTime,toDate,toTime;
    Button submit;

    Calendar myCalendar,myCalendar1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fromDate = (EditText) findViewById(R.id.from_date);
        fromTime = (EditText) findViewById(R.id.from_time);
        toDate = (EditText) findViewById(R.id.to_date);
        toTime = (EditText) findViewById(R.id.to_time);

        submit = (Button) findViewById(R.id.book_now);


        fromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCalendar1 = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar1.set(Calendar.YEAR, year);
                        myCalendar1.set(Calendar.MONTH, monthOfYear);
                        myCalendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String myFormat = "dd/MM/yy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
                        fromDate.setText(sdf.format(""+myCalendar.getTime()));
                    }

                };
                new DatePickerDialog(SecondActivity.this, date, myCalendar1
                        .get(Calendar.YEAR), myCalendar1.get(Calendar.MONTH),
                        myCalendar1.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        fromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        toDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        toDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
