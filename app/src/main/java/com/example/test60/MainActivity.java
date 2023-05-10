package com.example.test60;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton imgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bgm1);

        // If MediaPlayer object is null, create and start it

        SharedPreferences pref = getApplicationContext().getSharedPreferences("music", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();


            mediaPlayer.setLooping(true);
            mediaPlayer.start();




        imgButton = (ImageButton) findViewById(R.id.imageButton);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intentLoadNewActivity);
            }
        });

        imgButton = (ImageButton) findViewById(R.id.imageButton2);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, MainActivity5.class);
                startActivity(intentLoadNewActivity);
            }
        });

        Button startbutton = (Button) findViewById(R.id.button);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}