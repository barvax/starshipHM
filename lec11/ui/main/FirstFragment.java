package com.example.lec11.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lec11.R;
import com.example.lec11.adapter.Adapter1;
import com.example.lec11.listeners.PassPersonDataListener;
import com.example.lec11.models.Person;
import com.example.lec11.repos.SwApiRepository;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements PassPersonDataListener {
    public static final String STARSHIP = "param1";
    public static final String POSITION = "param2";
    private MainViewModel mViewModel;
    private List<Person> myPeople;
    private RecyclerView recyclerView;
    private Adapter1 adapter;
    private Person currentPerson;
    Button nextPageBtn;
    Button previousPageBtn;

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = v.findViewById(R.id.rv_fragment_1);

        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nextPageBtn= view.findViewById(R.id.next_page);
        previousPageBtn = view.findViewById(R.id.previous_page_btn);

        previousPageBtn.setOnClickListener(view1 -> {
            mViewModel.previousPage();
            callPeople();
        });
        nextPageBtn.setOnClickListener(view1 -> {
            mViewModel.nextPage();
            callPeople();
        });
        mViewModel.getPersonCount().observe(getViewLifecycleOwner(),count ->{

        });
        callPeople();




    }

   public void callPeople(){
       mViewModel.getStarship().observe(getViewLifecycleOwner(), starships -> {

           myPeople = new ArrayList<>();
           myPeople.addAll(starships);
           adapter = new Adapter1(myPeople,this);
           recyclerView.setAdapter(adapter);
           recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

       });
   }

    @Override
    public void passData(Person person, View v , int pos) {

        currentPerson = person;
        SwApiRepository.homePlantUrl = person.getHomeworld();
        Bundle bundle = new Bundle();
        bundle.putSerializable(STARSHIP, currentPerson);
        bundle.putInt(POSITION, pos);
        AboutFragment x = AboutFragment.newInstance();
        x.setArguments(bundle);

        getFragmentManager() .beginTransaction()
                .replace(R.id.container, x)
                .commit();
    }
}