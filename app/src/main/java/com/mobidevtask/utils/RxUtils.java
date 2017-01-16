package com.mobidevtask.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class RxUtils {

    private static final Observable.Transformer schedulersTransformer =
            obj -> ((Observable) obj).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());


    @SuppressWarnings("unchecked")
    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable.Transformer<T, T>) schedulersTransformer;
    }

}
