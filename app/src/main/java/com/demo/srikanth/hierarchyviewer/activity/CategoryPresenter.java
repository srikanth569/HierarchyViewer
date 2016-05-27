package com.demo.srikanth.hierarchyviewer.activity;

import android.util.Log;
import android.widget.Toast;

import com.demo.srikanth.hierarchyviewer.data.TuneInService;
import com.demo.srikanth.hierarchyviewer.model.TopLevelCategories;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
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
        queryMap.put("render", "json");

        tuneInService.getDynamicCategories(id, queryMap).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {

                    Gson gson = new Gson();
                    try {
                        JSONObject json = new JSONObject(response.body().string());
                        JSONArray jsonArray = json.getJSONArray("body");

                        JSONObject jsonobject = jsonArray.getJSONObject(0);
                        Iterator<String> iterator = jsonobject.keys();
                        boolean foundChilrenKey = false;
                        while (iterator.hasNext()) {
                            String key = iterator.next();
                            foundChilrenKey = key.equals("children");
                        }
                        if (foundChilrenKey) {
                        } else {
                            TopLevelCategories categories = gson.fromJson(response.body().charStream(), TopLevelCategories.class);
                            categoryView.showTopLevelCategories(categories);
                        }
                        Log.v("Testing", "Fuck this shit " + foundChilrenKey);
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.v("Testing", "Failure");
            }
        });
    }

    public static Map<String, String> parse(JSONObject json, Map<String, String> out) throws JSONException {
        Iterator<String> keys = json.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String val = null;
            try {
                JSONObject value = json.getJSONObject(key);
                parse(value, out);
            } catch (Exception e) {
                val = json.getString(key);
            }

            if (val != null) {
                out.put(key, val);
            }
        }
        return out;
    }
}
