package com.demo.srikanth.hierarchyviewer.activity;

import android.util.Log;

import com.demo.srikanth.hierarchyviewer.Constants;
import com.demo.srikanth.hierarchyviewer.data.TuneInService;
import com.demo.srikanth.hierarchyviewer.model.ChildCategory;
import com.demo.srikanth.hierarchyviewer.model.toplevel.TopLevelCategories;
import com.google.gson.Gson;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.ResponseBody;
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
        queryMap.put(Constants.RENDER, Constants.JSON);

        tuneInService.getDynamicCategories(id, queryMap).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {

                    Gson gson = new Gson();
                    try {
                        String responseString = response.body().string();
                        JSONObject json = new JSONObject(responseString);
                        JSONArray jsonArray = json.getJSONArray(Constants.BODY);

                        JSONObject jsonobject = jsonArray.getJSONObject(0);
                        Iterator<String> iterator = jsonobject.keys();
                        boolean foundChildrenKey = false;
                        while (iterator.hasNext()) {
                            String key = iterator.next();
                            foundChildrenKey = key.equals(Constants.CHILDREN);
                        }
                        if (foundChildrenKey) {
                            ChildCategory childCategory = gson.fromJson(responseString, ChildCategory.class);
                            categoryView.showChildCategories(childCategory);
                        } else {
                            TopLevelCategories categories = gson.fromJson(responseString, TopLevelCategories.class);
                            categoryView.showTopLevelCategories(categories);
                        }
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                categoryView.showErrorMessage();
            }
        });
    }
}
