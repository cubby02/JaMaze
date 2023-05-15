package com.example.test60.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.test60.Easy.ActivityEasyLevelSelector;
import com.example.test60.Average.ActivityAverageLevelSelector;
import com.example.test60.Hard.ActivityHardLevelSelector;
import com.example.test60.Extreme.ActivityExtremeLevelSelector;
import com.example.test60.R;
import com.example.test60.Utilities.DifficultiesAndLevels;
import com.example.test60.Utilities.GlobalApplication;
import com.example.test60.Utilities.SoundPlayer;

public class ActivitySelectDifficulty extends AppCompatActivity {
    ImageButton imgButton;

    public SoundPlayer sound;
    private DifficultiesAndLevels gameProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);

        gameProgress = new DifficultiesAndLevels(this);
        sound = ((GlobalApplication) getApplication()).getSoundPlayer();

        ImageButton easyButton = findViewById(R.id.imageButton3);
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameProgress.isLevelUnlocked("easy1_unlocked")) {
                    // Level is unlocked, start EasyLevelSelector activity
                    Intent intent = new Intent(ActivitySelectDifficulty.this, ActivityEasyLevelSelector.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(ActivitySelectDifficulty.this, "Easy difficulty is locked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ImageButton averageButton = findViewById(R.id.imageButton4);
        if(!gameProgress.isLevelUnlocked("average1_unlocked")) {
            averageButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            averageButton.setImageResource(R.drawable.average_btn); // Set the locked image
        }

        ImageButton hardButton = findViewById(R.id.imageButton5);
        if(!gameProgress.isLevelUnlocked("hard1_unlocked")) {
            hardButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            hardButton.setImageResource(R.drawable.hard_btn); // Set the unlocked image
        }
        ImageButton extremeButton = findViewById(R.id.imageButton6);
        if(!gameProgress.isLevelUnlocked("extreme1_unlocked")) {
            extremeButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            extremeButton.setImageResource(R.drawable.extreme_btn); // Set the unlocked image
        }
        averageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameProgress.isLevelUnlocked("average1_unlocked")) {
                    // Level is unlocked, start EasyLevelSelector activity
                    Intent intent = new Intent(ActivitySelectDifficulty.this, ActivityAverageLevelSelector.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(ActivitySelectDifficulty.this, "Average difficulty is locked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameProgress.isLevelUnlocked("hard1_unlocked")) {
                    // Level is unlocked, start EasyLevelSelector activity
                    Intent intent = new Intent(ActivitySelectDifficulty.this, ActivityHardLevelSelector.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(ActivitySelectDifficulty.this, "Hard difficulty is locked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        extremeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameProgress.isLevelUnlocked("extreme1_unlocked")) {
                    // Level is unlocked, start EasyLevelSelector activity
                    Intent intent = new Intent(ActivitySelectDifficulty.this, ActivityExtremeLevelSelector.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(ActivitySelectDifficulty.this, "Hard difficulty is locked!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}