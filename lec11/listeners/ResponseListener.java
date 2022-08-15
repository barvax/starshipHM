package com.example.lec11.listeners;

import com.example.lec11.models.Planet;
import com.example.lec11.models.Person;

import java.util.List;

public interface ResponseListener {

    void onPersonArrived(List<Person> people);
    void onPlanetArrived(Planet planet);
    void onPersonCountArrived(int count);
}
