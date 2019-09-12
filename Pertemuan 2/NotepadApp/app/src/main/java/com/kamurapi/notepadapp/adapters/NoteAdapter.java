package com.kamurapi.notepadapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kamurapi.notepadapp.R;
import com.kamurapi.notepadapp.model.Note;
import com.kamurapi.notepadapp.utils.NoteUtils;


import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder>{

    private Context context;
    private ArrayList<Note> notes;

    public NoteAdapter(Context context, ArrayList<Note> notes) {
        this.context = context;
        this.notes = notes;

    }


    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_layout, parent, false);
        return new NoteHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note note = getNote(position);
        if (note!=null){
            holder.noteText.setText(note.getNoteText());
            holder.noteDate.setText(NoteUtils.dateFromLong(note.getNoteDate()));
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    private Note getNote(int position) {
        return notes.get(position);
    }
    class NoteHolder extends RecyclerView.ViewHolder{
        TextView noteText, noteDate;
        public NoteHolder(View itemView){
            super(itemView);
        }
    }
}

