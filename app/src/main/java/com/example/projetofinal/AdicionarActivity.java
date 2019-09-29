package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projetofinal.model.AppDatabase;
import com.example.projetofinal.model.ListItem;

public class AdicionarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);

        Button button = findViewById(R.id.buttonCadastro);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "database-name1").allowMainThreadQueries().build();

                ListItem item = new ListItem();
                EditText textPressao = findViewById(R.id.editTextPressao);
                EditText textBatimento = findViewById(R.id.editTextBatimento);

                item.pressao = textPressao.getText().toString();
                item.batimento = textBatimento.getText().toString();

                db.itemDao().insertAll(item);

                finish();
            }
        });

    }
}
