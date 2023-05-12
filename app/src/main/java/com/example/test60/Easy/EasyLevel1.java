package com.example.test60.Easy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageView;

import com.example.test60.Menu.ActivityCongrats;
import com.example.test60.Menu.ActivityGameOver;
import com.example.test60.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class EasyLevel1 extends AppCompatActivity {
    ImageView chartt;
    ImageView mazeMap;

    View avatar;
    Bitmap bitmap;
    float xDown = 0, yDown = 0;
    Button buttonUp, buttonDown, buttonLeft, buttonRight; //eto yung i-ccopy per level sa mga activity

    @SuppressLint("ClickableViewAccessibility") //eto yung i-ccopy per level sa mga activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level_1);

        buttonUp = findViewById(R.id.btn_up);
        buttonDown = findViewById(R.id.btn_down);
        buttonLeft = findViewById(R.id.btn_left);
        buttonRight = findViewById(R.id.btn_right);

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

        //eto yung i-ccopy per level sa mga activity. from buttonUp to buttonDown
        buttonUp.setOnTouchListener(new View.OnTouchListener() {
            private Handler handler;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                chartt.setY(chartt.getY() - 10f);
                                checkCollision();
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
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                chartt.setY(chartt.getY() + 10f);
                                checkCollision();
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
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                chartt.setX(chartt.getX() - 10f);
                                checkCollision();
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
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                chartt.setX(chartt.getX() + 10f);
                                checkCollision();
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

    //eto yung i-ccopy per level sa mga activity
    private void checkCollision() {
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
            int whiteThreshold = 200;

            if (red >= yellowThreshold && green >= yellowThreshold && blue < yellowThreshold) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.putInt("lives", 3);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(), ActivityCongrats.class);
                startActivity(intent);
                finish();
            } else if (red < whiteThreshold && green < whiteThreshold && blue < whiteThreshold) {
                Intent intent = new Intent(getApplicationContext(), ActivityGameOver.class);
                startActivity(intent);
                finish();
            } else if (red >= blackThreshold && green >= blackThreshold && blue >= blackThreshold) {
                // Detects white color
            }
            // reserved for white color detection.
            // else if (red >= whiteThreshold && green >= whiteThreshold && blue >= whiteThreshold)
        } else {
            // Launch game over activity and finish current activity
            Intent intent = new Intent(getApplicationContext(), ActivityGameOver.class);
            startActivity(intent);
            finish();
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