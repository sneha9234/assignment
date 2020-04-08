package com.sneha.assignment;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class dbmanager extends SQLiteOpenHelper {

    String ct = "create table if not exists hist (rating text, dnt text primary key) ";


    public dbmanager(@Nullable Context context) {
        super(context, "assignment", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ct);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor fetch_data() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select*FROM hist";
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }


}
