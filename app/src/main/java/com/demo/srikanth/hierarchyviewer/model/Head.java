package com.demo.srikanth.hierarchyviewer.model;


/**
 * Created by shrek on 5/26/16.
 */


public class Head {


    private String title;
    private String status;

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Head{" +
                "title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}