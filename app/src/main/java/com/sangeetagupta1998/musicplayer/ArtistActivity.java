package com.sangeetagupta1998.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        initialize();
        setClickListener();
    }

    Button artist1, artist2,menu;

    public void initialize() {

        artist1 = findViewById(R.id.artist1);
        artist2 = findViewById(R.id.artist2);
        menu = findViewById(R.id.backToMenu);
    }

    public void setClickListener() {

        artist1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Takes to songs by Artist1", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ArtistActivity.this, SongActivity.class);
                startActivity(intent);
            }
        });

        artist2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Takes to songs by Artist2", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ArtistActivity.this, SongActivity.class);
                startActivity(intent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Takes to Main Menu", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ArtistActivity.this,MainActivity.class);
                startActivity(intent);


            }
        });
    }
}
