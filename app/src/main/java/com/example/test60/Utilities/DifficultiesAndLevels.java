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
        editor.putBoolean("easy2_unlocked", false); // All other levels are locked by default
        editor.putBoolean("easy3_unlocked", false);
        editor.putBoolean("easy4_unlocked", false);
        editor.putBoolean("easy5_unlocked", false);
        editor.putBoolean("average_unlocked", false);
        editor.putBoolean("average1_unlocked", false);
        editor.putBoolean("average2_unlocked", false);
        editor.putBoolean("average3_unlocked", false);
        editor.putBoolean("average4_unlocked", false);
        editor.putBoolean("average5_unlocked", false);
        editor.putBoolean("hard_unlocked", false);
        editor.putBoolean("hard1_unlocked", false);
        editor.putBoolean("hard2_unlocked", false);
        editor.putBoolean("hard3_unlocked", false);
        editor.putBoolean("hard4_unlocked", false);
        editor.putBoolean("hard5_unlocked", false);
        editor.putBoolean("extreme_unlocked", false);
        editor.putBoolean("extreme1_unlocked", false);
        editor.putBoolean("extreme2_unlocked", false);
        editor.putBoolean("extreme3_unlocked", false);
        editor.putBoolean("extreme4_unlocked", false);
        editor.putBoolean("extreme5_unlocked", false);

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

