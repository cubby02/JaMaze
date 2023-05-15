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
        editor.putBoolean("easy2_unlocked", true); // Easy level 1 is unlocked by default
        editor.putBoolean("easy3_unlocked", true);
        editor.putBoolean("easy4_unlocked", true);
        editor.putBoolean("easy5_unlocked", true);
        editor.putBoolean("average1_unlocked", true);
        editor.putBoolean("average2_unlocked", true);
        editor.putBoolean("average3_unlocked", true);
        editor.putBoolean("average4_unlocked", true);
        editor.putBoolean("average5_unlocked", true);
        editor.putBoolean("hard1_unlocked", true);
        editor.putBoolean("hard2_unlocked", true);
        editor.putBoolean("hard3_unlocked", true);
        editor.putBoolean("hard4_unlocked", true);
        editor.putBoolean("hard5_unlocked", true);
        editor.putBoolean("extreme1_unlocked", true);
        editor.putBoolean("extreme2_unlocked", true);
        editor.putBoolean("extreme3_unlocked", true);
        editor.putBoolean("extreme4_unlocked", true);
        editor.putBoolean("extreme5_unlocked", true);




        // Commit the changes to the SharedPreferences
        editor.apply();
    }

    public boolean isLevelUnlocked(String level) {
        return preferences.getBoolean(level, false);
    }

    public void unlockLevel(String level) {
        editor.putBoolean(level, true);
        editor.apply();
    }

    public void resetProgress() {
        editor.clear();
        editor.apply();
    }
}

