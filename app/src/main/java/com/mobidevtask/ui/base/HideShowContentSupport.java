package com.mobidevtask.ui.base;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

/**
 * Created by Vyacheslav on 12.09.2016.
 */
public interface HideShowContentSupport {

    void showContent();

    void showLoading();

    void showError(@Nullable String msg);

    void showError(@StringRes int res);
}
