package com.example.calender;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText month ;
    private EditText year;
    private Button show_Calendar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate items
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        show_Calendar = findViewById(R.id.calender);

        show_Calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int enteredYear = Integer.parseInt(year.getText().toString());
                int enteredMonth = Integer.parseInt(month.getText().toString());
                Intent intent = new Intent(MainActivity.this, CalenderActivity.class);
                intent.putExtra("year", enteredYear);
                intent.putExtra("month", enteredMonth);
                startActivity(intent);
            }
        });

    }

}

