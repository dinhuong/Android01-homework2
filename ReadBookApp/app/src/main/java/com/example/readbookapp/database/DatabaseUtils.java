package com.example.readbookapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.readbookapp.model.StoryModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    private final String TABLE_NAME = "tbl_short_story";

    private SQLiteDatabase sqLiteDatabase;
    private MyDatabase myDatabase;
    private static DatabaseUtils databaseUtils;

    /*-----------------------------------------------------------------------------------------*/
    public DatabaseUtils(Context context) {
        myDatabase = new MyDatabase(context);
    }

    public static DatabaseUtils getInstance(Context context) {
        if (databaseUtils == null) {
            databaseUtils = new DatabaseUtils(context);
        }
        return databaseUtils;
    }

    /*----------------------------------------------------------------------------------------*/
    public List<StoryModel> getListStory() {
        sqLiteDatabase = myDatabase.getReadableDatabase();
        List<StoryModel> storyModelList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String image = cursor.getString(1);
            String title = cursor.getString(2);
            String description = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);
            int bookmark = cursor.getInt(6);
            StoryModel storyModel = new StoryModel(id, image, title, description, content, author, bookmark);
            storyModelList.add(storyModel);
            cursor.moveToNext();
        }
        return storyModelList;
    }

}
