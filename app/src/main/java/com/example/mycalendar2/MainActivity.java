package com.example.mycalendar2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnList, btnCal;
    FloatingActionButton btnAdd;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnList = findViewById(R.id.btnList);
        btnCal = findViewById(R.id.btnCal);
        btnAdd = findViewById(R.id.btnAdd);



        //메인에서 +버튼 누르면 습관 등록 페이지로 이동
        btnAdd.setOnClickListener(v->{
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

        });

    }
}