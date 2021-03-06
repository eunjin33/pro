package com.example.mycalendar2;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    DBHelper dbHelper;
    TextView textTitle, txtContent;
    ListView memoList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().hide();

        textTitle= findViewById(R.id.txtTitleList);
        txtContent = findViewById(R.id.txtContentList);

        //리스트 보여주는 화면
        dbHelper = new DBHelper(getApplicationContext());
        ArrayList<MemoVO> list = MemoDAO.selectAll(dbHelper);

        memoList = findViewById(R.id.memoList);

        MemoAdapter adapter = new MemoAdapter(list);
        memoList.setAdapter(adapter);

    }
}
