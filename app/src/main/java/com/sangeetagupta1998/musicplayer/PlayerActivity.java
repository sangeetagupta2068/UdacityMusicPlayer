package com.sangeetagupta1998.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PlayerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initialize();
        setClickListener();

    }

    Button play, previous, next, buy, menu;


    public void initialize() {

        play = findViewById(R.id.buttonPlay);
        next = findViewById(R.id.buttonNext);
        previous = findViewById(R.id.buttonPrevious);
        buy = findViewById(R.id.buttonBuy);
        menu = findViewById(R.id.backToMenu);

    }

    public void setClickListener() {

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = "";

                if (play.getText().equals("play")) {
                    play.setText("pause");
                    text = "Plays current song";
                } else {
                    play.setText("play");
                    text = "Pauses current song";
                }
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play.setText("play");
                Toast.makeText(getApplicationContext(), "Takes to previous song", Toast.LENGTH_SHORT).show();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play.setText("play");
                Toast.makeText(getApplicationContext(), "Takes to next song", Toast.LENGTH_SHORT).show();

            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PlayerActivity.this, PaymentActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Takes to Payment Gateway", Toast.LENGTH_SHORT).show();

            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Takes to Main Menu", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PlayerActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }


}
