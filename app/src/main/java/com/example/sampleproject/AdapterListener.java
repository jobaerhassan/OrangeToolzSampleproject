package com.example.sampleproject;

import com.example.sampleproject.RoomDatabase.Item;

public interface AdapterListener {

    void OnUpdate(Item item);
    void OnDelete(Item item, int position);

}
