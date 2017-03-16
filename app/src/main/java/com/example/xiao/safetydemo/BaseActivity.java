package com.example.xiao.safetydemo;

import android.app.Activity;

/**
 * Created by xiao on 2017/3/14.
 */
//防止界面劫持的基类
public class BaseActivity extends Activity {

    @Override
    protected void onResume() {
        AtyModule.getinstance().onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        AtyModule.getinstance().onPause(this);
        super.onPause();
    }

}
