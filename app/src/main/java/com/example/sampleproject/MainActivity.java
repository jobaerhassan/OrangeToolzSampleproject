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
import android.widget.TextView;
import android.widget.Toast;

import com.example.sampleproject.RoomDatabase.ForItemDatabase;
import com.example.sampleproject.RoomDatabase.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {


    CustomAdapter adapter;
    ArrayList<com.example.sampleproject.Item>itemArrayList = new ArrayList<>();
    ForItemDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //fab button initialization
        FloatingActionButton fl;
        fl = findViewById(R.id.addingBtn);
        arrayInitialize();
        adapter = new CustomAdapter(this, itemArrayList );
        recyclerView.setAdapter(adapter);

        initializeDB();

        //setting the dialog box with FAB button
        final Dialog dialog = new Dialog(this, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.add_item);
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                addInfo();
                dialog.show();
                TextView title,desc;
                Button add;
                add = dialog.findViewById(R.id.btnAddToDB);
                title = dialog.findViewById(R.id.addItemTitle);
                desc = dialog.findViewById(R.id.additemDesc);

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addSomevalueToDB(title.getText().toString(),desc.getText().toString());
                        dialog.dismiss();
                    }
                });
            }


        });









    }

    private void addSomevalueToDB(String title, String desc) {

        setDataInBackground(new Item(title,desc));

    }

    // private void setDialog() {


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

    //}

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
                database.getItemDao().addItem(item);


                //on finishing the given task
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(MainActivity.this, "added to database", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }

    private void arrayInitialize() {
        com.example.sampleproject.Item item = new com.example.sampleproject.Item(R.drawable.brand1,"dfdfad","adfadf");
        itemArrayList.add(item);


    }

    private void setRecyclerView(RecyclerView recyclerView) {


    }
}