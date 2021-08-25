package com.example.mentalhealthapp;

public class JournalEntry {
    //TODO has to link this with sqlite

    private String title;
    private String content;

    public JournalEntry(String title, String content) {
        this.title = title;
        this.content = content;
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
}
