package com.apple.retrofitdemo.weatherAndMovie;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by apple on 17/4/29.
 * 如何管理Retrofit
 */
public class RetrofitHelper {
    private static String BASE_URL = "https://api.douban.com/v2/movie/";
    private static Retrofit retrofit;
    private static APIService apiService;
    public static Retrofit getRetrofit(){
        if (retrofit==null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
            return retrofit;

    }
    public static APIService getAPIService(){
        if (apiService==null){
            apiService = getRetrofit().create(APIService.class);
        }
        return apiService;

    }
}
