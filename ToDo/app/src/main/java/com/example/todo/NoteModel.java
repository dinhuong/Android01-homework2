package com.example.todo;

public class NoteModel {
    int id;
    String title;
    String content;
    String tag;
    String time;

    public NoteModel(int id, String title, String content, String tag, String time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
