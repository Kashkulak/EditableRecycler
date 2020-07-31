package com.example.editablerecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    ArrayList<String> data = new ArrayList<>();
    IElementListener listener;


    public void setElement(String text, int position) {
        data.set(position, text);
        notifyDataSetChanged();
    }

    public void addElement(String text) {
        data.add(text);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_holder_main, parent, false);
        MainViewHolder vh = new MainViewHolder(v);
        vh.listener = listener;
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(data.get(position),position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
