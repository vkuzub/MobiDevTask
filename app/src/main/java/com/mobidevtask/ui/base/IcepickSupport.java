package com.mobidevtask.ui.base;

import android.os.Bundle;


public interface IcepickSupport {

    <T> void restoreInstanceState(T t, Bundle savedInstanceState);

    <T> void saveInstanceState(T t, Bundle savedInstanceState);
}
