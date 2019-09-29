package com.example.projetofinal.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FormularioDao {

    @Query("SELECT * FROM formulario_item")
    List<FormularioItem> getAll();

    @Insert
    void insertAll(FormularioItem... items);

    @Delete
    void delete(FormularioItem item);
}
