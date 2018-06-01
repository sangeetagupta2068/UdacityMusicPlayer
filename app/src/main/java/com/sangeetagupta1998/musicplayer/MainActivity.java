package com.sangeetagupta1998.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button artist, song, player, album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        setClickListener();
    }

    public void initialize() {

        artist = findViewById(R.id.artist);
        song = findViewById(R.id.song);
        album = findViewById(R.id.album);
        player = findViewById(R.id.player);

    }

    public void setClickListener() {

        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Takes to Music Player", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                startActivity(intent);

            }
        });

        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Takes to Artist List", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(intent);
            }
        });

        song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Takes to Song List", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SongActivity.class);
                startActivity(intent);
            }
        });

        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Takes to Album List", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(intent);
            }
        });


    }
}
