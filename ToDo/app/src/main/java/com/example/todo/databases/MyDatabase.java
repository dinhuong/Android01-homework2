package com.example.todo.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "todo.db";

    private void checkDataBase() {
        SQLiteDatabase checkDB;
        checkDB=SQLiteDatabase.openOrCreateDatabase(DATABASE_NAME,null);
        checkDB.close();
    }

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
        checkDataBase();
    }
}
