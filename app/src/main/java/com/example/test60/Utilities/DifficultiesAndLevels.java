package com.example.test60.Utilities;


import android.content.Context;
import android.content.SharedPreferences;

public class DifficultiesAndLevels {
    private static final String PREFERENCES_NAME = "GAME_PROGRESS";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public DifficultiesAndLevels(Context context) {
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();

        // Set the initial state for the levels
        editor.putBoolean("easy_unlocked", true);
        editor.putBoolean("easy1_unlocked", true); // Easy level 1 is unlocked by default
        editor.putBoolean("easy2_unlocked", preferences.getBoolean("easy2_unlocked", false)); // Use the current value of easy2_unlocked
        editor.putBoolean("easy3_unlocked", preferences.getBoolean("easy3_unlocked", false));
        editor.putBoolean("easy4_unlocked", preferences.getBoolean("easy4_unlocked", false));
        editor.putBoolean("easy5_unlocked", preferences.getBoolean("easy5_unlocked", false));
        editor.putBoolean("average1_unlocked", preferences.getBoolean("average1_unlocked", false));
        editor.putBoolean("average2_unlocked", preferences.getBoolean("average2_unlocked", false));
        editor.putBoolean("average3_unlocked", preferences.getBoolean("average3_unlocked", false));
        editor.putBoolean("average4_unlocked", preferences.getBoolean("average4_unlocked", false));
        editor.putBoolean("average5_unlocked", preferences.getBoolean("average5_unlocked", false));
        editor.putBoolean("hard1_unlocked", preferences.getBoolean("hard1_unlocked", false));
        editor.putBoolean("hard2_unlocked", preferences.getBoolean("hard2_unlocked", false));
        editor.putBoolean("hard3_unlocked", preferences.getBoolean("hard3_unlocked", false));
        editor.putBoolean("hard4_unlocked", preferences.getBoolean("hard4_unlocked", false));
        editor.putBoolean("hard5_unlocked", preferences.getBoolean("hard5_unlocked", false));
        editor.putBoolean("extreme1_unlocked", preferences.getBoolean("extreme1", false));
        editor.putBoolean("extreme2_unlocked", preferences.getBoolean("extreme2", false));
        editor.putBoolean("extreme3_unlocked", preferences.getBoolean("extreme3", false));
        editor.putBoolean("extreme4_unlocked", preferences.getBoolean("extreme4", false));
        editor.putBoolean("extreme5_unlocked", preferences.getBoolean("extreme5", false));
        editor.putBoolean("game_completed", preferences.getBoolean("game_completed",false));


        // Commit the changes to the SharedPreferences
        editor.apply();
    }



    public boolean isGameComplete(String level){
        return preferences.getBoolean(level, false);
    }

    public boolean isLevelUnlocked(String level) {
        return preferences.getBoolean(level, false);
    }

    public void unlockLevel(String level) {
        editor.putBoolean(level, true);
        editor.apply();
    }

    public void gameComplete(String level) {
        editor.putBoolean(level, true);
        editor.apply();
    }

    public void resetProgress() {
        editor.clear();
        editor.apply();
    }
}

