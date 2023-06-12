package com.example.sampleproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleproject.RoomDatabase.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
     Context context;
     ArrayList<Item> itemList;

    public CustomAdapter(Context context) {
        this.context = context;
        itemList = new ArrayList<Item>();
    }
    public void addItem(Item item)
    {
        itemList.add(item);
        notifyDataSetChanged();
    }
    public void removeItem(int id, int pos)
    {

    }



    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.text_title.setText(itemList.get(position).getTitle());
        holder.text_desc.setText(itemList.get(position).getDesc());
        if(itemList.get(position).getImgLink()!=null)
        {
            Picasso.get().load(itemList.get(position).getImgLink()).into(holder.img);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
}
