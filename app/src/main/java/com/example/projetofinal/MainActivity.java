package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonFormulario;
    private EditText editTextNome, editTextIdade, editTextPeso, editTextAltura, editTextEmail;
    private CheckBox checkBoxMasculino, checkBoxFeminino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome = findViewById(R.id.editTextNome);
        editTextIdade = findViewById(R.id.editTextIdade);
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        editTextEmail = findViewById(R.id.editTextEmail);
        checkBoxMasculino = findViewById(R.id.checkBoxMasculino);
        checkBoxFeminino = findViewById(R.id.checkBoxFeminino);
        buttonFormulario = findViewById(R.id.buttonFormulario);

        checkBoxMasculino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxFeminino.isChecked() == true) {
                    checkBoxFeminino.toggle();
                }else{

                }
            }
        });
        checkBoxFeminino.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxMasculino.isChecked() == true) {
                    checkBoxMasculino.toggle();
                }else{

                }
            }
        }));

        buttonFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaPrincipalActivity.class);
                intent.putExtra("Nome", getNome());
                intent.putExtra("Idade", getIdade());
                intent.putExtra("Sexo", getSexo());
                intent.putExtra("Peso", getPeso());
                intent.putExtra("Altura", getAltura());
                intent.putExtra("Email", getEmail());
                startActivity(intent);
            }
        });
    }

    private String getNome(){
        return  editTextNome.getText().toString();
    }

    private Integer getIdade(){
        return Integer.parseInt(editTextIdade.getText().toString());
    }

    private Double getPeso(){
        return Double.parseDouble(editTextPeso.getText().toString());
    }

    private Double getAltura(){
        return Double.parseDouble(editTextAltura.getText().toString());
    }

    private String getEmail(){
        return editTextEmail.getText().toString();
    }

    private String getSexo(){
        if(checkBoxMasculino.isChecked()){
            return "Masculino";
        }else {
            return "Feminino";
        }
    }

}
