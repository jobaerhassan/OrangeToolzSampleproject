package com.example.sampleproject;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import com.example.sampleproject.RoomDatabase.ForItemDatabase;
import com.example.sampleproject.RoomDatabase.Item;
import com.example.sampleproject.RoomDatabase.ItemDAO;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
     Context context;
     ArrayList<Item> itemList;

     private AdapterListener adapterListener;


    public CustomAdapter(Context context, AdapterListener listener) {
        this.context = context;
        itemList = new ArrayList<Item>();
        this.adapterListener = listener;


    }
    public void addItem(Item item)
    {
        itemList.add(item);
        notifyDataSetChanged();
    }
    public void removeItem(int pos)
    {
        itemList.remove(pos);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.text_title.setText(item.getTitle());
        holder.text_desc.setText(item.getDesc());
        //for loading the image from internet
        if (itemList.get(position).getImgLink() != null) {
            Picasso.get().load(item.getImgLink()).into(holder.img);
        }

        //for deleting
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                adapterListener.OnDelete(item, position);
                return true;
            }
        });


        //for updating
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_item);

                Button edtAdd = dialog.findViewById(R.id.btnAddToDB);
                EditText edtTitle = dialog.findViewById(R.id.addItemTitle);
                EditText edtDesc = dialog.findViewById(R.id.additemDesc);
                EditText edtImg = dialog.findViewById(R.id.imgLink);
                TextView edtAddOrUpdate = dialog.findViewById(R.id.addOrUpdateTxtView);
                edtAdd.setText("Update");
                edtAddOrUpdate.setText("Update data");

                edtTitle.setText(itemList.get(position).getTitle());
                edtDesc.setText(itemList.get(position).getDesc());
                edtImg.setText(itemList.get(position).getImgLink());
                edtAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String title = "", desc = "", img = "";
                        if (!edtTitle.getText().toString().equals("")) {
                            title = edtTitle.getText().toString();
                        }
                        if (!edtDesc.getText().toString().equals("")) {
                            desc = edtDesc.getText().toString();
                        }
                        if (!edtImg.getText().toString().equals("")) {
                            img = edtImg.getText().toString();
                        }
                        Item i = new Item(item.getId(),title, desc, img);
                        adapterListener.OnUpdate(i);
                        itemList.set(position, i);
                        notifyItemChanged(position);

                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
}
