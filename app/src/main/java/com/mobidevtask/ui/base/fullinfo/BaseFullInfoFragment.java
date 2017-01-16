package com.mobidevtask.ui.base.fullinfo;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mobidevtask.R;
import com.mobidevtask.ui.base.BaseMVPFragment;

import butterknife.BindView;



public abstract class BaseFullInfoFragment<V extends BaseFullInfoMVP.View> extends BaseMVPFragment<V, BaseFullInfoPresenter<V>> implements BaseFullInfoMVP.View {

    @BindView(R.id.loadingView)
    protected ProgressBar loadingView;
    @BindView(R.id.errorView)
    protected TextView errorView;
    @BindView(R.id.contentView)
    protected View contentView;

    private long itemId;


    @Override
    public long getItemId() {
        return itemId;
    }

    @Override
    public void setItemId(long itemId) {
        this.itemId = itemId;
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

    }

    @Override
    public void onNewViewStateInstance() {
        showLoading();
        getPresenter().loadData(itemId);
    }

    @Override
    public void initRxSubscriptions() {

    }

    @Override
    public void doOnComplete() {

    }

}
