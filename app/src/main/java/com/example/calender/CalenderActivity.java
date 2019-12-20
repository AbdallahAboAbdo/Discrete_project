package com.example.calender;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalenderActivity extends AppCompatActivity {

    private TextView[][] daysTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        inflateItems();

        Intent intent = getIntent();
        int year = intent.getIntExtra("year", 2019);
        int month = intent.getIntExtra("month", 1);
        try {
            Calender calender = new Calender(year, month);
            printCalender(calender.ArrayMonthBody());
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Invalid year or month!", Toast.LENGTH_LONG).show();
            finish();
        }


    }

    private void inflateItems() {
        daysTextViews = new TextView[6][7];
        daysTextViews[0][0] = findViewById(R.id.day_1);
        daysTextViews[0][1] = findViewById(R.id.day_2);
        daysTextViews[0][2] = findViewById(R.id.day_3);
        daysTextViews[0][3] = findViewById(R.id.day_4);
        daysTextViews[0][4] = findViewById(R.id.day_5);
        daysTextViews[0][5] = findViewById(R.id.day_6);
        daysTextViews[0][6] = findViewById(R.id.day_7);

        daysTextViews[1][0] = findViewById(R.id.day_8);
        daysTextViews[1][1] = findViewById(R.id.day_9);
        daysTextViews[1][2] = findViewById(R.id.day_10);
        daysTextViews[1][3] = findViewById(R.id.day_11);
        daysTextViews[1][4] = findViewById(R.id.day_12);
        daysTextViews[1][5] = findViewById(R.id.day_13);
        daysTextViews[1][6] = findViewById(R.id.day_14);

        daysTextViews[2][0] = findViewById(R.id.day_15);
        daysTextViews[2][1] = findViewById(R.id.day_16);
        daysTextViews[2][2] = findViewById(R.id.day_17);
        daysTextViews[2][3] = findViewById(R.id.day_18);
        daysTextViews[2][4] = findViewById(R.id.day_19);
        daysTextViews[2][5] = findViewById(R.id.day_20);
        daysTextViews[2][6] = findViewById(R.id.day_21);

        daysTextViews[3][0] = findViewById(R.id.day_22);
        daysTextViews[3][1] = findViewById(R.id.day_23);
        daysTextViews[3][2] = findViewById(R.id.day_24);
        daysTextViews[3][3] = findViewById(R.id.day_25);
        daysTextViews[3][4] = findViewById(R.id.day_26);
        daysTextViews[3][5] = findViewById(R.id.day_27);
        daysTextViews[3][6] = findViewById(R.id.day_28);

        daysTextViews[4][0] = findViewById(R.id.day_29);
        daysTextViews[4][1] = findViewById(R.id.day_30);
        daysTextViews[4][2] = findViewById(R.id.day_31);
        daysTextViews[4][3] = findViewById(R.id.day_32);
        daysTextViews[4][4] = findViewById(R.id.day_33);
        daysTextViews[4][5] = findViewById(R.id.day_34);
        daysTextViews[4][6] = findViewById(R.id.day_35);

        daysTextViews[5][0] = findViewById(R.id.day_36);
        daysTextViews[5][1] = findViewById(R.id.day_37);
        daysTextViews[5][2] = findViewById(R.id.day_38);
        daysTextViews[5][3] = findViewById(R.id.day_39);
        daysTextViews[5][4] = findViewById(R.id.day_40);
        daysTextViews[5][5] = findViewById(R.id.day_41);
        daysTextViews[5][6] = findViewById(R.id.day_42);
    }

    public void printCalender(int[][] calenderTable) {
        for (int i = 0; i < calenderTable.length; i++) {
            for (int j = 0; j < calenderTable[0].length; j++) {
                if (calenderTable[i][j] != 0)
                    daysTextViews[i][j].setText(String.valueOf(calenderTable[i][j]));
            }
        }
    }

}


