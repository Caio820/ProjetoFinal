package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.projetofinal.model.AppDatabase;
import com.example.projetofinal.model.ListItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TelaPrincipalActivity extends AppCompatActivity {

    private FloatingActionButton fabPerfil, fabAdicionar;
    private TextView textViewNome;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        Intent intent = getIntent();
        String nome = intent.getExtras().getString("Nome");
        textViewNome = findViewById(R.id.textViewNomePerfilTelaPrincipal);
        textViewNome.setText("Bem-vindo " + nome + ".");

        fabAdicionar = findViewById(R.id.floatingActionButtonAdicionar);
        fabAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipalActivity.this, AdicionarActivity.class);
                startActivity(intent);
            }
        });

        fabPerfil = findViewById(R.id.floatingActionButtonPerfil);
        fabPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipalActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        listItems = new ArrayList<>();
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name1").allowMainThreadQueries().build();
        listItems = db.itemDao().getAll();

        adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }
}

