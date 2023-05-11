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
    private static SoundPool soundPool;
    private static int clickButton;
    private MediaPlayer mainBGMusic;

    public SoundPlayer(Context context) {
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        //clickButton = soundPool.load(context, R.raw.sfx_shieldup, 1);
        mainBGMusic = MediaPlayer.create(context, R.raw.bgm2);

    }
    public void playMainMenuSound(){
        mainBGMusic.start();
    }

    public void stopMainMenuSound() { mainBGMusic.stop(); }

    public void setVolume(float volume) {
        mainBGMusic.setVolume(volume, volume);
    }

}
