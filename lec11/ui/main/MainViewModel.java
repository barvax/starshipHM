package com.example.lec11.ui.main;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lec11.listeners.ResponseListener;
import com.example.lec11.models.Planet;
import com.example.lec11.models.Person;
import com.example.lec11.repos.SwApiRepository;

import java.util.List;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<Person>> starshipLiveData;
    MutableLiveData<Planet> planetLiveData;
    MutableLiveData<Integer> personCountLiveData;


    public LiveData<Integer> getPersonCount(){
        if(personCountLiveData==null){
            personCountLiveData = new MutableLiveData<>();
        }

        SwApiRepository.getInstance()
                .getPersonCount(new ResponseListener() {
                    @Override
                    public void onPersonArrived(List<Person> people) {
                        starshipLiveData.postValue(people);
                    }
                    public void onPlanetArrived(Planet planet) {
                        planetLiveData.postValue(planet);
                    }

                    @Override
                    public void onPersonCountArrived(int count) {
                        personCountLiveData.postValue(count);
                    }


                });
        return personCountLiveData;
    }
    public LiveData<List<Person>> getStarship(){
        if(starshipLiveData==null){
            starshipLiveData = new MutableLiveData<>();
        }

        SwApiRepository.getInstance()
                .getStarShips(new ResponseListener() {
                    @Override
                    public void onPersonArrived(List<Person> people) {
                        starshipLiveData.postValue(people);
                    }
                    public void onPlanetArrived(Planet planet) {
                        planetLiveData.postValue(planet);
                    }

                    @Override
                    public void onPersonCountArrived(int count) {

                    }
                });
    return starshipLiveData;
    }


    public LiveData<Planet> getPlanet(){
        if(planetLiveData==null){
            planetLiveData = new MutableLiveData<>();
        }

        SwApiRepository.getInstance()
                .getPlanet( new ResponseListener() {
                    @Override
                    public void onPersonArrived(List<Person> people) {

                    }
                    public void onPlanetArrived(Planet planet) {
                        planetLiveData.postValue(planet);
                    }

                    @Override
                    public void onPersonCountArrived(int count) {

                    }
                });
        return planetLiveData;
    }

    public void nextPage(){
        if(SwApiRepository.indexPage< personCountLiveData.getValue()){
            SwApiRepository.indexPage++;
        }

    }
    public void previousPage(){
        if(SwApiRepository.indexPage>1){
            SwApiRepository.indexPage--;
        }
    }
}