package com.mobidevtask.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.mobidevtask.App;


public final class KeyboardUtils {

    private KeyboardUtils() {
    }

    public static void showKeyboard(View target) {
        if (target != null) {
            InputMethodManager imm = (InputMethodManager) App.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(target, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    public static void hideKeyboard(View target) {
        if (target != null) {
            InputMethodManager imm = (InputMethodManager) App.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(target.getWindowToken(), 0);
        }
    }
}
