package com.apple.retrofitdemo.weatherAndMovie;


import com.apple.retrofitdemo.weatherAndMovie.entity.Movie;
import com.apple.retrofitdemo.weatherAndMovie.entity.MovieResponse;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Zhk on 2015/12/20.
 */
public interface APIService {
    @GET("weather")
    Call<Weather> loadeather(@Query("cityname") String cityname, @Query("key") String apiKey);
    /**
     * retrofit 支持 rxjava 整合
     * 这种方法适用于新接口
     */
    @GET("weather")
    Observable<Weather> getWeatherData(@Query("cityname") String cityname, @Query("key") String apiKey);
    /**
     * 豆瓣电影列表获取接口
     */
//    String BASE_URL = "https://api.douban.com/v2/movie/";

    @GET("top250")
    Call<MovieResponse<List<Movie>>> getMovies(@Query("start") int start, @Query("count") int count);

}
