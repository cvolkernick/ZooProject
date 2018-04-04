package com.example.cvolk.zooproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        bindListeners();
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

    public void bindListeners(){

        ListView lvTypes = findViewById(R.id.lvTypes);
        lvTypes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), TypeDetailActivity.class);
                intent.putExtra("animalType", (String)parent.getItemAtPosition(position));

                Toast.makeText(TypeActivity.this, (String)parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        });
    }
}
