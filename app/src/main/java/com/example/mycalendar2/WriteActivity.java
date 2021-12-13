package com.example.mycalendar2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class WriteActivity extends AppCompatActivity {
    EditText txtTitle, txtContent;
    Button btnInsert;
    ImageView imgView;
    DBHelper dbHelper;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        getSupportActionBar().hide();
        txtTitle = findViewById(R.id.txtTitleList);
        txtContent = findViewById(R.id.txtContentList);
        btnInsert = findViewById(R.id.btnAdd);


        dbHelper = new DBHelper(getApplicationContext());
        Intent intent = getIntent();

        //db Insert
        btnInsert.setOnClickListener(v->{
            MemoVO vo = new MemoVO();

            vo.setTitle(txtTitle.getText().toString());
            vo.setContent(txtContent.getText().toString());

            System.out.println(txtTitle.getText().toString());
            System.out.println(txtContent.getText().toString());

            MemoDAO.insert(dbHelper,vo);

            Intent Mainintent = new Intent(getApplicationContext(), MainActivity.class);
            startActivityForResult(Mainintent, 2);

        });

        //db select


        //de delete





    }
}
