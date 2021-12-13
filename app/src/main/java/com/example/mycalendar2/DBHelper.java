package com.example.mycalendar2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static String NAME = "memo.db";
    public static int VERSION = 1;

    public DBHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists memo("
                + " id integer PRIMARY KEY autoincrement, "
                + " title text, "
                + " content text)";
        db.execSQL(sql);
        sql = "insert into memo (title,content) values ('책 읽기', '하루에 30분 책 읽기')";
        db.execSQL(sql);
        sql = "insert into memo (title,content) values ('운동하기', '하루에 30분 걷기')";
        db.execSQL(sql);
        sql = "insert into memo (title,content) values ('영단어 외우기', '하루에 30개 영단어 외우기')";
        db.execSQL(sql);
    }

    public void onOpen(SQLiteDatabase db) {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > 1) {
            db.execSQL("DROP TABLE IF EXISTS noteData");
        }
    }
}
