package com.example.todo;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "todo.db";

    public MyDatabase(Context context) {
        super(context,DATABASE_NAME,null,1);
    }
}
