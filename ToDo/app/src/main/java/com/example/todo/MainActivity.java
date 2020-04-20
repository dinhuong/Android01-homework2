package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fat;
    RecyclerView recyclerView;
    NoteAdapter noteAdapter;
    List<NoteModel> noteModelList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_list_note);
        noteModelList=DatabaseUtils.getInstance(this).getListModel();
        fat = findViewById(R.id.fb_add);
        fat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CreateNoteActivity.class);
                startActivity(intent);
            }
        });

        setUI();
        loadData();
    }

    private void loadData() {
    }

    private void setUI() {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        noteAdapter=new NoteAdapter(noteModelList);
        recyclerView.setAdapter(noteAdapter);
    }
}
