package com.kamurapi.notepadapp.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.kamurapi.notepadapp.model.Note;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Note note);
    @Delete
    void deleteNote(Note note);
    @Update
    void updateNote(Note note);

    @Query("Select * from notes") // list all notes
    List<Note> getNotes();


    @Query("Select * from notes where id like :noteId") // get Note by id
    Note getNoteById(int noteId);

    @Query("Delete from notes where id like :noteId") //delete note by id
    void deleteNoteById(int noteId);

}
