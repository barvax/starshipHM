package com.example.lec11.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lec11.R;
import com.example.lec11.models.Starship;


public class AboutFragment extends Fragment {
    Starship currentStarship;
    Bundle args;


    public AboutFragment() {
        // Required empty public constructor
    }


    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        args = getArguments();
        Starship myStarship = (Starship) args.getSerializable(FirstFragment.STARSHIP);

        Toast.makeText(getContext(), "hello from about fragment:" + myStarship.getName(), Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_about, container, false);
    }
}