package com.demo.srikanth.hierarchyviewer.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.demo.srikanth.hierarchyviewer.R;
import com.demo.srikanth.hierarchyviewer.data.Injector;
import com.demo.srikanth.hierarchyviewer.model.TopLevelCategories;

public class MainActivity extends AppCompatActivity implements TopLevelCategoriesContract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopLevelPresenter booksPresenter = new TopLevelPresenter(this, Injector.provideTuneInService());

        booksPresenter.initDataSet();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, getString(R.string.unable_to_load_data), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showTopLevelCategories(TopLevelCategories categories) {
        Log.v("Testing", categories.toString());
    }
}
