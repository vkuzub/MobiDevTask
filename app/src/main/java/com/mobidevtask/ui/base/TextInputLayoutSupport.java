package com.mobidevtask.ui.base;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;


public interface TextInputLayoutSupport {

    void showTextInputLayoutError(@NonNull TextInputLayout til, @NonNull String msg);

    void showTextInputLayoutSuccess(@NonNull TextInputLayout til);
}
