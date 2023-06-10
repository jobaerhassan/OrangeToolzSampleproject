package com.example.sampleproject.RoomDatabase;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDAO {

    @Insert
    public void addItem(Item item);

    @Update
    public void updateItem(Item item);

    @Delete
    public void deleteItem(Item item);

    @Query("select * from person")
    public List<Item> getAllItem();

    @Query("select * from person where person_id==:id")
    public Item getItem(int id);


}
