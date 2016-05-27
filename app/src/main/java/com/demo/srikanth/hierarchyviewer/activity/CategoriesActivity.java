package com.demo.srikanth.hierarchyviewer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.demo.srikanth.hierarchyviewer.Constants;
import com.demo.srikanth.hierarchyviewer.R;
import com.demo.srikanth.hierarchyviewer.adapter.ChildAdapter;
import com.demo.srikanth.hierarchyviewer.adapter.TopLevelAdapter;
import com.demo.srikanth.hierarchyviewer.data.Injector;
import com.demo.srikanth.hierarchyviewer.model.ChildCategory;
import com.demo.srikanth.hierarchyviewer.model.toplevel.Body;
import com.demo.srikanth.hierarchyviewer.model.toplevel.TopLevelCategories;

/**
 * Created by shrek on 5/26/16.
 */
public class CategoriesActivity extends AppCompatActivity implements CategoryContract, TopLevelAdapter.OnClickListener {

    public static final String EXTRA_ID = "id";
    public static final String EXTRA_URL = "url";

    private String id;
    private String url;

    private RecyclerView childRecycler;
    private ChildAdapter childAdapter;
    private TopLevelAdapter topLevelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_layout);
        childRecycler = (RecyclerView) findViewById(R.id.child_level_recycler);
        childRecycler.setLayoutManager(new LinearLayoutManager(this));
        childRecycler.addItemDecoration(new SimpleDividerItemDecoration(this));
        topLevelAdapter = new TopLevelAdapter(null);
        childRecycler.setAdapter(topLevelAdapter);
        id = getIntent().getStringExtra(EXTRA_ID);
        url = getIntent().getStringExtra(EXTRA_URL);
        CategoryPresenter presenter = new CategoryPresenter(this, Injector.provideTuneInService(Constants.BASE_URL));
        presenter.initData(url);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, getString(R.string.unable_to_load_data), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showTopLevelCategories(TopLevelCategories categories) {

        topLevelAdapter = new TopLevelAdapter(categories);
        topLevelAdapter.setOnClickListener(this);
        childRecycler.setAdapter(topLevelAdapter);
    }

    @Override
    public void showChildCategories(ChildCategory childCategory) {
        childAdapter = new ChildAdapter(childCategory);
        childRecycler.setAdapter(childAdapter);
    }

    @Override
    public void OnClick(Body body) {
        Intent intent = new Intent(this, CategoriesActivity.class);
        intent.putExtra(CategoriesActivity.EXTRA_ID, body.getKey());
        intent.putExtra(CategoriesActivity.EXTRA_URL, body.getURL());
        startActivity(intent);
    }
}
