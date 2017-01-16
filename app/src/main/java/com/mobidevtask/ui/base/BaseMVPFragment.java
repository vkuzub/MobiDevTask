package com.mobidevtask.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mobidevtask.R;
import com.mobidevtask.ui.base.mvp.BaseMvpViewFragment;
import com.mobidevtask.ui.base.mvp.viewstate.CommonViewState;
import com.mobidevtask.utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import icepick.Icepick;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Vyacheslav on 29.11.2016.
 */

public abstract class BaseMVPFragment<V extends MvpView, P extends MvpPresenter<V>> extends MvpViewStateFragment<V, P> implements BaseMvpViewFragment {

    private CompositeSubscription compositeSubscription;
    private Unbinder unbinder;

    public abstract ProgressBar getLoadingView();

    public abstract View getContentView();

    public abstract View getErrorView();

    public abstract int getLayoutId();

    @Override
    public ViewState createViewState() {
        return new CommonViewState();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreInstanceState(this, savedInstanceState);
        setRetainInstance(true);
        compositeSubscription = new CompositeSubscription();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initRxSubscriptions();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    @Override
    public void showContent() {
        getContentView().setVisibility(View.VISIBLE);
        getLoadingView().setVisibility(View.GONE);
        getErrorView().setVisibility(View.GONE);

        CommonViewState viewState = (CommonViewState) getViewState();
        viewState.showContent();
    }

    @Override
    public void showLoading() {
        getContentView().setVisibility(View.GONE);
        getLoadingView().setVisibility(View.VISIBLE);
        getErrorView().setVisibility(View.GONE);

        CommonViewState viewState = (CommonViewState) getViewState();
        viewState.showLoading();
    }

    @Override
    public void showError(@Nullable String msg) {
        getContentView().setVisibility(View.GONE);
        getLoadingView().setVisibility(View.GONE);
        getErrorView().setVisibility(View.VISIBLE);

        ((TextView) getErrorView()).setText(msg);

        CommonViewState viewState = (CommonViewState) getViewState();
        viewState.showError(msg);
    }

    @Override
    public void showError(@StringRes int res) {
        showError(getString(res));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstanceState(this, outState);
    }

    @Override
    public <T> void restoreInstanceState(T t, Bundle savedInstanceState) {
        Icepick.restoreInstanceState(t, savedInstanceState);
    }

    @Override
    public <T> void saveInstanceState(T t, Bundle savedInstanceState) {
        Icepick.saveInstanceState(t, savedInstanceState);
    }

    @Override
    public void rxUnsubscribe() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
        }
    }

    @Override
    public void rxAddSubscription(Subscription sub) {
        if (compositeSubscription != null) {
            compositeSubscription.add(sub);
        }
    }

    @Override
    public void showErrorMessage(String msg, boolean toast) {
        if (toast) {
            showMessage(msg);
        } else {
            showError(msg);
        }
    }

    @Override
    public void showMessage(String msg) {
        ToastUtils.SHORT.show(msg);
    }

    @Override
    public void showMessage(int msg) {
        ToastUtils.SHORT.show(msg);
    }

    @OnClick(R.id.errorView)
    public abstract void onErrorViewClick();
}
