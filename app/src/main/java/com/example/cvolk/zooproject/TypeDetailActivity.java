package com.example.cvolk.zooproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cvolk.zooproject.adapter.RecyclerAdapter;
import com.example.cvolk.zooproject.data.DataFactory;

public class TypeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_detail);

        bindRecyclerView();
    }

    private void bindRecyclerView() {
        RecyclerView rvMain = findViewById(R.id.rvMain);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerAdapter adapter = new RecyclerAdapter(DataFactory.getAnimalsOfType(getIntent().getStringExtra("animalType")));
        rvMain.setAdapter(adapter);
        rvMain.setLayoutManager(layoutManager);
    }
}
