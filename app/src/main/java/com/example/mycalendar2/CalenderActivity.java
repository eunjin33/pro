package com.example.mycalendar2;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CalenderActivity extends AppCompatActivity {
    DBHelper dbHelper;
    ListView listCheck;
    CheckBox checkBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        //바 숨김
        getSupportActionBar().hide();

        listCheck = findViewById(R.id.listCheck);
        checkBox = findViewById(R.id.checkBox);

        dbHelper = new DBHelper(getApplicationContext());
        ArrayList<MemoVO> list = MemoDAO.selectAll(dbHelper);
        CalenderAdapter calenderAdapter = new CalenderAdapter(list);
        listCheck.setAdapter(calenderAdapter);

    }
}
