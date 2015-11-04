package com.yuetongcheng.tourism.utils;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Administrator on 2015/10/30 0030.
 */
public class ViewTools {
    /**
     * 隐藏软键盘
     * @param view
     */
    public static void hideSoftKeyboard(View view) {
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
