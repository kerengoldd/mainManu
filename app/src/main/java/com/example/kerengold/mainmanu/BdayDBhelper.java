package com.example.kerengold.mainmanu;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class BdayDBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "birthdays.db";
    private static final String TABLE_NAME = "friends";
    private static final String FULL_NAME = "full_name";
    private static final String BIRTH_DAY = "birth_day";
    private static final String COMMENT = "comment";

    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE " + TABLE_NAME + " ("+ FULL_NAME +" TEXT, " +
                    BIRTH_DAY+" TEXT, " + COMMENT + " TEXT)";

    public BdayDBhelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATION", "Database created / opened...");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATION", "Table Created...");
    }

    public void addFriend(String name, String birthday, String comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FULL_NAME,name);
        contentValues.put(BIRTH_DAY,birthday);
        contentValues.put(COMMENT,comment);
        db.insert(TABLE_NAME, null,contentValues);
        Log.e("DATABASE OPERATION", "Data row inserted...");
    }

    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return data;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
    }
}