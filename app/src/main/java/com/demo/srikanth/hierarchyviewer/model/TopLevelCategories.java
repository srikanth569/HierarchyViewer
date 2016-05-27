package com.demo.srikanth.hierarchyviewer.model;

/**
 * Created by shrek on 5/26/16.
 */

import java.util.ArrayList;
import java.util.List;


public class TopLevelCategories {

    private TopLevelHead topLevelHead;
    private List<TopLevelBody> topLevelBody = new ArrayList<>();

    /**
     * @return The topLevelHead
     */
    public TopLevelHead getTopLevelHead() {
        return topLevelHead;
    }

    /**
     * @param topLevelHead The topLevelHead
     */
    public void setTopLevelHead(TopLevelHead topLevelHead) {
        this.topLevelHead = topLevelHead;
    }

    /**
     * @return The topLevelBody
     */
    public List<TopLevelBody> getTopLevelBody() {
        return topLevelBody;
    }

    /**
     * @param topLevelBody The topLevelBody
     */
    public void setTopLevelBody(List<TopLevelBody> topLevelBody) {
        this.topLevelBody = topLevelBody;
    }

    @Override
    public String toString() {
        return "TopLevelCategories{" +
                "topLevelHead=" + topLevelHead +
                ", topLevelBody=" + topLevelBody +
                '}';
    }
}
