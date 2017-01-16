package com.mobidevtask.ui.base;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;


public interface HideShowContentSupport {

    void showContent();

    void showLoading();

    void showError(@Nullable String msg);

    void showError(@StringRes int res);
}
