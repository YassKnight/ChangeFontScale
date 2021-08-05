package com.yknight.changefontscale;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.lodz.android.pandora.base.activity.AbsActivity;
import com.yknight.fontsizeview.FontSizeView;

/**
 * @ ProjectName:    ChangeFontScale
 * @ Package:        com.yknight.changefontscale
 * @ ClassName:      SettingActivity
 * @ CreateAuthor:   yKnight
 * @ CreateDate:     2021/8/5
 * @ description:
 */
public class SettingActivity extends AbsActivity {

    TextView mTv;
    FontSizeView mFontView;

    @Override
    protected int getAbsLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void findViews(@Nullable Bundle savedInstanceState) {
        super.findViews(savedInstanceState);
        mTv = findViewById(R.id.textView);
        mFontView = findViewById(R.id.font_size_view);
        mFontView.setChangeCallbackListener(new FontSizeView.OnChangeCallbackListener() {
            @Override
            public void onChangeListener(float fontScale, int fontSizeSp) {
                mTv.setTextSize(fontSizeSp);
                App.setAppFontSize(fontScale);
            }
        });

    }


}
