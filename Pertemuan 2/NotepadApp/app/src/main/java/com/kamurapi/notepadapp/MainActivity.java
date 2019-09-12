package com.kamurapi.notepadapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v7.widget.Toolbar;


import com.kamurapi.notepadapp.adapters.NoteAdapter;
import com.kamurapi.notepadapp.db.NotesDB;
import com.kamurapi.notepadapp.db.NotesDao;
import com.kamurapi.notepadapp.model.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Note> notes;
    private FloatingActionButton fab;
    private NoteAdapter adapter;
    private NotesDao dao;


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

        dao = NotesDB.getInstance(this).notesDao();
    }

    private void loadNotes() {
        this.notes = new ArrayList<>();
        List<Note> list = dao.getNotes(); //get all notes from database
        this.notes.addAll(list);
        this.adapter = new NoteAdapter(this,notes);
        this.recyclerView.setAdapter(adapter);
    }

    private void onAddNewNote() {
        startActivity(new Intent(this,EditNoteActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadNotes();
    }

}
