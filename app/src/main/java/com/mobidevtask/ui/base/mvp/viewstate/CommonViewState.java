package com.mobidevtask.ui.base.mvp.viewstate;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;
import com.mobidevtask.App;
import com.mobidevtask.R;
import com.mobidevtask.ui.base.mvp.BaseMvpViewFragment;

/**
 * Created by Vyacheslav on 12.09.2016.
 */
public class CommonViewState implements RestorableViewState<BaseMvpViewFragment> {

    private static final int STATE_SHOW_CONTENT = 0;
    private static final int STATE_SHOW_LOADING = 1;
    private static final int STATE_SHOW_ERROR = 2;

    private int state = STATE_SHOW_CONTENT;
    private String errorMsg = App.getApplication().getString(R.string.an_error_has_occurred);

    private static final String STATE_SAVE = "STATE";
    private static final String ERROR_MSG_SAVE = "STATE";

    public void showContent() {
        state = STATE_SHOW_CONTENT;
    }

    public void showLoading() {
        state = STATE_SHOW_LOADING;
    }

    public void showError(String msg) {
        state = STATE_SHOW_ERROR;
        errorMsg = msg;
    }

    @Override
    public void saveInstanceState(@NonNull Bundle out) {
        out.putInt(STATE_SAVE, state);
        out.putString(ERROR_MSG_SAVE, errorMsg);
    }

    @Override
    public RestorableViewState<BaseMvpViewFragment> restoreInstanceState(Bundle in) {
        state = in.getInt(STATE_SAVE);
        errorMsg = in.getString(ERROR_MSG_SAVE);
        return this;
    }

    @Override
    public void apply(BaseMvpViewFragment view, boolean retained) {
        switch (state) {
            case STATE_SHOW_CONTENT:
                view.showContent();
                break;
            case STATE_SHOW_LOADING:
                view.showLoading();
                break;
            case STATE_SHOW_ERROR:
                view.showError(errorMsg);
                break;
        }
    }
}
