package com.example.sampleproject.RoomDatabase;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class} , version = 1)
public abstract class ForItemDatabase extends RoomDatabase {

    public abstract ItemDAO getItemDao();


}
