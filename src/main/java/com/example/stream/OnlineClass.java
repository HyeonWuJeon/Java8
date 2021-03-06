package com.example.stream;

import java.util.Optional;

public class OnlineClass {
    private Integer id;
    private String title;
    private boolean colsed;
    public Progress progress;

    public OnlineClass(Integer id, String title, boolean colsed) {
        this.id = id;
        this.title = title;
        this.colsed = colsed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isColsed() {
        return colsed;
    }

    public void setColsed(boolean colsed) {
        this.colsed = colsed;
    }

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
