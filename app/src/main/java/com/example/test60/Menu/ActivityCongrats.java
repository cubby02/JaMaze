package com.example.test60.Menu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test60.Easy.ActivityEasyLevelSelector;
import com.example.test60.Hard.ActivityHardLevelSelector;
import com.example.test60.Extreme.ActivityExtremeLevelSelector;
import com.example.test60.R;
import com.example.test60.Utilities.GlobalApplication;
import com.example.test60.Utilities.MusicService;
import com.example.test60.Utilities.SoundPlayer;

public class ActivityCongrats extends AppCompatActivity {

    ImageButton setting, home, diff, tryAgain, con;
    public SoundPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);
        sound = ((GlobalApplication) getApplication()).getSoundPlayer();

        con =  findViewById(R.id.con);
        setting = findViewById(R.id.settingsBtn);
        home = findViewById(R.id.homeBtn);
        diff = findViewById(R.id.backBtn3);

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                Intent intent = new Intent(getApplicationContext(), ActivityQuestions.class);
                startActivity(intent);
                finish();
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                Intent intentLoadNewActivity = new Intent(ActivityCongrats.this, ActivitySettings.class);
                startActivity(intentLoadNewActivity);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                stopService(new Intent(ActivityCongrats.this, MusicService.class));
                Intent intent = new Intent(ActivityCongrats.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {

    }
}
