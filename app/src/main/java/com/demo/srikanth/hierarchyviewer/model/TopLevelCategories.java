package com.demo.srikanth.hierarchyviewer.model;

/**
 * Created by shrek on 5/26/16.
 */

import java.util.ArrayList;
import java.util.List;


public class TopLevelCategories {

    private Head head;
    private List<Body> body = new ArrayList<>();

    /**
     * @return The head
     */
    public Head getHead() {
        return head;
    }

    /**
     * @param head The head
     */
    public void setHead(Head head) {
        this.head = head;
    }

    /**
     * @return The body
     */
    public List<Body> getBody() {
        return body;
    }

    /**
     * @param body The body
     */
    public void setBody(List<Body> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "TopLevelCategories{" +
                "head=" + head +
                ", body=" + body +
                '}';
    }
}
