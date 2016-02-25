package com.jacksen.supportlibrarydemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * custom tabs settings
 *
 * @author jacksen
 */
public class CustomTabsSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tabs_settings);
    }


    private void openCustomTabs(){
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        int color = getResources().getColor(R.color.colorPrimary);
        builder.setToolbarColor(color);

        builder.setShowTitle(true);

        Bitmap closeIconBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ic_keyboard_backspace_white_18dp);
        builder.setCloseButtonIcon(closeIconBitmap);



    }
}
