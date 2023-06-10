package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    CustomAdapter adapter;
    ArrayList<Item>itemArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recycler);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        arrayInitialize();

        adapter = new CustomAdapter(this, itemArrayList);
        recyclerView.setAdapter(adapter);

    }

    private void arrayInitialize() {
        Item item = new Item(R.drawable.brand1,"Company" , "this is good");
        itemArrayList.add(item);
        itemArrayList.add(item);
        itemArrayList.add(item);
        itemArrayList.add(item);
        itemArrayList.add(item);
    }

    private void setRecyclerView() {


    }
}