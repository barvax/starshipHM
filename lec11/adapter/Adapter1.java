package com.example.lec11.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lec11.R;
import com.example.lec11.listeners.PassStarshipDataListener;
import com.example.lec11.models.Starship;
import com.example.lec11.ui.main.AboutFragment;
import com.example.lec11.ui.main.FirstFragment;

import java.util.ArrayList;
import java.util.List;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.spaceViewHolder> {
    List<Starship> starshipsList ;
    public static final String STARSHIP = "param1";
    private PassStarshipDataListener listener;

    public Adapter1(List<Starship> starshipsList, PassStarshipDataListener listener) {
        this.starshipsList = starshipsList;
        this.listener = listener;
    }



    @NonNull
    @Override
    public spaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rox1,parent,false);
        return new spaceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull spaceViewHolder holder, int position) {
        Starship starship = starshipsList.get(position);
        holder.starshipName.setText(starship.getName());
        View z = holder.itemView.findViewById(R.id.tv_starship_name);



        z.setOnClickListener(view -> {
            listener.passData(starship ,z);

//            NavController controller = Navigation.findNavController(z);
//            Bundle bundle = new Bundle();
//            bundle.putSerializable(STARSHIP, starship);
//
//            controller.navigate(R.id.action_firstFragment_to_aboutFragment,bundle);




        });


    }

    @Override
    public int getItemCount() {
        if(starshipsList.size()!=0){

            return starshipsList.size();
        }
       return 0;
    }




    static class spaceViewHolder extends RecyclerView.ViewHolder{
        TextView starshipName;
         public spaceViewHolder(@NonNull View itemView) {
             super(itemView);

             starshipName = itemView.findViewById(R.id.tv_starship_name);
         }
     }
}
