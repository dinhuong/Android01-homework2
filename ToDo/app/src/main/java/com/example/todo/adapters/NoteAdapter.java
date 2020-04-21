package com.example.todo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.model.NoteModel;
import com.example.todo.R;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    List<NoteModel> noteModelList;

    public NoteAdapter(List<NoteModel> noteModelList) {
        this.noteModelList = noteModelList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.item_list_note,parent,false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.setData(noteModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return noteModelList.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView tvTime;
        TextView tvTag;
        TextView tvContent;
        TextView tvTitle;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvTag = itemView.findViewById(R.id.tv_tag);
        }

        public void setData(NoteModel noteModel) {
            tvTitle.setText(noteModel.getTitle());
            tvTag.setText(noteModel.getTag());
            tvTime.setText(noteModel.getTime());
            tvContent.setText(noteModel.getContent());
        }
    }
}
