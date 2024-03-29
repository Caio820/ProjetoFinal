package com.example.projetofinal.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

    @Database(entities = {ListItem.class, FormularioItem.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract ItemDao itemDao();
        public abstract FormularioDao formularioDao();

    }

