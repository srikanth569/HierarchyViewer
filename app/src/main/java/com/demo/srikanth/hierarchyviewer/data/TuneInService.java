package com.demo.srikanth.hierarchyviewer.data;

import com.demo.srikanth.hierarchyviewer.model.TopLevelCategories;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by shrek on 5/26/16.
 */
public interface TuneInService {

    @GET("/")
    Call<TopLevelCategories> getTopLevelCategories(@QueryMap Map<String, String> queryMap);

    @GET("Browse.ashx")
    Call<TopLevelCategories> getCategories(@QueryMap Map<String, String> queryMap);

    @GET
    Call<TopLevelCategories> getCategories(@Url String url, @QueryMap Map<String, String> queryMap);



}
