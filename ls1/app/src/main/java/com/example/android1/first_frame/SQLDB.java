package com.example.android1.first_frame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLDB extends SQLiteOpenHelper {

    public static final int DATABASE_VARSION = 1;
    public static final String DATABASE_NAME = "Zametrki";
    public static final String TABLE_CONSTANS = "constans";
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DATE = "date";
    public static final String KEY_MASSEGES = "massegse";

    public SQLDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VARSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + TABLE_CONSTANS + "("+
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                KEY_NAME + " TEXT NOT NULL, " +
                KEY_DATE + " TEXT NOT NULL, " +
                KEY_MASSEGES + " TEXT NOT NULL)");

    }

    public String getTabl() {
        return this.TABLE_CONSTANS;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_CONSTANS);
        onCreate(db);
    }
}
