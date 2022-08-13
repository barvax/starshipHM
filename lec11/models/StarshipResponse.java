package com.example.lec11.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StarshipResponse {

    private int count;
    private String next;
    private String previous;
    @SerializedName("results")
    private List<Starship> starshipList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Starship> getStarshipList() {
        return starshipList;
    }

    public void setStarshipList(List<Starship> starshipList) {
        this.starshipList = starshipList;
    }
}
