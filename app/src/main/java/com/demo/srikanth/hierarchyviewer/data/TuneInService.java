package com.demo.srikanth.hierarchyviewer.data;

import com.demo.srikanth.hierarchyviewer.model.TopLevelCategories;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by shrek on 5/26/16.
 */
public interface TuneInService {


    @GET("/")
    Call<TopLevelCategories> getTopLevelCategories(@QueryMap Map<String, String> queryMap);
}
