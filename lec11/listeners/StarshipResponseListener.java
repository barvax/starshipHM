package com.example.lec11.listeners;

import com.example.lec11.models.Starship;

import java.util.List;

public interface StarshipResponseListener {

    void onStarshipArrived(List<Starship>starships);
}
