package com.example.test60.Average;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.test60.Menu.ActivityCongrats;
import com.example.test60.Menu.ActivityGameOver;
import com.example.test60.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AverageLevel1 extends AppCompatActivity {

    ImageView chartt;
    ImageView mazeMap;

    View avatar;
    Bitmap bitmap;
    float xDown = 0, yDown = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_level_1);


        chartt= findViewById(R.id.chartt);
        mazeMap = findViewById(R.id.mazeMap);


//setting character config
        SharedPreferences pref = getApplicationContext().getSharedPreferences("settings", MODE_PRIVATE);

        String characterSetting = pref.getString("character", "null");
        if(characterSetting.equals("null")){
            chartt.setImageResource(R.drawable.charmale1);

        }else{
            String charPref = pref.getString("character", "null");

            if(charPref.equals("charfemale1")){
                chartt.setImageResource(R.drawable.charfemale1);
            }else if(charPref.equals("charfemale2")){
                chartt.setImageResource(R.drawable.charfemale2);
            }else if(charPref.equals("charfemale3")){
                chartt.setImageResource(R.drawable.charfemale3);
            }else if(charPref.equals("charmale1")){
                chartt.setImageResource(R.drawable.charmale1);
            }else if(charPref.equals("charmale2")){
                chartt.setImageResource(R.drawable.charmale2);
            }else if(charPref.equals("charmale3")){
                chartt.setImageResource(R.drawable.charmale3);
            }
        }

    }

    @Override
    public void onBackPressed() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Caution: Reset Game Progress on Exit")
                .setMessage("Are you sure you want to exit? Your progress will be reset to start.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle Yes button click
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle No button click
                        return;
                    }
                })
                .show();
    }
}