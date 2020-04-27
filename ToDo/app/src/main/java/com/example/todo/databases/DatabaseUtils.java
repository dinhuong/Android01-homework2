package com.example.todo.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.todo.model.NoteModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {

    private final String TABLE_NAME = "todo";
    private SQLiteDatabase sqLiteDatabase;
    private MyDatabase myDatabase;

    private static DatabaseUtils databaseUtils;

    public DatabaseUtils(Context context) {
        myDatabase = new MyDatabase(context);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS todo;");
        sqLiteDatabase.execSQL("create table todo (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL,content text," +
                "tag text not null," +
                "time datetime not null)"
        );
    }

    public static DatabaseUtils getInstance(Context context) {
        if (databaseUtils == null) {
            databaseUtils = new DatabaseUtils(context);
        }
        return databaseUtils;
    }

    public List<NoteModel> getListModel() {
        sqLiteDatabase = myDatabase.getReadableDatabase();
        List<NoteModel> noteModels = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int id=cursor.getInt(0);
            String title=cursor.getString(1);
            String content=cursor.getString(2);
            String tag=cursor.getString(3);
            String time=cursor.getString(4);

            NoteModel noteModel=new NoteModel(id,title,content,tag,time);
            noteModels.add(noteModel);

            cursor.moveToNext();
        }
        return noteModels;
    }
    public void addNote(NoteModel note){
        sqLiteDatabase = myDatabase.getWritableDatabase();
        ContentValues values;

    }
}
