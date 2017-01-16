package com.mobidevtask.ui.list_pokemon;

import com.mobidevtask.R;
import com.mobidevtask.network.pojo.PokemonItem;
import com.mobidevtask.ui.base.HideShowContentSupport;
import com.mobidevtask.ui.base.list.BaseListPresenter;

import static com.mobidevtask.utils.RxUtils.applySchedulers;


public class PokemonListPresenter extends BaseListPresenter<PokemonListMVP.View> {

    @Override
    public void loadData(boolean pullToRefresh, boolean paginate) {
        if (isViewAttached()) {
            showLoading(pullToRefresh, paginate);

            rxAddSubscription(getClient()
                    .loadPokemonsList(createQueries(EVENTS_LIMIT, getCurrentPage() * EVENTS_LIMIT))
                    .map(pokemonsResponse -> {
                        for (PokemonItem item : pokemonsResponse.getResults()) {
                            String[] split = item.getUrl().split("/");
                            long urlId = Long.parseLong(split[split.length - 1]);
                            item.setUrlId(urlId);
                        }
                        return pokemonsResponse;
                    })
                    .compose(applySchedulers())
                    .subscribe(pokemonsResponse -> {
                                onLoadDataSuccess(pokemonsResponse, pullToRefresh, paginate);
                            },
                            throwable -> {
                                ((HideShowContentSupport) getView()).showError(R.string.oops_something_went_wrong);
                            },
                            () -> {
                            }));
        }
    }

}
