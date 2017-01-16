package com.mobidevtask.ui.base;

import rx.Subscription;



public interface RxSupport {

    void rxUnsubscribe();

    void rxAddSubscription(Subscription sub);

    void initRxSubscriptions();
}
