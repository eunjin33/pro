package com.example.mycalendar2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    DBHelper dbHelper;
    TextView textTitle, txtContent;
    ImageView imageView;
    ListView listMemo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_item);

        textTitle= findViewById(R.id.txtTitle);
        txtContent = findViewById(R.id.txtContent);
        imageView = findViewById(R.id.imageView);

        //리스트 보여주는 화면
        dbHelper = new DBHelper(getApplicationContext());
        ArrayList<MemoVO> list = MemoDAO.selectAll(dbHelper);

        listMemo = findViewById(R.id.listMemo);

        MemoAdapter adapter = new MemoAdapter(list);
        listMemo.setAdapter(adapter);



    }
}
