package com.example.test60.Utilities;

import android.app.Application;

public class GlobalApplication extends Application {
    private SoundPlayer soundPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        soundPlayer = new SoundPlayer(this);
    }

    public SoundPlayer getSoundPlayer() {
        return soundPlayer;
    }
}
