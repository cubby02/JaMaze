package com.example.test60.Hard;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test60.Menu.ActivityCongrats;
import com.example.test60.Menu.ActivityGameOver;
import com.example.test60.Menu.MainActivity;
import com.example.test60.R;
import com.example.test60.Utilities.DifficultiesAndLevels;
import com.example.test60.Utilities.GlobalApplication;
import com.example.test60.Utilities.SoundPlayer;
import com.example.test60.databinding.ActivityHardLevel1Binding;
import com.example.test60.databinding.ActivityHardLevel4Binding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class HardLevel4 extends AppCompatActivity {
    ImageView chartt;
    ImageView mazeMap;

    View avatar;
    Bitmap bitmap;
    float xDown = 0, yDown = 0;
    private SoundPlayer sound;
    Button buttonUp, buttonDown, buttonLeft, buttonRight,reset;
    private boolean gameEnded = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHardLevel4Binding binding = ActivityHardLevel4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DifficultiesAndLevels gameProgress = new DifficultiesAndLevels(this);
        if(gameProgress.isLevelUnlocked("hard5_unlocked")) {
            binding.imageView9.setColorFilter(getResources().getColor(R.color.light_yellow));
            binding.imageView10.setColorFilter(getResources().getColor(R.color.light_yellow));
            binding.imageView11.setColorFilter(getResources().getColor(R.color.light_yellow));
        }
        buttonUp = findViewById(R.id.btn_up);
        buttonDown = findViewById(R.id.btn_down);
        buttonLeft = findViewById(R.id.btn_left);
        buttonRight = findViewById(R.id.btn_right);
        sound = ((GlobalApplication) getApplication()).getSoundPlayer();
        chartt= findViewById(R.id.chartt);
        mazeMap = findViewById(R.id.mazeMap);
        Button home = findViewById(R.id.button2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                Intent intent = new Intent(HardLevel4.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        reset = findViewById(R.id.button3);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.playReset();
                finish();
                startActivity(new Intent(HardLevel4.this, HardLevel4.class));
                overridePendingTransition(0,0);
            }
        });


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



        buttonUp.setOnTouchListener(new View.OnTouchListener() {
            private Handler handler;
            private float previousX;
            private float previousY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler = new Handler();
                        previousX = chartt.getX();
                        previousY = chartt.getY();

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                chartt.setY(chartt.getY() - 10f);
                                checkCollision(previousX, previousY);
                                handler.postDelayed(this, 50); // move every 50 milliseconds
                            }
                        }, 500); // wait 500 milliseconds before starting to move
                        return true;
                    case MotionEvent.ACTION_UP:
                        if (handler != null) {
                            handler.removeCallbacksAndMessages(null);
                            handler = null;
                        }
                        return true;
                }
                return false;
            }
        });


        buttonDown.setOnTouchListener(new View.OnTouchListener() {
            private Handler handler;
            private float previousY;
            private float previousX;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler = new Handler();
                        previousY = chartt.getY();
                        previousX = chartt.getX();

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                chartt.setY(chartt.getY() + 10f);
                                checkCollision(previousX, previousY);
                                handler.postDelayed(this, 50); // move every 50 milliseconds
                            }
                        }, 500); // wait 500 milliseconds before starting to move
                        return true;
                    case MotionEvent.ACTION_UP:
                        if (handler != null) {
                            handler.removeCallbacksAndMessages(null);
                            handler = null;
                        }
                        return true;
                }
                return false;
            }
        });

        buttonLeft.setOnTouchListener(new View.OnTouchListener() {
            private Handler handler;
            private float previousX;
            private float previousY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler = new Handler();
                        previousX = chartt.getX();
                        previousY = chartt.getY();

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                chartt.setX(chartt.getX() - 10f);
                                checkCollision(previousX, previousY);
                                handler.postDelayed(this, 50); // move every 50 milliseconds
                            }
                        }, 500); // wait 500 milliseconds before starting to move
                        return true;
                    case MotionEvent.ACTION_UP:
                        if (handler != null) {
                            handler.removeCallbacksAndMessages(null);
                            handler = null;
                        }
                        return true;
                }
                return false;
            }
        });

        buttonRight.setOnTouchListener(new View.OnTouchListener() {
            private Handler handler;
            private float previousX;
            private float previousY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler = new Handler();
                        previousX = chartt.getX();
                        previousY = chartt.getY();

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                chartt.setX(chartt.getX() + 10f);
                                checkCollision(previousX, previousY);
                                handler.postDelayed(this, 50); // move every 50 milliseconds
                            }
                        }, 500); // wait 500 milliseconds before starting to move
                        return true;
                    case MotionEvent.ACTION_UP:
                        if (handler != null) {
                            handler.removeCallbacksAndMessages(null);
                            handler = null;
                        }
                        return true;
                }
                return false;
            }
        });
    }
    private boolean gameOver = false;
    private int lives = 3;

    @SuppressLint("ClickableViewAccessibility")
    private void checkCollision(float previousX, float previousY) {
        if (gameOver) {
            return;
        }

        mazeMap.setDrawingCacheEnabled(true);
        mazeMap.buildDrawingCache(true);

        int x = (int) chartt.getX() + chartt.getWidth() / 2;
        int y = (int) chartt.getY() + chartt.getHeight() / 2;

        // Check if the chartt is within the bounds of the maze map
        if (x >= 0 && x < mazeMap.getWidth() && y >= 0 && y < mazeMap.getHeight()) {
            Bitmap bitmap = mazeMap.getDrawingCache();
            int pixel = bitmap.getPixel(x, y);

            int red = Color.red(pixel);
            int green = Color.green(pixel);
            int blue = Color.blue(pixel);

            int yellowThreshold = 70;
            int blackThreshold = 70;
            int whiteThreshold = 10;

            if (red >= yellowThreshold && green >= yellowThreshold && blue < yellowThreshold) {
                if (!gameEnded) {
                    sound.stopHitWall();
                    sound.playAfterMaze();
                    gameEnded = true;
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();

                    editor.putInt("lives", 3);
                    editor.commit();

                    buttonUp.setOnTouchListener(null);
                    buttonRight.setOnTouchListener(null);
                    buttonLeft.setOnTouchListener(null);
                    buttonDown.setOnTouchListener(null);
                    finish();
                    Intent intent = new Intent(getApplicationContext(), ActivityCongrats.class);
                    startActivity(intent);
                }

            } else if (red >= whiteThreshold && green >= whiteThreshold && blue >= whiteThreshold) {
                lives--;
                sound.playHitWall();
                if (lives == 0) {
                    if (!gameEnded) {

                        sound.playGameOver();
                        gameOver = true;
                        Intent intent = new Intent(getApplicationContext(), ActivityGameOver.class);
                        startActivity(intent);
                        finish();
                        sound.stopHitWall();
                    }
                } else {

                    // Move the chartt back to the previous position
                    chartt.setX(previousX);
                    chartt.setY(previousY);
                }


            }
            // reserved for white color detection.
            // else if (red >= whiteThreshold && green >= whiteThreshold && blue >= whiteThreshold)
        } else {
            // Launch game over activity and finish current activity
            if (x < 0) {
                chartt.setX(0);
            } else if (x > mazeMap.getWidth() - chartt.getWidth()) {
                chartt.setX(mazeMap.getWidth() - chartt.getWidth());
            }

            if (y < 0) {
                chartt.setY(0);
            } else if (y > mazeMap.getHeight() - chartt.getHeight()) {
                chartt.setY(mazeMap.getHeight() - chartt.getHeight());
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
