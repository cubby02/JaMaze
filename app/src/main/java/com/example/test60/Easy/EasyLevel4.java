package com.example.test60.Easy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.test60.Menu.ActivityCongrats;
import com.example.test60.Menu.ActivityGameOver;
import com.example.test60.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class EasyLevel4 extends AppCompatActivity {

    ImageView chartt;
    ImageView mazeMap;

    View avatar;
    Bitmap bitmap;
    float xDown = 0, yDown = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level_4);


        chartt= findViewById(R.id.chartt4);
        mazeMap = findViewById(R.id.mazeMap4);


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



        chartt.setOnTouchListener(new View.OnTouchListener() {
            float xDown, yDown; // Store initial touch coordinates
            boolean isCharttTouched = false; // Keep track of whether chartt is currently being touched

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    // Enable touch on mazeMap only if chartt is not already being touched
                    if (!isCharttTouched) {
                        //enable or call mazeMap here
                        isCharttTouched = true; // Set chartt as being touched
                        mazeMap.setOnTouchListener(new View.OnTouchListener() {
                            public boolean onTouch(View view, MotionEvent event) {
                                mazeMap.setDrawingCacheEnabled(true);
                                mazeMap.buildDrawingCache(true);

                                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                                    bitmap = mazeMap.getDrawingCache();
                                    int pixels = bitmap.getPixel((int) event.getX(), (int) event.getY());

                                    int red = Color.red(pixels);
                                    int green = Color.green(pixels);
                                    int blue = Color.blue(pixels);

                                    int yellowThreshold  = 70;
                                    int blackThreshold = 70;
                                    int whiteThreshold = 200;

                                    if (red >= yellowThreshold && green >= yellowThreshold && blue < yellowThreshold) {
                                        Intent intent = new Intent(getApplicationContext(), ActivityCongrats.class);
                                        startActivity(intent);
                                    } else if (red < blackThreshold && green < blackThreshold && blue < blackThreshold) {
                                        Intent intent = new Intent(getApplicationContext(), ActivityGameOver.class);
                                        startActivity(intent);
                                    } else if (red >= whiteThreshold && green >= whiteThreshold && blue >= whiteThreshold) {
                                        // Detects white color
                                    }
                                    // reserved for white color detection.
                                    // else if (red >= whiteThreshold && green >= whiteThreshold && blue >= whiteThreshold)

                                    float sensitivityX = 1f;
                                    float sensitivityY = 1f;

                                    switch (event.getActionMasked()) {
                                        case MotionEvent.ACTION_DOWN:
                                            xDown = event.getX() - chartt.getX(); // Update xDown with relative x coordinate of chartt
                                            yDown = event.getY() - chartt.getY(); // Update yDown with relative y coordinate of chartt
                                            break;
                                        case MotionEvent.ACTION_MOVE:
                                            float movedX, movedY;
                                            movedX = event.getX();
                                            movedY = event.getY();

                                            float distanceX = movedX - xDown * sensitivityX;;
                                            float distanceY = movedY - yDown * sensitivityX;;

                                            chartt.setX(distanceX);
                                            chartt.setY(distanceY);

                                            break;
                                    }
                                } else {

                                }
                                return true; // Return true to indicate that the touch event has been consumed
                            }
                        });
                    } else {
                        // Remove touch listener from mazeMap
                    }
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP || motionEvent.getAction() == MotionEvent.ACTION_CANCEL) {

                    isCharttTouched = false; // Reset chartt touch state
                }
                return false;
            }
        });
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