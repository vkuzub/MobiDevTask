package com.mobidevtask.ui.base;

/**
 * Created by Vyacheslav on 12.09.2016.
 */
public interface ShowResponseSupport {

    void showErrorMessage(String msg, boolean toast);

    void showMessage(String msg);

    void showMessage(int msg);

    void doOnComplete();
}
