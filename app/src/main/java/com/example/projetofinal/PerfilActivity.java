package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    private TextView textViewNome, textViewIdade, textViewSexo, textViewPeso, textViewAltura, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        textViewNome = findViewById(R.id.textViewNomePerfil);
        textViewIdade = findViewById(R.id.textViewIdadePerfil);
        textViewSexo = findViewById(R.id.textViewSexoPerfil);
        textViewPeso = findViewById(R.id.textViewPesoPerfil);
        textViewAltura = findViewById(R.id.textViewAlturaPerfil);
        textViewEmail = findViewById(R.id.textViewEmailPerfil);

        Intent intent = getIntent();
        
    }
}
