package com.example.test60.Menu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test60.Easy.ActivityEasyLevelSelector;
import com.example.test60.Easy.EasyLevel3;
import com.example.test60.Easy.EasyLevel4;
import com.example.test60.Easy.EasyLevel5;
import com.example.test60.Average.ActivityAverageLevelSelector;
import com.example.test60.Average.AverageLevel1;
import com.example.test60.Average.AverageLevel2;
import com.example.test60.Average.AverageLevel3;
import com.example.test60.Average.AverageLevel4;
import com.example.test60.Average.AverageLevel5;
import com.example.test60.Hard.ActivityHardLevelSelector;
import com.example.test60.Hard.HardLevel1;
import com.example.test60.Hard.HardLevel2;
import com.example.test60.Hard.HardLevel3;
import com.example.test60.Hard.HardLevel4;
import com.example.test60.Hard.HardLevel5;
import com.example.test60.Extreme.ExtremeLevel1;
import com.example.test60.Extreme.ActivityExtremeLevelSelector;
import com.example.test60.Extreme.ExtremeLevel2;
import com.example.test60.Extreme.ExtremeLevel3;
import com.example.test60.Extreme.ExtremeLevel4;
import com.example.test60.Extreme.ExtremeLevel5;
import com.example.test60.Easy.EasyLevel1;
import com.example.test60.Easy.EasyLevel2;
import com.example.test60.R;

public class ActivityGameOver extends AppCompatActivity {

    ImageButton setting, home, diff, tryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        setting = findViewById(R.id.settingsBtn);
        home = findViewById(R.id.homeBtn);
        diff = findViewById(R.id.backBtn3);
        tryAgain = findViewById(R.id.tryAgain);


        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentLoadNewActivity = new Intent(ActivityGameOver.this, ActivitySettings.class);
                startActivity(intentLoadNewActivity);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(ActivityGameOver.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);

                String currentDiff = pref.getString("diff", null);
                if(currentDiff == "easy") {
                    Intent intentLoadNewActivity = new Intent(ActivityGameOver.this, ActivityEasyLevelSelector.class);
                    startActivity(intentLoadNewActivity);
                }else if(currentDiff == "average") {
                    Intent intentLoadNewActivity = new Intent(ActivityGameOver.this, ActivityAverageLevelSelector.class);
                    startActivity(intentLoadNewActivity);
                }else if(currentDiff == "hard") {
                    Intent intentLoadNewActivity = new Intent(ActivityGameOver.this, ActivityHardLevelSelector.class);
                    startActivity(intentLoadNewActivity);
                }else if(currentDiff == "extreme") {
                    Intent intentLoadNewActivity = new Intent(ActivityGameOver.this, ActivityExtremeLevelSelector.class);
                    startActivity(intentLoadNewActivity);
                }else{
                    Intent intentLoadNewActivity = new Intent(ActivityGameOver.this, MainActivity.class);
                    startActivity(intentLoadNewActivity);
                }
            }
        });

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityGameOver.this, MainActivity.class);
                startActivity(intent);
                finish();

                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                int counter = pref.getInt("counter", 0);
                String diff = pref.getString("diff", null);

                if(diff.trim().equals("easy")){
                    if(counter == 0){
                        Intent retry = new Intent(ActivityGameOver.this, EasyLevel1.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==1){
                        Intent retry = new Intent(ActivityGameOver.this, EasyLevel2.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==2){
                        Intent retry = new Intent(ActivityGameOver.this, EasyLevel3.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==3){
                        Intent retry = new Intent(ActivityGameOver.this, EasyLevel4.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==4){
                        Intent retry = new Intent(ActivityGameOver.this, EasyLevel5.class);
                        startActivity(retry);
                        finish();
                    }
                }else if(diff.trim().equals("average")){
                    if(counter == 5){
                        Intent retry = new Intent(ActivityGameOver.this, AverageLevel1.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==6){
                        Intent retry = new Intent(ActivityGameOver.this, AverageLevel2.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==7){
                        Intent retry = new Intent(ActivityGameOver.this, AverageLevel3.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==8){
                        Intent retry = new Intent(ActivityGameOver.this, AverageLevel4.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==9){
                        Intent retry = new Intent(ActivityGameOver.this, AverageLevel5.class);
                        startActivity(retry);
                        finish();
                    }
                }else if(diff.trim().equals("hard")){
                    if(counter == 10){
                        Intent retry = new Intent(ActivityGameOver.this, HardLevel1.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==11){
                        Intent retry = new Intent(ActivityGameOver.this, HardLevel2.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==12){
                        Intent retry = new Intent(ActivityGameOver.this, HardLevel3.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==13){
                        Intent retry = new Intent(ActivityGameOver.this, HardLevel4.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==14){
                        Intent retry = new Intent(ActivityGameOver.this, HardLevel5.class);
                        startActivity(retry);
                        finish();
                    }
                }else if(diff.trim().equals("extreme")){
                    if(counter == 15){
                        Intent retry = new Intent(ActivityGameOver.this, ExtremeLevel1.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==16){
                        Intent retry = new Intent(ActivityGameOver.this, ExtremeLevel2.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==17){
                        Intent retry = new Intent(ActivityGameOver.this, ExtremeLevel3.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==18){
                        Intent retry = new Intent(ActivityGameOver.this, ExtremeLevel4.class);
                        startActivity(retry);
                        finish();
                    }else if(counter==19){
                        Intent retry = new Intent(ActivityGameOver.this, ExtremeLevel5.class);
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
