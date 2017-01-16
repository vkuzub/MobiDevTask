package com.mobidevtask.utils;

import android.content.Context;
import android.widget.Toast;

import com.mobidevtask.App;


public class ToastUtils {

    public final static ToastUtils LONG = new ToastUtils(Toast.LENGTH_LONG);
    public final static ToastUtils SHORT = new ToastUtils(Toast.LENGTH_SHORT);

    private static Toast instance;

    private final int duration;

    private ToastUtils(int duration) {
        this.duration = duration;
    }

    private Toast makeText(Context context, String text) {
        cancel();
        instance = Toast.makeText(context, text, duration);
        return instance;
    }

    private Toast makeText(Context context, int resId) {
        cancel();
        instance = Toast.makeText(context, resId, duration);
        return instance;
    }

    public void show(String text) {
        makeText(App.getContext(), text).show();
    }

    public void show(int resId) {
        makeText(App.getContext(), resId).show();
    }

    private void cancel() {
        if (instance != null) {
            instance.cancel();
        }
    }
}
