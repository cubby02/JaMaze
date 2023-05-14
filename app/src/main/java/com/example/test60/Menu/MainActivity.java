package com.example.test60.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;

import com.example.test60.R;
import com.example.test60.Utilities.GlobalApplication;
import com.example.test60.Utilities.MusicService;
import com.example.test60.Utilities.SoundPlayer;

public class MainActivity extends AppCompatActivity {
    ImageButton imgButton;
    public SoundPlayer sound;

    final float maxVolume = 1.0f;
    final float defaultVolume = 0.5f;
    float currentVolume;

    private MusicService myService;
    private boolean isBound = false;

    // Service connection to bind the activity to the service
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicService.MyBinder myBinder = (MusicService.MyBinder) iBinder;
            myService = myBinder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sound = ((GlobalApplication) getApplication()).getSoundPlayer();

        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        startService(intent);


        // Retrieve the saved volume from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        float selectedVolume = sharedPreferences.getFloat("selectedVolume", defaultVolume);


        if (!Float.isNaN(selectedVolume)) {
            currentVolume = selectedVolume;
        } else {
            currentVolume = defaultVolume;
        }

        if (isBound) {
            MediaPlayer mediaPlayer = myService.getMediaPlayer();
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(currentVolume, currentVolume);
            }
        }

        imgButton = (ImageButton) findViewById(R.id.imageButton);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                Intent intentLoadNewActivity = new Intent(MainActivity.this, ActivitySelectDifficulty.class);
                startActivity(intentLoadNewActivity);
            }
        });

        imgButton = (ImageButton) findViewById(R.id.imageButton2);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.playClick();
                Intent intentLoadNewActivity = new Intent(MainActivity.this, ActivitySettings.class);
                startActivity(intentLoadNewActivity);
            }
        });

        Button startbutton = (Button) findViewById(R.id.button);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityAbout.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isBound) {
            // Unbind from the service
            unbindService(serviceConnection);
            isBound = false;
        }

        stopService(new Intent(this, MusicService.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}