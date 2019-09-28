package com.example.projetofinal.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "formulario_item")
public class FormularioItem {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "nome")
    public String nome;

    @ColumnInfo(name = "idade")
    public Integer idade;

    @ColumnInfo(name = "sexo")
    public String sexo;

    @ColumnInfo(name = "peso")
    public Double peso;

    @ColumnInfo(name = "altura")
    public Double altura;

    @ColumnInfo(name = "email")
    public String email;

}
