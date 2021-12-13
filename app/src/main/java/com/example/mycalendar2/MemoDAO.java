package com.example.mycalendar2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MemoDAO {
    DBHelper dbHelper;

    //목록조회
    public static ArrayList<MemoVO> selectAll(DBHelper dbHelper) {
        ArrayList<MemoVO> list = new ArrayList<MemoVO>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select id, title, content from memo order by id desc";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            MemoVO memoVO = new MemoVO();
            memoVO.setId(cursor.getString(0));
            memoVO.setTitle(cursor.getString(1));
            memoVO.setContent(cursor.getString(2));
            list.add(memoVO);
        }
        db.close();
        return list;
    }
    //등록
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void insert(DBHelper dbHelper, MemoVO memoVO){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("title", memoVO.getTitle());
        contentValues.put("content", memoVO.getContent());


        db.insert("memo", null, contentValues);
        db.close();
    }

    //삭제
    public static void delete(DBHelper dbHelper, String id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("memo", "id=?", new String[]{id});
        db.close();
    }
}
