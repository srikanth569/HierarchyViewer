package com.demo.srikanth.hierarchyviewer.model;

/**
 * Created by shrek on 5/26/16.
 */

public class Head {

    public String title;

    public String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Head{" +
                "title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}