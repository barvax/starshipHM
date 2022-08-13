package com.example.lec11.repos;

import android.util.Log;

import com.example.lec11.listeners.StarshipResponseListener;
import com.example.lec11.models.StarshipResponse;
import com.example.lec11.retrofit.SwApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SwApiRepository {

    SwApiService retrofit;
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

    public void getStarShips(StarshipResponseListener listener){
      Call<StarshipResponse> call =  retrofit.getStarships(1,"json");
      call.enqueue(new Callback<StarshipResponse>() {
          @Override
          public void onResponse(Call<StarshipResponse> call, Response<StarshipResponse> response) {
           Log.d("-------------", ""+ response.body().getStarshipList());
           listener.onStarshipArrived(response.body().getStarshipList());
          }

          @Override
          public void onFailure(Call<StarshipResponse> call, Throwable t) {

          }
      });
    }
}


