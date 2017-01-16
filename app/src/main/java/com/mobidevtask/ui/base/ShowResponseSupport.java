package com.mobidevtask.ui.base;


public interface ShowResponseSupport {

    void showErrorMessage(String msg, boolean toast);

    void showMessage(String msg);

    void showMessage(int msg);

    void doOnComplete();
}
