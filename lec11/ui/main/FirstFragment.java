package com.example.lec11.ui.main;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lec11.MainActivity;
import com.example.lec11.R;
import com.example.lec11.adapter.Adapter1;
import com.example.lec11.listeners.PassStarshipDataListener;
import com.example.lec11.models.Starship;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements PassStarshipDataListener {
    public static final String STARSHIP = "param1";
    private MainViewModel mViewModel;
    private List<Starship>myStarships  =new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter1 adapter;
    private Starship currentStarship;

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


        mViewModel.getStarship().observe(getViewLifecycleOwner(), starships -> {

            myStarships.addAll(starships);
            adapter = new Adapter1(myStarships ,this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        });

    }

   

    @Override
    public void passData(Starship starship ,View v) {
        Toast.makeText(getActivity(), "you choose: "+ starship.getName()+" press next", Toast.LENGTH_SHORT).show();
        currentStarship = starship;

            Bundle bundle = new Bundle();
            bundle.putSerializable(STARSHIP, currentStarship);
       AboutFragment x = AboutFragment.newInstance();
       x.setArguments(bundle);

        getFragmentManager() .beginTransaction()
                .replace(R.id.container, x)
                .commit();
    }
}