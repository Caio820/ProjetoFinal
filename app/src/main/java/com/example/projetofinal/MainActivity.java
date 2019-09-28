package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonFormulario;
    private EditText editTextNome, editTextIdade, editTextPeso, editTextAltura, editTextEmail;
    private CheckBox checkBoxMasculino, checkBoxFeminino;
    private Boolean  masculino = false, feminino = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxMasculino = findViewById(R.id.checkBoxMasculino);
        checkBoxFeminino = findViewById(R.id.checkBoxFeminino);
        buttonFormulario = findViewById(R.id.buttonFormulario);

        checkBoxMasculino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masculino = true;
                if(checkBoxFeminino.isChecked() == true) {
                    checkBoxFeminino.toggle();
                    feminino = false;
                }else if (checkBoxMasculino.isChecked() == false){
                    masculino = false;
                }
            }
        });
        checkBoxFeminino.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feminino = true;
                if(checkBoxMasculino.isChecked() == true) {
                    checkBoxMasculino.toggle();
                    masculino = false;
                }else if(checkBoxFeminino.isChecked() == false){
                    feminino = false;
                }
            }
        }));

        buttonFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getNome().isEmpty() || getIdade() <= 0 || (masculino  == false && feminino == false) || getPeso() <= 0 || getAltura() <= 0 || getEmail().isEmpty()){
                  showMessage("Preencha todos os campos.");
                }
                else {
                    Intent intent = new Intent(MainActivity.this, TelaPrincipalActivity.class);
                    intent.putExtra("Nome", getNome());
                    intent.putExtra("Idade", getIdade());
                    intent.putExtra("Sexo", getSexo());
                    intent.putExtra("Peso", getPeso());
                    intent.putExtra("Altura", getAltura());
                    intent.putExtra("Email", getEmail());
                    startActivity(intent);
                }
            }
        });
    }

    private String getNome(){
        editTextNome = findViewById(R.id.editTextNome);
        return editTextNome.getText().toString();
    }

    private Integer getIdade(){
        try {
            editTextIdade = findViewById(R.id.editTextIdade);
            return Integer.parseInt(editTextIdade.getText().toString());
        } catch (Exception e){
            return 0;
        }
    }

    private Double getPeso(){
        try {
            editTextPeso = findViewById(R.id.editTextPeso);
            return Double.parseDouble(editTextPeso.getText().toString());
        }catch (Exception e){
            return 0.0;
        }
    }

    private Double getAltura(){
        try {
            editTextAltura = findViewById(R.id.editTextAltura);
            return Double.parseDouble(editTextAltura.getText().toString());
        }catch (Exception e){
            return 0.0;
        }
    }

    private String getEmail(){
        editTextEmail = findViewById(R.id.editTextEmail);
        return editTextEmail.getText().toString();
    }

    private String getSexo(){
        if(masculino == true){
            return "Masculino";
        }else {
            return "Feminino";
        }
    }

    private void showMessage(String mensagem){

        Context context = getApplicationContext();
        String text = mensagem;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

}
