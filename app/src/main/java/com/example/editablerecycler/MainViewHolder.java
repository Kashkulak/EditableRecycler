package com.example.editablerecycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    IElementListener listener;

    private int position;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.vh_text_view);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onElement(textView.getText().toString(), position);
            }
        });
    }

    public void onBind(String text, int position) {
        textView.setText(text);
        this.position = position;
    }
}
