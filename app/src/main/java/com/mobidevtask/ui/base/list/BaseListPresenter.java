package com.mobidevtask.ui.base.list;

import com.mobidevtask.ui.base.HideShowContentSupport;
import com.mobidevtask.ui.base.mvp.BasePresenter;

import java.util.HashMap;
import java.util.Map;



public abstract class BaseListPresenter<V extends BaseListMVP.View> extends BasePresenter<V> implements BaseListMVP.Presenter<V> {

    public static final int FIRST_PAGE = 0;
    public static final int EVENTS_LIMIT = 10;
    protected int currentPage = 0;
    protected int totalCount;

    @Override
    public abstract void loadData(boolean pullToRefresh, boolean paginate);

    @Override
    public void onLoadDataSuccess(BaseListResponse response, boolean pullToRefresh, boolean paginate) {
        if (isViewAttached()) {
            if (response != null) {
                getView().fillData(response.getResults());

                setTotalCount(response.getCount());

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

    protected void showLoading(boolean pullToRefresh, boolean paginate){
        if (paginate) {
            setCurrentPage(getCurrentPage() + 1);
            getView().showPagination(true);
            currentPage = getCurrentPage();
        } else {
            if (pullToRefresh) {
                getView().showSrl(pullToRefresh);
                setCurrentPage(FIRST_PAGE);
            } else {
                ((HideShowContentSupport) getView()).showLoading();
            }
        }
    }

    @Override
    public Map<String, String> createQueries(int limit, int page) {
        HashMap<String, String> query = new HashMap<>();
        query.put("limit", String.valueOf(limit));
        query.put("offset", String.valueOf(page));
        return query;
    }

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
