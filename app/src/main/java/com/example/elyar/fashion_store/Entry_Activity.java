package com.example.elyar.fashion_store;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Entry_Activity extends AppCompatActivity {

    View shirts;
    View trousers;
    View shoes;
    SharedPreferences shared_data;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        initialize();
        clicks();
    }

    private void initialize() {
        shirts = findViewById(R.id.entry_shirts);
        trousers = findViewById(R.id.entry_trousers);
        shoes = findViewById(R.id.entry_shoes);
        shared_data = Entry_Activity.this.getSharedPreferences("shared_data", MODE_PRIVATE);
        editor = shared_data.edit();
    }

    private void clicks() {
        shirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("list_determiner","shirts").apply();
                startActivity(new Intent(Entry_Activity.this,Recycle_Activity.class));
            }
        });
        trousers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("list_determiner","trousers").apply();
                startActivity(new Intent(Entry_Activity.this,Recycle_Activity.class));
            }
        });
        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("list_determiner","shoes").apply();
                startActivity(new Intent(Entry_Activity.this,Recycle_Activity.class));
            }
        });
    }
}
