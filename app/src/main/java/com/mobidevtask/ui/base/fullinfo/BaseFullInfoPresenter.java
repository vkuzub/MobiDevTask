package com.mobidevtask.ui.base.fullinfo;

import com.mobidevtask.R;
import com.mobidevtask.ui.base.HideShowContentSupport;
import com.mobidevtask.ui.base.list.BaseListItem;
import com.mobidevtask.ui.base.mvp.BasePresenter;

/**
 * Created by Vyacheslav on 03.01.2017.
 */

public abstract class BaseFullInfoPresenter<V extends BaseFullInfoMVP.View> extends BasePresenter<V> implements BaseFullInfoMVP.Presenter<V> {


    @Override
    public void onDataLoadSuccess(BaseListItem response) {
        if (isViewAttached()) {
            if (response != null) {
                getView().fillData(response);
                return;
            }
        }
        ((HideShowContentSupport) getView()).showError(R.string.oops_something_went_wrong);
    }

}
