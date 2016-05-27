package com.demo.srikanth.hierarchyviewer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shrek on 5/26/16.
 */


public class Body {

    public String element;
    public String text;
    public List<Child> children = new ArrayList<Child>();

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Body{" +
                "element='" + element + '\'' +
                ", text='" + text + '\'' +
                ", children=" + children +
                '}';
    }
}