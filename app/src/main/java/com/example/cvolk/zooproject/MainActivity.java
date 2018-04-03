package com.example.cvolk.zooproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewAnimals(View view) {
        Intent intent = new Intent(getApplicationContext(), TypeActivity.class);
        startActivity(intent);
    }
}
