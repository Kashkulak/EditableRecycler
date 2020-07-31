package com.example.editablerecycler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements IElementListener {

    final static int MAIN_ACTIVITY= 95;
    MainAdapter adapter;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapter = new MainAdapter();
        adapter.listener = this;
        recyclerView.setAdapter(adapter);
    }

    public void onAddNewElement(View view) {
        Intent intent = new Intent(this, EditActivity.class);
        startActivityForResult(intent,MAIN_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode==MAIN_ACTIVITY) {
                String text = data.getStringExtra("result");
                Log.d("ololo", "message: " + text);
                adapter.addElement(text);
            } else if (requestCode == 43) {
                String text2 = data.getStringExtra("result");
                adapter.setElement(text2, position);
            }
        }
    }

    @Override
    public void onElement(String text, int position) {
        this.position = position;
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("input", text);
        startActivityForResult(intent, 43);
    }
}