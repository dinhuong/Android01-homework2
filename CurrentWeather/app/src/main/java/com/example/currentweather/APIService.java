package com.example.currentweather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("weather")
    Call<GetWeatherResponse> search(@Query("q") String cityName,
                                    @Query("appid") String apikey);
}
