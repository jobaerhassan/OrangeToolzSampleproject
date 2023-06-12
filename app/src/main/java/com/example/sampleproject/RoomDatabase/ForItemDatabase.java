package com.example.sampleproject.RoomDatabase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class} , version = 1)
public abstract class ForItemDatabase extends RoomDatabase {

    public static ForItemDatabase INSTANCE;

    public abstract ItemDAO getItemDao();

    public static ForItemDatabase getInstance(Context context){
        if(INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context,ForItemDatabase.class, "itemDatabase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

}
