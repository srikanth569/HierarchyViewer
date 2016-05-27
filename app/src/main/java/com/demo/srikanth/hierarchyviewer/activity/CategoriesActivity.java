package com.demo.srikanth.hierarchyviewer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.demo.srikanth.hierarchyviewer.R;

/**
 * Created by shrek on 5/26/16.
 */
public class CategoriesActivity extends Activity {

    public static String EXTRA_ID = "id";

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_layout);
        id = getIntent().getStringExtra(EXTRA_ID);
        Toast.makeText(this,id,Toast.LENGTH_LONG).show();
    }
}
