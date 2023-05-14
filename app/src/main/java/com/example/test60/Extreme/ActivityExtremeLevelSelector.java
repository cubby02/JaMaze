package com.example.test60.Extreme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test60.Menu.ActivitySelectDifficulty;
import com.example.test60.Menu.MainActivity;
import com.example.test60.R;
import com.example.test60.Utilities.DifficultiesAndLevels;
import com.example.test60.Utilities.GlobalApplication;
import com.example.test60.Utilities.SoundPlayer;

public class ActivityExtremeLevelSelector extends AppCompatActivity {
    ImageButton imgButton;
    public SoundPlayer sound;
    private DifficultiesAndLevels gameProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extreme_selector);
        gameProgress = new DifficultiesAndLevels(this);
        sound = ((GlobalApplication) getApplication()).getSoundPlayer();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("diff", "extreme");
        editor.commit();

        imgButton = (ImageButton) findViewById(R.id.imageButton8);
        if(!gameProgress.isLevelUnlocked("extreme1_unlocked")) {
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
                editor.putInt("counter", 15);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityExtremeLevelSelector.this, ExtremeLevel1.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton9);
        if(!gameProgress.isLevelUnlocked("extreme2_unlocked")) {
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
                editor.putInt("counter", 16);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityExtremeLevelSelector.this, ExtremeLevel2.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton10);
        if(!gameProgress.isLevelUnlocked("extreme3_unlocked")) {
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
                editor.putInt("counter", 17);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityExtremeLevelSelector.this, ExtremeLevel3.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton11);
        if(!gameProgress.isLevelUnlocked("extreme4_unlocked")) {
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
                editor.putInt("counter", 19);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityExtremeLevelSelector.this, ExtremeLevel4.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton12);
        if(!gameProgress.isLevelUnlocked("extreme5_unlocked")) {
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
                editor.putInt("counter", 19);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityExtremeLevelSelector.this, ExtremeLevel5.class);
                startActivity(intentLoadNewActivity);
            }

            public void onBackPressed() {
                Intent intentLoadNewActivity = new Intent(ActivityExtremeLevelSelector.this, MainActivity.class);
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
