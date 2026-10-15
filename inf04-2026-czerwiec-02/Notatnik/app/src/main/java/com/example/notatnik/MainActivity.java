package com.example.notatnik;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Notatka> notes = new ArrayList<>();
    private ArrayAdapter<Notatka> adapter;
    private EditText titleInput;
    private EditText contentInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        notes.add(new Notatka("tenis", "Gra z Ewą w poniedziałek", true));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        ListView notesList = findViewById(R.id.notesList);
        notesList.setAdapter(adapter);
        titleInput = findViewById(R.id.titleInput);
        contentInput = findViewById(R.id.contentInput);
    }

    public void addNote(View view) {
        String title = titleInput.getText().toString().trim();
        if (title.isEmpty()) {
            titleInput.setError("Podaj tytuł notatki");
            return;
        }
        notes.add(new Notatka(title, contentInput.getText().toString().trim(), false));
        adapter.notifyDataSetChanged();
        titleInput.setText("");
        contentInput.setText("");
    }
}
