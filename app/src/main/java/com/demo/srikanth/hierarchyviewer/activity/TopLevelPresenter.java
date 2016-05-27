package com.demo.srikanth.hierarchyviewer.activity;

import com.demo.srikanth.hierarchyviewer.Constants;
import com.demo.srikanth.hierarchyviewer.data.TuneInService;
import com.demo.srikanth.hierarchyviewer.model.toplevel.TopLevelCategories;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shrek on 5/26/16.
 */
public class TopLevelPresenter {

    private final TopLevelCategoriesContract topLevelView;
    private final TuneInService tuneInService;

    public TopLevelPresenter(TopLevelCategoriesContract contract, TuneInService service) {
        topLevelView = contract;
        tuneInService = service;
    }

    public void initDataSet() {
        HashMap<String,String> queryMap = new HashMap<>();
        queryMap.put(Constants.RENDER,Constants.JSON);
        tuneInService.getTopLevelCategories(queryMap).enqueue(new Callback<TopLevelCategories>() {
            @Override
            public void onResponse(Call<TopLevelCategories> call, Response<TopLevelCategories> response) {
                topLevelView.showTopLevelCategories(response.body());
            }

            @Override
            public void onFailure(Call<TopLevelCategories> call, Throwable t) {
                topLevelView.showErrorMessage();
            }
        });
    }
}
