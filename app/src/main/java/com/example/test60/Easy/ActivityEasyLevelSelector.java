package com.example.test60.Easy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.test60.Average.ActivityAverageLevelSelector;
import com.example.test60.Menu.ActivitySelectDifficulty;
import com.example.test60.R;
import com.example.test60.Utilities.DifficultiesAndLevels;
import com.example.test60.Utilities.GlobalApplication;
import com.example.test60.Utilities.SoundPlayer;
import com.example.test60.databinding.ActivityEasyLevelSelectorBinding;

public class ActivityEasyLevelSelector extends AppCompatActivity {
    ImageButton imgButton;
    public SoundPlayer sound;
    private DifficultiesAndLevels gameProgress;

    private ActivityEasyLevelSelectorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEasyLevelSelectorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sound = ((GlobalApplication) getApplication()).getSoundPlayer();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("diff", "easy");
        editor.commit();

        imgButton = (ImageButton) findViewById(R.id.imageButton8);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 0);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityEasyLevelSelector.this, EasyLevel1.class);
                startActivity(intentLoadNewActivity);
            }
        });

        ImageButton lvl2btn = findViewById(R.id.imageButton9);
        gameProgress = new DifficultiesAndLevels(this);
        if(!gameProgress.isLevelUnlocked("easy2_unlocked")) {
            lvl2btn.setEnabled(false); // Disable the button if the difficulty is locked

        }else if(gameProgress.isLevelUnlocked("easy2_unlocked")) {
            lvl2btn.setImageResource(R.drawable.btn_lvl_2); // Set the locked image
            binding.linearLayout6.setVisibility(View.VISIBLE);
        }
        lvl2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 1);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityEasyLevelSelector.this, EasyLevel2.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton10);

        if(!gameProgress.isLevelUnlocked("easy3_unlocked")) {
            imgButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            imgButton.setImageResource(R.drawable.btn_lvl_3); // Set the locked image
            binding.linearLayout7.setVisibility(View.VISIBLE);
        }
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 2);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityEasyLevelSelector.this, EasyLevel3.class);
                startActivity(intentLoadNewActivity);
            }
        });

        imgButton = (ImageButton) findViewById(R.id.imageButton11);
        if(!gameProgress.isLevelUnlocked("easy4_unlocked")) {
            imgButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            imgButton.setImageResource(R.drawable.btn_lvl_4); // Set the locked image
            binding.linearLayout8.setVisibility(View.VISIBLE);
        }
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 3);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityEasyLevelSelector.this, EasyLevel4.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton12);
        if(!gameProgress.isLevelUnlocked("easy5_unlocked")) {
            imgButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            imgButton.setImageResource(R.drawable.btn_lvl_5); // Set the locked image
            binding.linearLayout9.setVisibility(View.VISIBLE);
        }

        if(gameProgress.isLevelUnlocked("average1_unlocked")) {
            binding.linearLayout10.setVisibility(View.VISIBLE);
        }

        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 4);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityEasyLevelSelector.this, EasyLevel5.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), ActivitySelectDifficulty.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}