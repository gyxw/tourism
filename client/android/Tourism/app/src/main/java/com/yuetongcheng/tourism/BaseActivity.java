package com.yuetongcheng.tourism;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.umeng.analytics.MobclickAgent;
import com.yuetongcheng.tourism.utils.MyActivityManager;
import com.yuetongcheng.tourism.utils.ViewTools;

/**
 * Created by Qiyan on 2015/10/30 0030.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        MyActivityManager.getAppManager().pushActivity(this);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewTools.hideSoftKeyboard(getCurrentFocus());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MyActivityManager.getAppManager().finishActivity(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            this.onBackPressed();
            return true;
        }
        return false;
    }
}
