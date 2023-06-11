package com.example.sampleproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sampleproject.RoomDatabase.ForItemDatabase;
import com.example.sampleproject.RoomDatabase.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {


    CustomAdapter adapter;
    ArrayList<com.example.sampleproject.Item>itemArrayList = new ArrayList<>();
    ForItemDatabase database;
    FloatingActionButton fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recycler);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fl = findViewById(R.id.addingBtn);
        arrayInitialize();


        //setting the dialog box with FAB button
        final Dialog dialog = new Dialog(this, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.add_item);
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                addInfo();
                dialog.show();
            }


        });




//        adapter = new CustomAdapter(this, itemArrayList );
//        recyclerView.setAdapter(adapter);
//        initializeDB();


    }

    private void setDialog() {


//        EditText title, desc;
//        title = dialog.findViewById(R.id.addItemTitle);
//        desc = dialog.findViewById(R.id.additemDesc);
//        Button addBtn = dialog.findViewById(R.id.btnAddToDB);


//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                com.example.sampleproject.RoomDatabase.Item item = new com.example.sampleproject.RoomDatabase.Item(title.getText().toString(),desc.getText().toString());
//                setDataInBackground(item);
//                dialog.dismiss();
//            }
//        });

//            dialog.show();

    }

    private void initializeDB() {
        RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };
        database = Room.databaseBuilder(getApplicationContext(),ForItemDatabase.class,"database").addCallback(myCallBack).build();




    }

    private void setDataInBackground(com.example.sampleproject.RoomDatabase.Item item) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());


        executorService.execute(new Runnable() {
            @Override
            public void run() {

                //background  tasking



                //on finishing the given task
                handler.post(new Runnable() {
                    @Override
                    public void run() {


                    }
                });

            }
        });
    }

    private void arrayInitialize() {
        com.example.sampleproject.Item item = new com.example.sampleproject.Item(R.drawable.brand1,"dfdfad","adfadf");
        itemArrayList.add(item);
//        setDataInBackground(new Item("adfadf","adfasdfa"));


    }

    private void setRecyclerView(RecyclerView recyclerView) {


    }
}