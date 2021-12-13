package com.example.mycalendar2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WriteActivity extends AppCompatActivity {
    TextView txtTitle, txtContent;
    Button btnInsert;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        txtTitle = findViewById(R.id.txtTitle);
        txtContent = findViewById(R.id.txtContent);
        imgView = findViewById(R.id.imgView);
        btnInsert = findViewById(R.id.btnAdd);

        //db Insert
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        btnInsert.setOnClickListener(v->{
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            String sqlInsert = "INSERT INTO memo " +
                    "(title, content, img) VALUES ('"+ txtTitle.getText().toString() +"', '"+txtContent.getText().toString()+"')" ;
            db.execSQL(sqlInsert);
            db.close();

            Intent mainintent = new Intent(getApplicationContext(), MainActivity.class);
            mainintent.putExtra("msg","return test");
            setResult(1, mainintent);
            finish();
        });

        //db select


        //de delete


    }
}
