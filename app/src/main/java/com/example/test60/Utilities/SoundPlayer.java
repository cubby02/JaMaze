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


    private MediaPlayer mainBGMusic, click, after_maze, after_quiz, hit_wall, game_over, reset;

    public SoundPlayer(Context context) {
        mainBGMusic = MediaPlayer.create(context, R.raw.bgm4);
        click = MediaPlayer.create(context, R.raw.click_sound);
        after_maze = MediaPlayer.create(context, R.raw.after_maze);
        after_quiz = MediaPlayer.create(context, R.raw.after_quiz);
        hit_wall = MediaPlayer.create(context, R.raw.hit_wall);
        game_over = MediaPlayer.create(context, R.raw.game_over);
        reset = MediaPlayer.create(context, R.raw.reset_position);

        mainBGMusic.setLooping(true);
    }
    public void playMainMenuSound(){
        mainBGMusic.start();
    }

    public void playClick(){
        click.start();
    }

    public void playAfterMaze(){
        after_maze.start();
    }

    public void playAfterQuiz(){
        after_quiz.start();
    }

    public void playGameOver(){
        game_over.start();
    }

    public void playHitWall(){
        hit_wall.start();
    }

    public void stopHitWall(){
        hit_wall.stop();
    }

    public void playReset(){
        reset.start();
    }

    public void stopMainMenuSound() { mainBGMusic.stop(); }

    public void setMainVolume(float volume) {
        mainBGMusic.setVolume(volume, volume);
    }

    public void setClickVolume(float volume) {
        click.setVolume(volume, volume);
        after_maze.setVolume(volume, volume);
        after_quiz.setVolume(volume, volume);
        game_over.setVolume(volume, volume);
        hit_wall.setVolume(volume, volume);
        reset.setVolume(volume, volume);
    }
}
