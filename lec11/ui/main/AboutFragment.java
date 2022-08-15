package com.example.lec11.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lec11.R;
import com.example.lec11.models.Person;
import com.example.lec11.models.Planet;


public class AboutFragment extends Fragment {
    Person currentPerson;
    Planet currentPlanet;
    Bundle args;
    private MainViewModel mViewModel;
    TextView tv_person_name;
    TextView tvBirthYear;
    TextView gender;
    TextView homePlanet;
    TextView population;
    Button backBtn;



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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        args = getArguments();
        Person myPerson = (Person) args.getSerializable(FirstFragment.STARSHIP);
        int position =  args.getInt(FirstFragment.POSITION);
        currentPerson = myPerson;
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.getPlanet().observe(getViewLifecycleOwner(),planet -> {
            currentPlanet = planet;
            findViews(view);
            setText();
        });
    backBtn = view.findViewById(R.id.about_back_btn);
    backBtn.setOnClickListener(view1 -> {
        getFragmentManager() .beginTransaction()
                .replace(R.id.container, FirstFragment.newInstance())
                .commit();
    });

    }

    private void findViews(View view){
        tv_person_name = view.findViewById(R.id.tv_about_person_name);
        tvBirthYear = view.findViewById(R.id.tv_about_birth_year);
        gender = view.findViewById(R.id.tv_about_gender);
        homePlanet = view.findViewById(R.id.tv_about_homeplanet);
        population = view.findViewById(R.id.tv_about_population);
    }
    public void setText(){
        tv_person_name.setText("Name: " +currentPerson.getName());
        tvBirthYear.setText("Birth Year: "+ currentPerson.getBirthYear());
        gender.setText("Gender: "+currentPerson.getGender());
        homePlanet.setText("Home Planet: "+currentPlanet.getName());
        population.setText("Population: "+ currentPlanet.getPopulation());
    }
}