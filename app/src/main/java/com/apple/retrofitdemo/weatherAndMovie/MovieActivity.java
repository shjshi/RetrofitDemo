package com.apple.retrofitdemo.weatherAndMovie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.apple.retrofitdemo.R;
import com.apple.retrofitdemo.weatherAndMovie.entity.Movie;
import com.apple.retrofitdemo.weatherAndMovie.entity.MovieResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MovieActivity extends AppCompatActivity {

    String BASE_URL = "https://api.douban.com/v2/movie/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);


//        getByRxJava();
    }
    public void onClick(View v){
        get();
    }

//    private void getByRxJava() {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//
//        APIService service = retrofit.create(APIService.class);
//        Observable<Weather> observable = service.getWeatherData("杭州", apiKey);
//        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Weather>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.i("zhk-MainActivity", "onCompleted: ");
//                        Toast.makeText(getApplicationContext(),
//                                "Completed",
//                                Toast.LENGTH_SHORT)
//                                .show();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("zhk-MainActivity", "onError: ", e);
//                        Toast.makeText(getApplicationContext(),
//                                "Error:" + e.getMessage(),
//                                Toast.LENGTH_SHORT)
//                                .show();
//                    }
//
//                    @Override
//                    public void onNext(Weather weather) {
//                        Weather.ResultEntity.TodayEntity todayEntiry = weather.getResult().getToday();
//                        Log.i("zhk-MainActivity", "onNext: 城市:" + todayEntiry.getCity() + " 温度:" + todayEntiry.getTemperature());
//                        Toast.makeText(MovieActivity.this, "城市:" + todayEntiry.getCity() + " 温度:" + todayEntiry.getTemperature(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }

    private void get() {
//        //每次请求都需要new？1 baseurl一个应用应该是一样的
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        //如果所有接口都写在这个APIService中，那么这个类的实例需要每次都create？
//        APIService service = retrofit.create(APIService.class);
        RetrofitHelper.getAPIService().getMovies(0,20).enqueue(new Callback<MovieResponse<List<Movie>>>() {
            @Override
            public void onResponse(Response<MovieResponse<List<Movie>>> response, Retrofit retrofit) {
                if (response.body()!=null){
                    Log.d("shj--",response.body().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
