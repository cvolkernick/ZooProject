package com.example.cvolk.zooproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.cvolk.zooproject.adapter.CustomListAdapter;
import com.example.cvolk.zooproject.data.DataFactory;

public class TypeActivity extends AppCompatActivity {

    private ListView lvAnimalTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        DataFactory.initAnimals();
        bindViews();
        bindCustomList();
    }

    private void bindViews() {
        lvAnimalTypes = findViewById(R.id.lvTypes);
    }

    private void bindCustomList() {
        CustomListAdapter customListAdapter = new CustomListAdapter(
                this,
                R.layout.activity_type,
                DataFactory.getAnimalTypes()
        );

        lvAnimalTypes.setAdapter(customListAdapter);
    }
}
