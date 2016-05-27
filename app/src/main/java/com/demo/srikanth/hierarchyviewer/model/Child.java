package com.demo.srikanth.hierarchyviewer.model;

/**
 * Created by shrek on 5/26/16.
 */

public class Child {

    public String element;
    public String type;
    public String text;
    public String URL;
    public String key;

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Child{" +
                "element='" + element + '\'' +
                ", type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", URL='" + URL + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}