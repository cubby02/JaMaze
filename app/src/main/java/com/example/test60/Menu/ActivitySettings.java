package com.example.test60.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;
import android.content.ContentResolver;
import android.view.Window;

import com.example.test60.R;

public class ActivitySettings extends AppCompatActivity {

    ImageButton f1,f2,f3,m1,m2,m3;
    SeekBar volumebtn;
    ImageView chartt,chartt2,chartt3,chartt4,chartt5,chartt6,chartt7,chartt8,chartt9,chartt10,chartt11,chartt12,chartt13,chartt14,chartt15,chartt16,chartt17,chartt18,chartt19,chartt20;


    //Variable to store brightness value
    private int brightness;
    //Content resolver used as a handle to the system's settings
    private ContentResolver cResolver;
    //Window object, that will store a reference to the current window
    private Window window;
    public MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();





        f1 = findViewById(R.id.charfemale1);
        f2 = findViewById(R.id.charfemale2);
        f3 = findViewById(R.id.charfemale3);
        m1 = findViewById(R.id.charmale1);
        m2 = findViewById(R.id.charmale2);
        m3 = findViewById(R.id.charmale3);
        volumebtn = findViewById(R.id.musicBar);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_easy_level_1, null);

        chartt = view.findViewById(R.id.chartt);


        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editor.putString("character", "charfemale1");
                editor.commit();

                Toast.makeText(getApplicationContext(), "settings updated.", Toast.LENGTH_SHORT).show();

            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editor.putString("character", "charfemale2");
                editor.commit();

                Toast.makeText(getApplicationContext(), "settings updated.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("character", "charfemale3");
                editor.commit();

                Toast.makeText(getApplicationContext(), "settings updated.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("character", "charmale1");
                editor.commit();

                Toast.makeText(getApplicationContext(), "settings updated.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("character", "charmale2");
                editor.commit();

                Toast.makeText(getApplicationContext(), "settings updated.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("character", "charmale3");
                editor.commit();

                Toast.makeText(getApplicationContext(), "settings updated.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        volumebtn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Calculate volume value based on progress
                int maxVolume = 100; // Maximum volume value
                int volume = progress * maxVolume / 100; // Calculate volume based on progress

                // Update volume using AudioManager
                AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0); // Update music stream volume to calculated value
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        }
    }