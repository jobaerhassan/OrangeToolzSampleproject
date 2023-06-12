package com.example.sampleproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView text_title, text_desc;
    ImageView img;
    CardView cardView;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        //initialize
        text_title = itemView.findViewById(R.id.textTitle);
        text_desc = itemView.findViewById(R.id.textDesc);
        img = itemView.findViewById(R.id.img_headline);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
