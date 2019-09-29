package com.example.projetofinal.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDao {

    @Query("SELECT * FROM list_item")
    List<ListItem> getAll();

    @Insert
    void insertAll(ListItem... items);

    @Delete
    void delete(ListItem item);


}
