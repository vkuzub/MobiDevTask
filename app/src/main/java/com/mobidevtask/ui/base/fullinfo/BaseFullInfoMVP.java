package com.mobidevtask.ui.base.fullinfo;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.mobidevtask.ui.base.mvp.BaseMvpViewFragment;




public interface BaseFullInfoMVP {

    interface View extends BaseMvpViewFragment {

        void fillData(BaseFullInfoResponse response);

        void setItemId(long id);

        long getItemId();

    }

    interface Presenter<V extends View> extends MvpPresenter<V> {

        void loadData(long id);

        void onDataLoadSuccess(BaseFullInfoResponse response);

    }

}
