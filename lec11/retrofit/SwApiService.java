package com.example.lec11.retrofit;

import com.example.lec11.models.StarshipResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SwApiService {
    @GET("starships")
    Call<StarshipResponse> getStarships(@Query("page") int page ,@Query("format") String  format);

    static SwApiService create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(SwApiService.class);
    }
}
