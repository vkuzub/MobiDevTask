package com.mobidevtask.ui.base.list;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mobidevtask.R;
import com.mobidevtask.ui.base.BaseMVPFragment;
import com.mobidevtask.utils.CollectionUtils;
import com.mobidevtask.utils.EndlessRecyclerViewScrollListener;
import com.mobidevtask.utils.RvItemClickSupport;

import java.util.List;

import butterknife.BindView;

public abstract class BaseMVPListFragment<V extends BaseListMVP.View> extends BaseMVPFragment<V, BaseListPresenter<V>> implements BaseListMVP.View {

    @BindView(R.id.loadingView)
    protected ProgressBar loadingView;
    @BindView(R.id.errorView)
    protected TextView errorView;
    @BindView(R.id.contentView)
    protected FrameLayout contentView;

    @BindView(R.id.rvItems)
    protected RecyclerView rvItems;
    @BindView(R.id.srlRefresh)
    protected SwipeRefreshLayout srlRefresh;

    protected EndlessRecyclerViewScrollListener listener;
    protected BaseListAdapter adapter;

    public BaseMVPListFragment() {
        // Required empty public constructor
    }

    @Override
    public ProgressBar getLoadingView() {
        return loadingView;
    }

    @Override
    public View getContentView() {
        return contentView;
    }

    @Override
    public View getErrorView() {
        return errorView;
    }

    @Override
    public void onErrorViewClick() {
        getPresenter().loadData(false, false);
    }

    @Override
    public void onNewViewStateInstance() {
        showContent();
        getPresenter().loadData(false, false);
    }

    @Override
    public void initViews() {
        srlRefresh.setOnRefreshListener(this);
        srlRefresh.setColorSchemeResources(R.color.primary);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvItems.setLayoutManager(manager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(rvItems.getContext(), manager.getOrientation());
        rvItems.addItemDecoration(itemDecoration);
        rvItems.setItemAnimator(new DefaultItemAnimator());
        initAdapter();
        rvItems.setAdapter(adapter);
        listener = new EndlessRecyclerViewScrollListener(manager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (getPresenter().hasMoreItems() && !adapter.isLoading()) {
                    getPresenter().loadData(false, true);
//                    showPagination(true);
                }
            }
        };
        rvItems.addOnScrollListener(listener);

        RvItemClickSupport.addTo(rvItems).setOnItemClickListener((recyclerView, position, v) -> {
            onRvItemClick(recyclerView, position, v);
        });
    }

    public abstract void initAdapter();

    public abstract void onRvItemClick(RecyclerView recyclerView, int position, View v);

    @Override
    public void fillData(List<BaseListItem> items) {
        if (!CollectionUtils.isNullOrEmpty(items)) {
            showContent();
            if (adapter.isLoading()) {
                adapter.addMoreItems(items);
            } else {
                adapter.setData(items);
            }
        } else {
            showErrorMessage(getString(R.string.no_data) + getString(R.string.press_to_update), false);
        }
    }

    @Override
    public void showSrl(boolean show) {
        srlRefresh.setRefreshing(show);
    }

    @Override
    public void showPagination(boolean show) {
        if (show) {
            adapter.showLoading();
            srlRefresh.setEnabled(false);
        } else {
            adapter.hideLoading();
            listener.resetState();
            srlRefresh.setEnabled(true);
        }
    }

    @Override
    public void onRefresh() {
        getPresenter().loadData(true, false);
        if (adapter != null) {
            adapter.clear();
        }
    }

    @Override
    public void initRxSubscriptions() {

    }

    @Override
    public void doOnComplete() {

    }
}
