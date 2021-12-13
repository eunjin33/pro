package com.example.mycalendar2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnList, btnCal;
    ImageButton btnadd;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnList = findViewById(R.id.btnList);
        btnCal = findViewById(R.id.btnCal);
        btnadd = findViewById(R.id.btnadd);



        //메인에서 +버튼 누르면 습관 등록 페이지로 이동
        btnadd.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
            startActivityForResult(intent,1);
        });

        //메인에서 리스트 누르면 List이동
        btnList.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(), ListActivity.class);
            startActivityForResult(intent,2);
        });


        //메인에서 달력 누르면 달력 이동
        btnCal.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(), CalenderActivity.class);
            startActivityForResult(intent,3);
        });

    }
}