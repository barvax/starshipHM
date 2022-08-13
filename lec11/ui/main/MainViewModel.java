package com.example.lec11.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lec11.listeners.StarshipResponseListener;
import com.example.lec11.models.Starship;
import com.example.lec11.repos.SwApiRepository;

import java.util.List;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<Starship>> starshipLiveData;

    public LiveData<List<Starship>> getStarship(){
        if(starshipLiveData==null){
            starshipLiveData = new MutableLiveData<>();
        }

        SwApiRepository.getInstance()
                .getStarShips(new StarshipResponseListener() {
                    @Override
                    public void onStarshipArrived(List<Starship> starships) {
                        starshipLiveData.postValue(starships);
                    }
                });
    return starshipLiveData;
    }
}