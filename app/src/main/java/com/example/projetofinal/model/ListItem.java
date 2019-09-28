package com.example.projetofinal.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "list_item")
public class ListItem {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "pressao")
    public String pressao;

    @ColumnInfo(name = "batimento")
    public String batimento;

}
