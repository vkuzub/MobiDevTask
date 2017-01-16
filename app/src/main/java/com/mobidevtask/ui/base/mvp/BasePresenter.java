package com.mobidevtask.ui.base.mvp;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mobidevtask.network.Client;
import com.mobidevtask.network.ServiceGenerator;
import com.mobidevtask.ui.base.RxSupport;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Vyacheslav on 26.12.2016.
 */

public class BasePresenter<V extends MvpView> extends MvpBasePresenter<V> implements RxSupport {

    private CompositeSubscription compositeSubscription;
    private Client client;

    @Override
    public void attachView(V view) {
        super.attachView(view);
        client = ServiceGenerator.createService(Client.class);
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        client = null;

    }

    public Client getClient() {
        return client;
    }

    @Override
    public void rxUnsubscribe() {
        compositeSubscription.unsubscribe();
    }

    @Override
    public void rxAddSubscription(Subscription sub) {
        compositeSubscription.add(sub);
    }

    @Override
    public void initRxSubscriptions() {

    }

}
