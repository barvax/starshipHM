package com.example.lec11.repos;

import android.util.Log;

import com.example.lec11.listeners.ResponseListener;
import com.example.lec11.models.Planet;
import com.example.lec11.models.SwApiResponse;
import com.example.lec11.retrofit.SwApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SwApiRepository {

    SwApiService retrofit;
    public static String homePlantUrl;
    public static int indexPage =1;
    private static SwApiRepository instance;
    private SwApiRepository(){
        retrofit = SwApiService.create();
    }
    public synchronized static SwApiRepository getInstance(){
        if (instance==null){
            instance = new SwApiRepository();
        }
        return instance;
    }
    public void getPersonCount(ResponseListener listener){
        Call<SwApiResponse> call =  retrofit.getPersonCount("json");
        call.enqueue(new Callback<SwApiResponse>() {
            @Override
            public void onResponse(Call<SwApiResponse> call, Response<SwApiResponse> response) {

                listener.onPersonCountArrived(response.body().getCount());
            }

            @Override
            public void onFailure(Call<SwApiResponse> call, Throwable t) {

            }
        });
    }
    public void getStarShips(ResponseListener listener){
      Call<SwApiResponse> call =  retrofit.getStarships(indexPage,"json");
      call.enqueue(new Callback<SwApiResponse>() {
          @Override
          public void onResponse(Call<SwApiResponse> call, Response<SwApiResponse> response) {

           listener.onPersonArrived(response.body().getPersonList());
          }

          @Override
          public void onFailure(Call<SwApiResponse> call, Throwable t) {

          }
      });
    }
    public void getPlanet(ResponseListener listener ){
    String x = homePlantUrl;

        String[] arrOfStr = x.split("https://swapi.dev/api/");
        String z = arrOfStr[1];
        z = z.substring(0, z.length() - 1);
        System.out.println(z);


        // TODO: 13/08/2022 need to pass the person homeplanet as the url 
        Call<Planet> call =  retrofit.getPlanet(z,"json");
        call.enqueue(new Callback<Planet>() {
            @Override
            public void onResponse(Call<Planet> call, Response<Planet> response) {
                listener.onPlanetArrived(response.body());
            }

            @Override
            public void onFailure(Call<Planet> call, Throwable t) {

            }

        });
    }
}


