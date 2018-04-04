package com.example.cvolk.zooproject.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cvolk.zooproject.AnimalDetailActivity;
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

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(viewType, parent, false);

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
            viewNum = R.layout.small_item;
        }
        else if(a.getWeight() >= 50 && a.getWeight() <= 150) {
            viewNum = R.layout.medium_item;
        }
        else {
            viewNum = R.layout.large_item;
        }

        return viewNum;
    }


    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Animal animal = animals.get(getLayoutPosition());

            Intent intent = new Intent(itemView.getContext(), AnimalDetailActivity.class);
            intent.putExtra("data", animal);
            itemView.getContext().startActivity(intent);
        }
    }
}
