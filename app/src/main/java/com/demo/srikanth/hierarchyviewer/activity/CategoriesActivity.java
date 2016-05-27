package com.demo.srikanth.hierarchyviewer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.srikanth.hierarchyviewer.Constants;
import com.demo.srikanth.hierarchyviewer.R;
import com.demo.srikanth.hierarchyviewer.data.Injector;
import com.demo.srikanth.hierarchyviewer.model.toplevel.TopLevelCategories;

/**
 * Created by shrek on 5/26/16.
 */
public class CategoriesActivity extends AppCompatActivity implements CategoryContract {

    public static String EXTRA_ID = "id";
    public static String EXTRA_URL = "url";

    private String id;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_layout);
        id = getIntent().getStringExtra(EXTRA_ID);
        url = getIntent().getStringExtra(EXTRA_URL);
        CategoryPresenter presenter = new CategoryPresenter(this, Injector.provideTuneInService(Constants.BASE_URL));
        presenter.initData(url);
    }

    @Override
    public void showErrorMessage() {

    }

    @Override
    public void showTopLevelCategories(TopLevelCategories categories) {

    }
}
