package com.yknight.changefontscale;

import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;

import com.lodz.android.pandora.base.activity.AbsActivity;

public class MainActivity extends AbsActivity {

    private static final int REQUEST_CODE = 1111;

    @Override
    protected int getAbsLayoutId() {
        return R.layout.activity_main;
    }

    public void openSetting(View view) {
        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {

        }
    }
}