package com.mobidevtask.ui.base.list;

import android.support.v4.widget.SwipeRefreshLayout;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;
import java.util.Map;



public interface BaseListMVP {

    interface View extends MvpView, SwipeRefreshLayout.OnRefreshListener {

        void fillData(List<BaseListItem> items);

        void showSrl(boolean show);

        void showPagination(boolean show);

    }

    interface Presenter<V extends BaseListMVP.View> extends MvpPresenter<V> {

        void loadData(boolean pullToRefresh, boolean paginate);

        void onLoadDataSuccess(BaseListResponse response, boolean pullToRefresh, boolean paginate);

        boolean hasMoreItems();

        Map<String, String> createQueries(int limit, int page);

    }

}
