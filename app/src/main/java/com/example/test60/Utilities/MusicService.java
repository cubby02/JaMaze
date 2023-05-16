package com.example.test60.Utilities;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.test60.R;

public class MusicService extends Service {

    private MediaPlayer mediaPlayer;

    final float defaultVolume = 0.5f;
    float currentVolume;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this, R.raw.bgm4);
        mediaPlayer.setLooping(true);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        currentVolume = sharedPreferences.getFloat("selectedVolume", defaultVolume);

        mediaPlayer.setVolume(currentVolume, currentVolume);
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();
    }

    // Method to get the MediaPlayer instance
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder(this);
    }

    public class MyBinder extends Binder {
        private MusicService service;

        public MyBinder(MusicService service) {
            this.service = service;
        }

        public MusicService getService() {
            return service;
        }
    }

}
