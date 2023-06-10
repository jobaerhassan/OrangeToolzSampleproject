package com.example.sampleproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
     Context context;
     ArrayList<Item> itemList;

    public CustomAdapter(Context context, ArrayList<Item>list) {
        this.context = context;
        this.itemList = list;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.text_title.setText(itemList.get(position).title);
        holder.text_source.setText(itemList.get(position).description);
        holder.img.setImageResource(itemList.get(position).img);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
