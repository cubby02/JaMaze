package com.example.test60.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;
import android.content.ContentResolver;
import android.view.Window;

import com.example.test60.R;
import com.example.test60.Utilities.GlobalApplication;
import com.example.test60.Utilities.MusicService;
import com.example.test60.Utilities.SoundPlayer;

public class ActivitySettings extends AppCompatActivity {

    ImageButton f1,f2,f3,m1,m2,m3;
    SeekBar musiBar, soundBar;
    ImageView chartt,chartt2,chartt3,chartt4,chartt5,chartt6,chartt7,chartt8,chartt9,chartt10,chartt11,chartt12,chartt13,chartt14,chartt15,chartt16,chartt17,chartt18,chartt19,chartt20;


    //Variable to store brightness value
    private int brightness;
    //Content resolver used as a handle to the system's settings
    private ContentResolver cResolver;
    //Window object, that will store a reference to the current window
    private Window window;
    public MediaPlayer mediaPlayer;
    final float maxVolume = 1.0f;
    final float defaultVolume = 0.5f;
    float currentVolume;

    final float maxVolume2 = 1.0f;
    final float defaultVolume2 = 0.5f;
    float currentVolume2;

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
        setContentView(R.layout.activity_settings);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

        f1 = findViewById(R.id.charfemale1);
        f2 = findViewById(R.id.charfemale2);
        f3 = findViewById(R.id.charfemale3);
        m1 = findViewById(R.id.charmale1);
        m2 = findViewById(R.id.charmale2);
        m3 = findViewById(R.id.charmale3);
        musiBar = findViewById(R.id.musicBar);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_easy_level_1, null);

        chartt = view.findViewById(R.id.chartt);

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editor.putString("character", "charfemale1");
                editor.commit();

                Toast.makeText(getApplicationContext(), "settings updated.", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("character", "charfemale2");
                editor.commit();

                Toast.makeText(getApplicationContext(), "settings updated.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("character", "charfemale3");
                editor.commit();

                Toast.makeText(getApplicationContext(), "settings updated.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("character", "charmale1");
                editor.commit();

                Toast.makeText(getApplicationContext(), "settings updated.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("character", "charmale2");
                editor.commit();

                Toast.makeText(getApplicationContext(), "settings updated.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("character", "charmale3");
                editor.commit();

                Toast.makeText(getApplicationContext(), "settings updated.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        SoundPlayer soundPlayer = ((GlobalApplication) getApplication()).getSoundPlayer();

        // Retrieve the saved volume from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        float selectedVolume = sharedPreferences.getFloat("selectedVolume", defaultVolume);


        if (!Float.isNaN(selectedVolume)) {
            currentVolume = selectedVolume;
        } else {
            currentVolume = defaultVolume;
        }

        musiBar.setProgress((int)(currentVolume / maxVolume * 100));

        if (isBound) {
            MediaPlayer mediaPlayer = myService.getMediaPlayer();
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(currentVolume, currentVolume);
            }
        }

        musiBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentVolume = progress / 100f * maxVolume;
                if (isBound) {
                    MediaPlayer mediaPlayer = myService.getMediaPlayer();
                    if (mediaPlayer != null) {
                        mediaPlayer.setVolume(currentVolume, currentVolume);
                    }
                }

                // Save the selected volume to SharedPreferences
                // Check if the shared preferences are not null before saving the volume
                SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("selectedVolume", currentVolume);
                    editor.apply();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Retrieve the saved volume from SharedPreferences
        SharedPreferences sharedPreferences2 = getSharedPreferences("MyPreferences2", MODE_PRIVATE);
        float selectedVolume2 = sharedPreferences2.getFloat("selectedVolume2", defaultVolume2);


        if (!Float.isNaN(selectedVolume2)) {
            currentVolume2 = selectedVolume2;
        } else {
            currentVolume2 = defaultVolume2;
        }

        soundBar = findViewById(R.id.soundBar);
        soundBar.setProgress((int)(currentVolume2 / maxVolume2 * 100));

        soundBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentVolume2 = progress / 100f * maxVolume2;
                soundPlayer.setClickVolume(currentVolume2);

                // Save the selected volume to SharedPreferences
                // Check if the shared preferences are not null before saving the volume
                SharedPreferences sharedPreferences2 = getSharedPreferences("MyPreferences2", MODE_PRIVATE);
                if (sharedPreferences2 != null) {
                    SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                    editor2.putFloat("selectedVolume2", currentVolume2);
                    editor2.apply();
                }

                soundPlayer.playClick();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}