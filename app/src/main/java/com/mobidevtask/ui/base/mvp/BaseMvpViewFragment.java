package com.mobidevtask.ui.base.mvp;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mobidevtask.ui.base.HideShowContentSupport;
import com.mobidevtask.ui.base.IcepickSupport;
import com.mobidevtask.ui.base.RxSupport;
import com.mobidevtask.ui.base.ShowResponseSupport;


/**
 * Created by Vyacheslav on 25.09.2016.
 */

public interface BaseMvpViewFragment extends MvpView,
        HideShowContentSupport, IcepickSupport, ShowResponseSupport, RxSupport {

    void initViews();

}
