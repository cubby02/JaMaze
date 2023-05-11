package com.example.test60.Average;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.test60.Menu.ActivitySelectDifficulty;
import com.example.test60.R;

public class ActivityAverageLevelSelector extends AppCompatActivity {
    ImageButton imgButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_level_selector);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("diff", "average");
        editor.commit();

        imgButton = (ImageButton) findViewById(R.id.imageButton8);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 5);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityAverageLevelSelector.this, AverageLevel1.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton9);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 6);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityAverageLevelSelector.this, AverageLevel2.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton10);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 7);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityAverageLevelSelector.this, AverageLevel3.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton11);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 8);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityAverageLevelSelector.this, AverageLevel4.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton12);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 9);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityAverageLevelSelector.this, AverageLevel5.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }

    public void onBackPressed() {
        Intent intentLoadNewActivity = new Intent(ActivityAverageLevelSelector.this, ActivitySelectDifficulty.class);
        startActivity(intentLoadNewActivity);
    }
}