package com.demo.srikanth.hierarchyviewer.activity;

import android.util.Log;

import com.demo.srikanth.hierarchyviewer.data.TuneInService;
import com.demo.srikanth.hierarchyviewer.model.TopLevelCategories;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shrek on 5/26/16.
 */
public class CategoryPresenter {

    private final CategoryContract categoryView;
    private final TuneInService tuneInService;

    public CategoryPresenter(CategoryContract _categoryView, TuneInService _tuneInService) {
        categoryView = _categoryView;
        tuneInService = _tuneInService;
    }

    public void initData(String id) {
        HashMap<String, String> queryMap = new HashMap<>();
        queryMap.put("render", "json");
        queryMap.put("c", id);
        tuneInService.getCategories(queryMap).enqueue(new Callback<TopLevelCategories>() {
            @Override
            public void onResponse(Call<TopLevelCategories> call, Response<TopLevelCategories> response) {
                Log.v("Testing", "Success" + response.body().toString());
            }

            @Override
            public void onFailure(Call<TopLevelCategories> call, Throwable t) {
                Log.v("Testing", "Failure");
            }
        });
    }
}
