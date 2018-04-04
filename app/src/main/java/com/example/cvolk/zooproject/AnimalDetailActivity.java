package com.example.cvolk.zooproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cvolk.zooproject.model.animals.Animal;

public class AnimalDetailActivity extends AppCompatActivity {

    private ImageView ivAnimal;
    private TextView tvName;
    private TextView tvWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        bindViews();

        Animal animal = (Animal)getIntent().getSerializableExtra("data");
        String[] parts = animal.getClass().getCanonicalName().split("\\.");
        String animalName = parts[parts.length - 1];

        int resourceId = 0;
        switch(animal.getSimpleClassName())
        {
            case "Tiger":
                resourceId = R.drawable.tiger;
                break;
            case "Snake":
                resourceId = R.drawable.snake;
                break;
            case "Monkey":
                resourceId = R.drawable.monkey;
                break;
            case "Lizard":
                resourceId = R.drawable.lizard;
                break;
        }

        ivAnimal.setBackgroundResource(resourceId);
        tvName.setText(animalName);
        tvWeight.setText(String.valueOf(animal.getWeight()));
    }

    private void bindViews() {
        ivAnimal = findViewById(R.id.ivAnimal);
        tvName = findViewById(R.id.tvName);
        tvWeight = findViewById(R.id.tvWeight);
    }
}