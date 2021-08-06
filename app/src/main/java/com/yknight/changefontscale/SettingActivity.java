package com.yknight.changefontscale;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.lodz.android.pandora.base.activity.AbsActivity;
import com.yknight.fontsizeview.FontSizeView;
import com.yknight.fontsizeview.utils.DensityUtils;
import com.yknight.fontsizeview.utils.SPUtils;

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
    private float fontSizeScale;
    private boolean isChange;//用于监听字体大小是否有改动
    private int defaultPos;

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
            public void onChangeListener(int position) {
                int dimension = getResources().getDimensionPixelSize(R.dimen.sp_stander);
                //根据position 获取字体倍数
                fontSizeScale = (float) (0.875 + 0.125 * position);
                //放大后的sp单位
                double v = fontSizeScale * (int) DensityUtils.px2sp(getContext(), dimension);
                //改变当前页面大小
                isChange = !(position == defaultPos);
                mTv.setTextSize((int) v);

            }
        });
        float scale = (float) SPUtils.get(this, FontSizeView.FONT_SCALE, 0.0f);
        if (scale > 0.5) {
            defaultPos = (int) ((scale - 0.875) / 0.125);
        } else {
            defaultPos = 1;
        }
        mFontView.setDefaultPosition(defaultPos);
    }


    @Override
    public void finish() {
        if (isChange) {
            SPUtils.put(getContext(), FontSizeView.FONT_SCALE, fontSizeScale);
            App.setAppFontSize(fontSizeScale);
        }
        super.finish();

    }

    /**
     * 重新配置缩放系数
     *
     * @return
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = res.getConfiguration();
        config.fontScale = 1;//1 设置正常字体大小的倍数
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }
}



