package com.mobidevtask.ui.base.fullinfo;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mobidevtask.ui.base.list.BaseListItem;


/**
 * Created by Vyacheslav on 03.01.2017.
 */

public interface BaseFullInfoMVP {

    interface View extends MvpView {

        void fillData(BaseListItem response);

        void setItemId(int id);

        int getItemId();

    }

    interface Presenter<V extends View> extends MvpPresenter<V> {

        void loadData(int id);

        void onDataLoadSuccess(BaseListItem response);

    }

}
