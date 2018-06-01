package com.sangeetagupta1998.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        initialize();
        setClickListener();
    }

    Button album1, album2,menu;

    public void initialize() {

        album1 = findViewById(R.id.album1);
        album2 = findViewById(R.id.album2);
        menu = findViewById(R.id.backToMenu);
    }

    public void setClickListener() {

        album1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Takes to songs from Album1", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AlbumActivity.this, SongActivity.class);
                startActivity(intent);
            }
        });

        album2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Takes to songs from Album2", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AlbumActivity.this, SongActivity.class);
                startActivity(intent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Takes to Main Menu", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AlbumActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
