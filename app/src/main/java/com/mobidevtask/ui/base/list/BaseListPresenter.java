package com.mobidevtask.ui.base.list;

import com.mobidevtask.ui.base.HideShowContentSupport;
import com.mobidevtask.ui.base.mvp.BasePresenter;

import java.util.Map;

/**
 * Created by Vyacheslav on 28.12.2016.
 */

public abstract class BaseListPresenter<V extends BaseListMVP.View> extends BasePresenter<V> implements BaseListMVP.Presenter<V> {

    public static final int FIRST_PAGE = 1;
    public static final int EVENTS_LIMIT = 5;
    protected int currentPage = 1;
    protected int totalCount;

    @Override
    public abstract void loadData(boolean pullToRefresh, boolean paginate);

    @Override
    public void onLoadDataSuccess(BaseListResponse response, boolean pullToRefresh, boolean paginate) {
        if (isViewAttached()) {
            if (response != null) {
                getView().fillData(response.getData());

                setTotalCount(response.getTotal());

                if (paginate) {
                    getView().showPagination(false);
                } else {
                    setCurrentPage(FIRST_PAGE);
                }

                if (pullToRefresh) {
                    getView().showSrl(!pullToRefresh);
                }
            }
        } else {
            ((HideShowContentSupport) getView()).showError(null);
        }
    }

    @Override
    public abstract Map<String, String> createQueries(int limit, int page);

    @Override
    public boolean hasMoreItems() {
        Double totalPages = Math.ceil(getTotalCount() / EVENTS_LIMIT);
        if (getCurrentPage() <= totalPages.intValue()) {
            return true;
        }
        return false;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
