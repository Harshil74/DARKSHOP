package com.example.android.dsc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Harshil on 1/21/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static  final int DATABASE_VERSION = 1;
    private static  final String DATABASE_NAME = "login.db";
    private static  final String TABLE_NAME = "login";
    private static  final String COLUMN_ID = "id";
    private static  final String COLUMN_NAME = "name";
    private static  final String COLUMN_EMAIL = "email";
    private static  final String COLUMN_UNAME = "uname";
    private static  final String COLUMN_MOBILE = "mobile";
    private static  final String COLUMN_PASS = "pass";
    SQLiteDatabase db;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(id INTEGER primary key AUTOINCREMENT,name TEXT not null,email TEXT not null," +
                "uname TEXT not null, mobile TEXT not null,pass TEXT not null )");
        this.db = db;

    }

    public void insertContact(Contact c){
        db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = " select * from " +TABLE_NAME;
        Cursor cursor = db.rawQuery( query,null);
        int  count = cursor.getCount();
        values.put(COLUMN_ID,count);
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_MOBILE,c.getMobile());

        values.put(COLUMN_PASS,c.getPass());
        db.insert(TABLE_NAME,null,values);
        db.close();

    }

    public  String serachPass(String uname){
        db= this.getReadableDatabase();
        String query = "selct uname,pass from " + TABLE_NAME;
        Cursor c = db.rawQuery(query,null);
        String a,b;
        b="not found";
        if(c.moveToFirst()){
            do {
                a = c.getString(0);
                if(a.equals(uname)){
                    b = c.getString(1);
                    break;
                }
            }while (c.moveToNext());
        }
        return  b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String  query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}

