package com.example.test60.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.test60.Easy.ActivityEasyLevelSelector;
import com.example.test60.Average.ActivityAverageLevelSelector;
import com.example.test60.Hard.ActivityHardLevelSelector;
import com.example.test60.Extreme.ActivityExtremeLevelSelector;
import com.example.test60.R;
import com.example.test60.Utilities.GlobalApplication;
import com.example.test60.Utilities.SoundPlayer;

public class ActivitySelectDifficulty extends AppCompatActivity {
    ImageButton imgButton;

    public SoundPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);

        sound = ((GlobalApplication) getApplication()).getSoundPlayer();

        imgButton = (ImageButton) findViewById(R.id.imageButton3);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                Intent intentLoadNewActivity = new Intent(ActivitySelectDifficulty.this, ActivityEasyLevelSelector.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton4);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                Intent intentLoadNewActivity = new Intent(ActivitySelectDifficulty.this, ActivityAverageLevelSelector.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton5);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                Intent intentLoadNewActivity = new Intent(ActivitySelectDifficulty.this, ActivityHardLevelSelector.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton6);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                Intent intentLoadNewActivity = new Intent(ActivitySelectDifficulty.this, ActivityExtremeLevelSelector.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}