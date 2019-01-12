package com.example.hp.firebaseandupdate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder>{
    ArrayList<String> Names;
    ArrayList<Integer> Age;
    public AdapterClass(ArrayList<String> data,ArrayList<Integer> Age_p){
        Names=data;
        Age=Age_p;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.listitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.NameView.setText(String.valueOf(Names.get(position)));
        holder.AgeView.setText(String.valueOf(Age.get(position)));
    }


    @Override
    public int getItemCount() {
        return Names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView NameView;
        TextView AgeView;
        public ViewHolder(View itemView) {
            super(itemView);
            NameView=(TextView)itemView.findViewById(R.id.name_id);
            AgeView=(TextView)itemView.findViewById(R.id.age_id);
        }
    }
}
