package com.example.cvolk.zooproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cvolk.zooproject.R;
import com.example.cvolk.zooproject.model.animals.Animal;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<Animal> animals;

    public RecyclerAdapter(List<Animal> animals) {
        this.animals = animals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int viewNum;

        switch (viewType) {
            case 0:
                viewNum = R.layout.small_item;
                break;
            case 1:
                viewNum = R.layout.medium_item;
                break;
            case 2:
                viewNum = R.layout.large_item;
                break;
            default:
                viewNum = 3;
        }

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(viewNum, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Animal animal = animals.get(position);

        if (animal != null) {
            String[] parts = animal.getClass().getCanonicalName().split("\\.");
            String animalName = parts[parts.length - 1];
            holder.tvName.setText(animalName);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Animal a = animals.get(position);
        int viewNum;

        if (a.getWeight() < 50) {
            viewNum = 0;
        }
        else if(a.getWeight() >= 50 && a.getWeight() <= 150) {
            viewNum = 1;
        }
        else {
            viewNum = 3;
        }

        return viewNum;
    }


    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
