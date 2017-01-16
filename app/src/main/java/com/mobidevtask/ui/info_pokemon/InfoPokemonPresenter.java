package com.mobidevtask.ui.info_pokemon;

import com.mobidevtask.R;
import com.mobidevtask.ui.base.fullinfo.BaseFullInfoPresenter;

import static com.mobidevtask.utils.RxUtils.applySchedulers;



public class InfoPokemonPresenter extends BaseFullInfoPresenter<InfoPokemonMVP.View> {

    @Override
    public void loadData(long id) {
        if (isViewAttached()) {

            getView().showLoading();

            rxAddSubscription(getClient().loadPokemonById(id).compose(applySchedulers()).subscribe(
                    o -> {
                        onDataLoadSuccess(o);
                    },
                    throwable -> {
                        getView().showError(R.string.oops_something_went_wrong);
                        throwable.printStackTrace();
                    },
                    () -> {
                    }
            ));
        }
    }
}
