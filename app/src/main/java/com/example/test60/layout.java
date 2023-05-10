package com.example.test60;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class layout extends AppCompatActivity {

    ImageButton setting, home, diff, tryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        setting = findViewById(R.id.settingsBtn);
        home = findViewById(R.id.homeBtn);
        diff = findViewById(R.id.backBtn3);
        tryAgain = findViewById(R.id.tryAgain);


        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentLoadNewActivity = new Intent(layout.this, MainActivity5.class);
                startActivity(intentLoadNewActivity);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(layout.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);

                String currentDiff = pref.getString("diff", null);
                if(currentDiff == "easy") {
                    Intent intentLoadNewActivity = new Intent(layout.this, MainActivity3.class);
                    startActivity(intentLoadNewActivity);
                }else if(currentDiff == "average") {
                    Intent intentLoadNewActivity = new Intent(layout.this, MainActivity13.class);
                    startActivity(intentLoadNewActivity);
                }else if(currentDiff == "hard") {
                    Intent intentLoadNewActivity = new Intent(layout.this, MainActivity19.class);
                    startActivity(intentLoadNewActivity);
                }else if(currentDiff == "extreme") {
                    Intent intentLoadNewActivity = new Intent(layout.this, MainActivity26.class);
                    startActivity(intentLoadNewActivity);
                }else{
                    Intent intentLoadNewActivity = new Intent(layout.this, MainActivity.class);
                    startActivity(intentLoadNewActivity);
                }
            }
        });

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(layout.this, MainActivity.class);
                startActivity(intent);
                finish();

                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                int counter = pref.getInt("counter", 0);
                String diff = pref.getString("diff", null);

                if(diff.trim().equals("easy")){
                    if(counter == 0){
                        Intent retry = new Intent(layout.this, MainActivity6.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==1){
                        Intent retry = new Intent(layout.this, MainActivity9.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==2){
                        Intent retry = new Intent(layout.this, MainActivity10.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==3){
                        Intent retry = new Intent(layout.this, MainActivity11.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==4){
                        Intent retry = new Intent(layout.this, MainActivity12.class);
                        startActivity(retry);
                        finish();
                    }
                }else if(diff.trim().equals("average")){
                    if(counter == 5){
                        Intent retry = new Intent(layout.this, MainActivity14.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==6){
                        Intent retry = new Intent(layout.this, MainActivity15.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==7){
                        Intent retry = new Intent(layout.this, MainActivity16.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==8){
                        Intent retry = new Intent(layout.this, MainActivity17.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==9){
                        Intent retry = new Intent(layout.this, MainActivity18.class);
                        startActivity(retry);
                        finish();
                    }
                }else if(diff.trim().equals("hard")){
                    if(counter == 10){
                        Intent retry = new Intent(layout.this, MainActivity20.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==11){
                        Intent retry = new Intent(layout.this, MainActivity21.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==12){
                        Intent retry = new Intent(layout.this, MainActivity22.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==13){
                        Intent retry = new Intent(layout.this, MainActivity23.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==14){
                        Intent retry = new Intent(layout.this, MainActivity24.class);
                        startActivity(retry);
                        finish();
                    }
                }else if(diff.trim().equals("extreme")){
                    if(counter == 15){
                        Intent retry = new Intent(layout.this, MainActivity25.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==16){
                        Intent retry = new Intent(layout.this, MainActivity27.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==17){
                        Intent retry = new Intent(layout.this, MainActivity28.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==18){
                        Intent retry = new Intent(layout.this, MainActivity29.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==19){
                        Intent retry = new Intent(layout.this, MainActivity30.class);
                        startActivity(retry);
                        finish();
                    }
                }
            }
        });


    }



    @Override
    public void onBackPressed() {
    }
}
