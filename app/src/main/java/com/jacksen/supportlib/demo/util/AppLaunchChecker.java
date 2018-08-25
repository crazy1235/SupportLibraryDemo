package com.jacksen.supportlib.demo.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.IntentCompat;
import android.support.v4.content.SharedPreferencesCompat;

/**
 * Created by jacksen on 2016/4/14.
 */
public class AppLaunchChecker {

    private static final String SHARED_PREFS_NAME = "android.support.AppLaunchChecker";
    private static final String KEY_STARTED_FROM_LAUNCHER = "startedFromLauncher";

    public static boolean hasStartedFromLauncher(Context context) {
        return context.getSharedPreferences(SHARED_PREFS_NAME, 0)
                .getBoolean(KEY_STARTED_FROM_LAUNCHER, false);
    }

    public static void onActivityCreate(Activity activity) {
        final SharedPreferences sp = activity.getSharedPreferences(SHARED_PREFS_NAME, 0);

        final Intent launchIntent = activity.getIntent();
        if (launchIntent == null) {
            return;
        }

        if (Intent.ACTION_MAIN.equals(launchIntent.getAction())
                && (launchIntent.hasCategory(Intent.CATEGORY_LAUNCHER)
                || launchIntent.hasCategory(IntentCompat.CATEGORY_LEANBACK_LAUNCHER))) {
            SharedPreferencesCompat.EditorCompat.getInstance().apply(
                    sp.edit().putBoolean(KEY_STARTED_FROM_LAUNCHER, true));
        } else {
            SharedPreferencesCompat.EditorCompat.getInstance().apply(
                    sp.edit().putBoolean(KEY_STARTED_FROM_LAUNCHER, false));
        }
    }
}
