package com.yuetongcheng.tourism.utils;

import android.app.Activity;
import android.os.Process;

import java.util.Stack;

/**
 * Created by Administrator on 2015/10/30 0030.
 */
public class MyActivityManager {
    private static Stack<Activity> activityStack;
    private static MyActivityManager instance;

    private MyActivityManager() {
        if (activityStack == null) {
            activityStack = new Stack();
        }

    }

    public static MyActivityManager getAppManager() {
        if (instance == null) {
            instance = new MyActivityManager();
        }

        return instance;
    }

    public void finishActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            activityStack.remove(activity);
            activity = null;
        }

    }

    public void finishActivity(Class... cles) {
        int cycleCount = 0;
        if (activityStack != null) {
            int count = activityStack.size();
            int i = 0;

            while (true) {
                Activity activity;
                do {
                    if (i >= count) {
                        return;
                    }

                    activity = (Activity) activityStack.get(i);
                    if (cycleCount > 50) {
                        return;
                    }
                } while (activity == null);

                Class[] arr$ = cles;
                int len$ = cles.length;

                for (int i$ = 0; i$ < len$; ++i$) {
                    Class cls = arr$[i$];
                    if (activity.getClass().equals(cls)) {
                        activity.finish();
                        activityStack.remove(activity);
                        activity = null;
                        count = activityStack.size();
                        break;
                    }
                }

                if (activity != null) {
                    ++i;
                }

                ++cycleCount;
            }
        }
    }

    public void finishActivity() {
        Activity activity = this.currentActivity();
        if (activity != null) {
            activity.finish();
            activityStack.remove(activity);
            activity = null;
        }

    }

    public Activity currentActivity() {
        Activity activity = null;
        if (activityStack != null && !activityStack.empty()) {
            activity = (Activity) activityStack.lastElement();
        }

        return activity;
    }

    public void pushActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack();
        }

        activityStack.add(activity);
    }

    public boolean finishAllActivityExceptOne(Class<?> cls) {
        boolean flag = true;

        while (flag) {
            Activity activity = this.currentActivity();
            if (activity == null) {
                break;
            }

            if (activity.getClass().equals(cls)) {
                flag = false;
            } else if (activity.isFinishing()) {
                activityStack.remove(activity);
                activity = null;
            } else {
                this.finishActivity(activity);
            }
        }

        return flag;
    }

    public void finishAllActivity() {
        int i = 0;

        for (int size = activityStack.size(); i < size; ++i) {
            if (null != activityStack.get(i)) {
                ((Activity) activityStack.get(i)).finish();
            }
        }

        activityStack.clear();
        android.os.Process.killProcess(Process.myPid());
        System.gc();
    }

    public boolean isExist(Class<?> cls) {
        for (int i = 0; i < activityStack.size(); ++i) {
            Activity activity = (Activity) activityStack.elementAt(i);
            if (activity != null && activity.getClass().equals(cls)) {
                return true;
            }
        }

        return false;
    }
}
