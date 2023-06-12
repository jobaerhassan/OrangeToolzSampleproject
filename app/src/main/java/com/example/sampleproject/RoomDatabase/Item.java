package com.example.sampleproject.RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "item")
public class Item {


    @ColumnInfo(name = "item_id")
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "desc")
    String desc;

    @ColumnInfo(name = "imgLink")
    String imgLink;


    public Item(String title, String desc, String imgLink){

        this.title = title;
        this.desc = desc;
        this.imgLink = imgLink;
    }

    @Ignore
    public Item (int id, String title, String desc, String imgLink)
    {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.imgLink = imgLink;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
