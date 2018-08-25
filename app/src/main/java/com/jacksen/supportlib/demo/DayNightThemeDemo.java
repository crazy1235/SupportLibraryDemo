package com.jacksen.supportlib.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

/**
 * @author jacksen
 */
public class DayNightThemeDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_night_theme_demo);
    }


    public void setModeNightNo(View view) {
        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        recreate();
    }

    public void setModeNightYes(View view) {
        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        recreate();
    }

    public void setModeNightAuto(View view) {
        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        recreate();
    }
}
