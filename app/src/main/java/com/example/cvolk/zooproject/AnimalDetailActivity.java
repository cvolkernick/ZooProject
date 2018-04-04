package com.example.cvolk.zooproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalDetailActivity extends AppCompatActivity {

    private ImageView ivAnimal;
    private TextView tvName;
    private TextView tvWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        bindViews();
    }

    private void bindViews() {
        ivAnimal = findViewById(R.id.ivAnimal);
        tvName = findViewById(R.id.tvName);
        tvWeight = findViewById(R.id.tvWeight);
    }
}