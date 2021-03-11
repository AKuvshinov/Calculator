package com.aleksey_kuvshinov.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class Settings extends AppCompatActivity {
    public static final String MY_PREFERENCES = "nightModePreferences";
    public static final String KEY_NIGHT_MODE = "nightMode";
    SwitchCompat changeTheme;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener((view) -> {
            finish();
        });

        sharedPreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        changeTheme = findViewById(R.id.switch1);

        checkNightModeActivated();

        changeTheme.setOnCheckedChangeListener((buttonView, isChecked) ->
        {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                saveNightModeState(true);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                saveNightModeState(false);
            }
            recreate();
        });
    }

    private void saveNightModeState(boolean nightMode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_NIGHT_MODE, nightMode).apply();
    }

    public void checkNightModeActivated() {
        if (sharedPreferences.getBoolean(KEY_NIGHT_MODE, false)) {
            changeTheme.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            changeTheme.setChecked(false);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
