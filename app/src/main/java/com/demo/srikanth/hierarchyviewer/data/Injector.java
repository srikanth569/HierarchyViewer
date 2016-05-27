package com.demo.srikanth.hierarchyviewer.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shrek on 5/26/16.
 */
public class Injector {

    public static Retrofit provideRetrofit(String baseUrl) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static TuneInService provideTuneInService(String baseUrl) {

        return provideRetrofit(baseUrl).create(TuneInService.class);
    }
}
