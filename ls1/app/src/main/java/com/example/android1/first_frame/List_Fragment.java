package com.example.android1.first_frame;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class List_Fragment extends Fragment {

    SQLDB dbHelper;
    SQLiteDatabase db;
    final String LOG_TAG = "myLogs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_list_, container, false);

        dbHelper = new SQLDB(getContext());
        // подключаемся к базе
        db = dbHelper.getWritableDatabase();

        // проверка существования записей
        Cursor c = db.query("constans", null, null, null, null, null, null);

        if (c != null) {
            Log.d(LOG_TAG,"2");
            if (c.moveToFirst()) {
                Log.d(LOG_TAG,"3");
                String str;
                do {
                    str = "";
                    for (String cn : c.getColumnNames()) {
                        str = str.concat(cn + " = "
                                + c.getString(c.getColumnIndex(cn)) + "; ");
                        Log.d(LOG_TAG,str);
                    }


                } while (c.moveToNext());
            }
                c.close();
        } else{

        }


        dbHelper.close();

      //  if (c.moveToFirst()){

       //     do {
       //         TextView tv = new TextView(getActivity());
       //         String KEY_NAME = c.getString(c.getColumnIndex("KEY_NAME"));
        //        tv.setText(KEY_NAME);
        //        tv.setTextSize(30);
        //        view.addView(tv);
        //    } while (c.moveToNext());


       // }

       // c.close();
       // dbHelper.close();



        return view;
    }
}