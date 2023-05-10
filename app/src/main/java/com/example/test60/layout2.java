package com.example.test60;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class layout2 extends AppCompatActivity {

    ImageButton setting, home, diff, tryAgain, con;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);


        con =  findViewById(R.id.con);
        setting = findViewById(R.id.settingsBtn);
        home = findViewById(R.id.homeBtn);
        diff = findViewById(R.id.backBtn3);

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity8.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(layout2.this, MainActivity5.class);
                startActivity(intentLoadNewActivity);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(layout2.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);

                String currentDiff = pref.getString("diff", null);
                if(currentDiff == "easy") {
                    Intent intentLoadNewActivity = new Intent(layout2.this, MainActivity3.class);
                    startActivity(intentLoadNewActivity);
                }else if(currentDiff == "average") {
                    Intent intentLoadNewActivity = new Intent(layout2.this, MainActivity3.class);
                    startActivity(intentLoadNewActivity);
                }else if(currentDiff == "hard") {
                    Intent intentLoadNewActivity = new Intent(layout2.this, MainActivity19.class);
                    startActivity(intentLoadNewActivity);
                }else if(currentDiff == "extreme") {
                    Intent intentLoadNewActivity = new Intent(layout2.this, MainActivity26.class);
                    startActivity(intentLoadNewActivity);
                }
            }
        });


    }

    @Override
    public void onBackPressed() {

    }
}
