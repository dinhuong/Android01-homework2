package com.example.readbookapp.model;

import android.provider.ContactsContract;

import java.io.Serializable;

public class StoryModel implements Serializable {
    int id;
    String image;
    String title;
    String description;
    String content;
    String author;
    int bookmark;

    public StoryModel(int id, String image, String title, String description, String content, String author, int bookmark) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
        this.bookmark = bookmark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookmark() {
        return bookmark;
    }

    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }
}
