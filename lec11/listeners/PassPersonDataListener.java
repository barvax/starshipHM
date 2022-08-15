package com.example.lec11.listeners;

import android.view.View;

import com.example.lec11.models.Person;

public interface PassPersonDataListener {

    void passData(Person person, View v, int position);
}
