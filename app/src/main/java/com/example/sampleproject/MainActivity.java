package com.example.sampleproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.annotation.SuppressLint;
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
import com.example.sampleproject.RoomDatabase.ItemDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements AdapterListener {

    RecyclerView recyclerView;
    FloatingActionButton fl;
    public ForItemDatabase database;
    public  ItemDAO itemDAO;
    public CustomAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = ForItemDatabase.getInstance(this);
        itemDAO = database.getItemDao();
        recyclerView = findViewById(R.id.recycler);
        itemAdapter = new CustomAdapter(this,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);



        fl = findViewById(R.id.addingBtn);

//        fetchData();

        final Dialog dialog = new Dialog(this, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.add_item);
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
                TextView title,desc,img;
                Button add;
                add = dialog.findViewById(R.id.btnAddToDB);
                title = dialog.findViewById(R.id.addItemTitle);
                desc = dialog.findViewById(R.id.additemDesc);
                img = dialog.findViewById(R.id.imgLink);
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Item item = new Item(title.getText().toString(),desc.getText().toString(),img.getText().toString());

                        itemDAO.addItem(item);
                        itemAdapter.addItem(item);
                        title.setText("");
                        desc.setText("");
                        img.setText("");
                        dialog.dismiss();
                    }
                });
            }


        });


    }
    private void fetchData()
    {

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                List<Item> list = itemDAO.getAllItem();
                for(int i=0; i<list.size();i++)
                {
                    itemAdapter.addItem(list.get(i));
                }
            }
        });

    }



    @Override
    public void OnUpdate(Item item) {
        itemDAO.updateItem(item);
    }

    @Override
    public void OnDelete(Item item,int position) {
        itemDAO.deleteItem(item);
        itemAdapter.removeItem(position);

    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }
}










