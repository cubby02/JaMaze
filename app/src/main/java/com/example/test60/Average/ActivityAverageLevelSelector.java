package com.example.test60.Average;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.test60.Menu.ActivitySelectDifficulty;
import com.example.test60.R;
import com.example.test60.Utilities.DifficultiesAndLevels;
import com.example.test60.Utilities.GlobalApplication;
import com.example.test60.Utilities.SoundPlayer;

public class ActivityAverageLevelSelector extends AppCompatActivity {
    public SoundPlayer sound;
    ImageButton imgButton;
    private DifficultiesAndLevels gameProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_level_selector);
        gameProgress = new DifficultiesAndLevels(this);
        sound = ((GlobalApplication) getApplication()).getSoundPlayer();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("diff", "average");
        editor.commit();

        imgButton = (ImageButton) findViewById(R.id.imageButton8);
        if(!gameProgress.isLevelUnlocked("average1_unlocked")) {
            imgButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            imgButton.setImageResource(R.drawable.btn_lvl_1); // Set the locked image
        }
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 5);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityAverageLevelSelector.this, AverageLevel1.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton9);
        if(!gameProgress.isLevelUnlocked("average2_unlocked")) {
            imgButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            imgButton.setImageResource(R.drawable.btn_lvl_2); // Set the locked image
        }
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 6);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityAverageLevelSelector.this, AverageLevel2.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton10);
        if(!gameProgress.isLevelUnlocked("average3_unlocked")) {
            imgButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            imgButton.setImageResource(R.drawable.btn_lvl_3); // Set the locked image
        }
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 7);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityAverageLevelSelector.this, AverageLevel3.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton11);
        if(!gameProgress.isLevelUnlocked("average4_unlocked")) {
            imgButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            imgButton.setImageResource(R.drawable.btn_lvl_4); // Set the locked image
        }
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 8);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityAverageLevelSelector.this, AverageLevel4.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton12);
        if(!gameProgress.isLevelUnlocked("average5_unlocked")) {
            imgButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            imgButton.setImageResource(R.drawable.btn_lvl_5); // Set the locked image
        }
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 9);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityAverageLevelSelector.this, AverageLevel5.class);
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