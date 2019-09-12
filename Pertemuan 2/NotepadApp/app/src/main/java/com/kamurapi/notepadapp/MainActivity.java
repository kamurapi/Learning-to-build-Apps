package com.kamurapi.notepadapp;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;

import com.kamurapi.notepadapp.adapters.NoteAdapter;
import com.kamurapi.notepadapp.model.Note;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Note> notes;
    private FloatingActionButton fab;
    private NoteAdapter adapter;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //init recycler
        recyclerView = findViewById(R.id.note_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //init flying button
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddNewNote();
            }
        });
    }

    private void loadNotes() {
        this.notes = new ArrayList<>();
        for (int i = 1; i<12; i++){
            notes.add(new Note("ye let's write your note",new Date().getTime()));

            adapter = new NoteAdapter(this,notes);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }
    }

    private void onAddNewNote() {
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadNotes();
    }
}
