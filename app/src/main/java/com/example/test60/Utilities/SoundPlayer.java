package com.example.test60.Utilities;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.test60.R;

public class SoundPlayer {


    private MediaPlayer mainBGMusic, click;

    public SoundPlayer(Context context) {
        mainBGMusic = MediaPlayer.create(context, R.raw.bgm4);
        click = MediaPlayer.create(context, R.raw.click_sound);

        mainBGMusic.setLooping(true);
    }
    public void playMainMenuSound(){
        mainBGMusic.start();
    }

    public void playClick(){
        click.start();
    }

    public void stopMainMenuSound() { mainBGMusic.stop(); }

    public void setMainVolume(float volume) {
        mainBGMusic.setVolume(volume, volume);
    }

    public void setClickVolume(float volume) {
        click.setVolume(volume, volume);
    }
}
