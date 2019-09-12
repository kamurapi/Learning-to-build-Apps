package com.kamurapi.notepadapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder>{
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        TextView noteText, noteDate;
    }
}

