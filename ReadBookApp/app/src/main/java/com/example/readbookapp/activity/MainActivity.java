package com.example.readbookapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.readbookapp.R;
import com.example.readbookapp.adapter.StoryListAdapter;
import com.example.readbookapp.model.StoryModel;
import com.example.readbookapp.database.DatabaseUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    public static List<StoryModel> storyModelList;
    private StoryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lv_story);
        storyModelList=DatabaseUtils.getInstance(this).getListStory();
        adapter=new StoryListAdapter(storyModelList);
        listView.setAdapter(adapter);

    }

}
