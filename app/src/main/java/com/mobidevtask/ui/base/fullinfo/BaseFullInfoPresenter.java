package com.mobidevtask.ui.base.fullinfo;

import com.mobidevtask.R;
import com.mobidevtask.ui.base.mvp.BasePresenter;



public abstract class BaseFullInfoPresenter<V extends BaseFullInfoMVP.View> extends BasePresenter<V> implements BaseFullInfoMVP.Presenter<V> {


    @Override
    public void onDataLoadSuccess(BaseFullInfoResponse response) {
        if (isViewAttached()) {
            if (response != null) {
                getView().fillData(response);
                getView().showContent();
                return;
            }
        }
        getView().showError(R.string.oops_something_went_wrong);
    }

}
