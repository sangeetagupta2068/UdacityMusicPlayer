package com.sangeetagupta1998.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        initialize();
        setClickListener();
    }

    Button song1, song2, song3, song4, menu;

    public void initialize() {

        song1 = findViewById(R.id.song1);
        song2 = findViewById(R.id.song2);
        song3 = findViewById(R.id.song3);
        song4 = findViewById(R.id.song4);
        menu = findViewById(R.id.backToMenu);

    }

    public void setClickListener() {

        song1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Takes to Music Player to play song 1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SongActivity.this, PlayerActivity.class);
                startActivity(intent);
            }
        });

        song2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Takes to Music Player to play song 2", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SongActivity.this, PlayerActivity.class);
                startActivity(intent);
            }
        });

        song3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Takes to Music Player to play song 3", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SongActivity.this, PlayerActivity.class);
                startActivity(intent);
            }
        });

        song4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Takes to Music Player to play song 4", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SongActivity.this, PlayerActivity.class);
                startActivity(intent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Takes to Main Menu", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SongActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
