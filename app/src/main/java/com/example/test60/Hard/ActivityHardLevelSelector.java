package com.example.test60.Hard;

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
import com.example.test60.databinding.ActivityEasyLevelSelectorBinding;
import com.example.test60.databinding.ActivityHardLevelSelectorBinding;

public class ActivityHardLevelSelector extends AppCompatActivity {
    ImageButton imgButton;
    public SoundPlayer sound;
    private DifficultiesAndLevels gameProgress;

    private ActivityHardLevelSelectorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHardLevelSelectorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        gameProgress = new DifficultiesAndLevels(this);
        sound = ((GlobalApplication) getApplication()).getSoundPlayer();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("diff", "hard");
        editor.commit();

        imgButton = (ImageButton) findViewById(R.id.imageButton8);
        if(!gameProgress.isLevelUnlocked("hard1_unlocked")) {
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
                editor.putInt("counter", 10);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityHardLevelSelector.this, HardLevel1.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton9);
        if(!gameProgress.isLevelUnlocked("hard2_unlocked")) {
            imgButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            imgButton.setImageResource(R.drawable.btn_lvl_2); // Set the locked image
            binding.linearLayout6.setVisibility(View.VISIBLE);
        }
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 11);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityHardLevelSelector.this, HardLevel2.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton10);
        if(!gameProgress.isLevelUnlocked("hard3_unlocked")) {
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
                editor.putInt("counter", 12);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityHardLevelSelector.this, HardLevel3.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton11);
        if(!gameProgress.isLevelUnlocked("hard4_unlocked")) {
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
                editor.putInt("counter", 13);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityHardLevelSelector.this, HardLevel4.class);
                startActivity(intentLoadNewActivity);
            }
        });
        imgButton = (ImageButton) findViewById(R.id.imageButton12);
        if(!gameProgress.isLevelUnlocked("hard5_unlocked")) {
            imgButton.setEnabled(false); // Disable the button if the difficulty is locked

        }else {
            imgButton.setImageResource(R.drawable.btn_lvl_5); // Set the locked image
            binding.linearLayout9.setVisibility(View.VISIBLE);
        }

        if(gameProgress.isLevelUnlocked("extreme1_unlocked")) {
            binding.linearLayout10.setVisibility(View.VISIBLE);

        }
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("counter", 14);
                editor.commit();

                Intent intentLoadNewActivity = new Intent(ActivityHardLevelSelector.this, HardLevel5.class);
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