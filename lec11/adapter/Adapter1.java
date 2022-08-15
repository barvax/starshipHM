package com.example.lec11.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lec11.R;
import com.example.lec11.listeners.PassPersonDataListener;
import com.example.lec11.models.Person;

import java.util.List;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.spaceViewHolder> {
    List<Person> starshipsList ;
    public static final String STARSHIP = "param1";
    private PassPersonDataListener listener;

    public Adapter1(List<Person> starshipsList, PassPersonDataListener listener) {
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
        Person person = starshipsList.get(position);
        holder.starshipName.setText(person.getName());
        View z = holder.itemView.findViewById(R.id.tv_starship_name);



        z.setOnClickListener(view -> {
//            Toast.makeText(z.getContext(), "position in adapter: "+position, Toast.LENGTH_SHORT).show();
            listener.passData(person,z ,position);

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
