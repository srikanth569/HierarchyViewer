package com.demo.srikanth.hierarchyviewer.activity;

import com.demo.srikanth.hierarchyviewer.model.TopLevelCategories;

/**
 * Created by shrek on 5/26/16.
 */
public interface CategoryContract {
    void showErrorMessage();

    void showTopLevelCategories(TopLevelCategories categories);
}
