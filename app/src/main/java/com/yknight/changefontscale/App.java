package com.yknight.changefontscale;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lodz.android.pandora.base.application.BaseApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * @ ProjectName:    ChangeFontScale
 * @ Package:        com.yknight.changefontscale
 * @ ClassName:      App
 * @ CreateAuthor:   yKnight
 * @ CreateDate:     2021/8/5
 * @ description:
 */
public class App extends BaseApplication implements Application.ActivityLifecycleCallbacks {

    private List<Activity> activityList;
    private float fontScale;
    private SharedPreferences preferences;
    private static App app;

    @Override
    public void onExit() {

    }

    @Override
    public void onStartCreate() {
        init();
    }

    private void init() {
        app = this;
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        fontScale = getFontScale();
        registerActivityLifecycleCallbacks(this);
    }

    public static float getFontScale() {
        float fontScale = 1.0f;
        if (app != null) {
            fontScale = app.preferences.getFloat("fontScale", 1.0f);
        }
        return fontScale;
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        if (activityList == null) {
            activityList = new ArrayList<>();
        }
        // 禁止字体大小随系统设置变化
        Resources resources = activity.getResources();
        if (resources != null && resources.getConfiguration().fontScale != fontScale) {
            android.content.res.Configuration configuration = resources.getConfiguration();
            configuration.fontScale = fontScale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        activityList.add(activity);
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        if (activityList != null) {
            activityList.remove(activity);
        }
    }

    public static void setAppFontSize(float fontScale) {
        if (app != null) {
            List<Activity> activityList = app.activityList;
            if (activityList != null) {
                for (Activity activity : activityList) {
                    if (activity instanceof SettingActivity) {
                        continue;
                    }
                    Resources resources = activity.getResources();
                    if (resources != null) {
                        android.content.res.Configuration configuration = resources.getConfiguration();
                        configuration.fontScale = fontScale;
                        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
                        activity.recreate();
                        if (fontScale != app.fontScale) {
                            app.fontScale = fontScale;
                            app.preferences.edit().putFloat("fontScale", fontScale).apply();
                        }
                    }
                }
            }
        }
    }
}
