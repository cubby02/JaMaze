package com.example.test60.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test60.R;

public class ActivityAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}