package com.demo.srikanth.hierarchyviewer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.demo.srikanth.hierarchyviewer.Constants;
import com.demo.srikanth.hierarchyviewer.R;
import com.demo.srikanth.hierarchyviewer.adapter.TopLevelAdapter;
import com.demo.srikanth.hierarchyviewer.data.Injector;
import com.demo.srikanth.hierarchyviewer.model.toplevel.Body;
import com.demo.srikanth.hierarchyviewer.model.toplevel.TopLevelCategories;

public class MainActivity extends AppCompatActivity implements TopLevelCategoriesContract, TopLevelAdapter.OnClickListener {

    private RecyclerView topLevelRecycler;
    private TopLevelAdapter topLevelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topLevelRecycler = (RecyclerView) findViewById(R.id.top_level_recycler);
        topLevelRecycler.setLayoutManager(new LinearLayoutManager(this));

        topLevelAdapter = new TopLevelAdapter(null);
        topLevelRecycler.setAdapter(topLevelAdapter);
        topLevelAdapter.setOnClickListener(this);

        TopLevelPresenter booksPresenter = new TopLevelPresenter(this, Injector.provideTuneInService(Constants.BASE_URL));
        booksPresenter.initDataSet();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, getString(R.string.unable_to_load_data), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showTopLevelCategories(TopLevelCategories categories) {
        topLevelAdapter.setData(categories);
    }

    @Override
    public void OnClick(Body body) {
        Intent intent = new Intent(this, CategoriesActivity.class);
        intent.putExtra(CategoriesActivity.EXTRA_ID, body.getKey());
        intent.putExtra(CategoriesActivity.EXTRA_URL, body.getURL());
        startActivity(intent);
    }
}
