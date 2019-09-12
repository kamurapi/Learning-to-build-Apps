package com.kamurapi.notepadapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.kamurapi.notepadapp.db.NotesDB;
import com.kamurapi.notepadapp.db.NotesDao;
import com.kamurapi.notepadapp.model.Note;

import java.util.Date;

public class EditNoteActivity extends AppCompatActivity {
    private EditText inputNote;
    private NotesDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        inputNote = findViewById(R.id.input_note);
        dao = NotesDB.getInstance(this).notesDao();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_note_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.save_note)
            onSaveNote();
        return super.onOptionsItemSelected(item);
    }

    private void onSaveNote() {
        String text = inputNote.getText().toString();
        if(!text.isEmpty()){
            long date=new Date().getTime();
            Note note = new Note(text,date);
            dao.insertNote(note); //insert and save note

            finish();
        }
    }

}
