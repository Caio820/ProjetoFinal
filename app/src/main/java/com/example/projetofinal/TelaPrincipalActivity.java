package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TelaPrincipalActivity extends AppCompatActivity {

    private FloatingActionButton fabPerfil, fabAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        fabPerfil = findViewById(R.id.floatingActionButtonPerfil);
        fabPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipalActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });
    }
}
