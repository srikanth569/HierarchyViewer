package com.demo.srikanth.hierarchyviewer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shrek on 5/26/16.
 */
public class ChildCategory {

    public Head head;
    public List<Body> body = new ArrayList<Body>();

    public List<Body> getBody() {
        return body;
    }

    public void setBody(List<Body> body) {
        this.body = body;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "ChildCategory{" +
                "head=" + head +
                ", body=" + body +
                '}';
    }
}