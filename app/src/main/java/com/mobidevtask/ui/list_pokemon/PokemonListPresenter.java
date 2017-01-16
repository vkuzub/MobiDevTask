package com.mobidevtask.ui.list_pokemon;

import com.mobidevtask.ui.base.HideShowContentSupport;
import com.mobidevtask.ui.base.list.BaseListPresenter;

import java.util.HashMap;
import java.util.Map;

import static com.mobidevtask.utils.RxUtils.applySchedulers;

/**
 * Created by Vyacheslav on 16.01.2017.
 */

public class PokemonListPresenter extends BaseListPresenter<PokemonListMVP.View> {

    @Override
    public void loadData(boolean pullToRefresh, boolean paginate) {
        if (isViewAttached()) {
            showLoading(pullToRefresh, paginate);

            rxAddSubscription(getClient()
                    .loadPokemonsList(createQueries(EVENTS_LIMIT, getCurrentPage() * EVENTS_LIMIT)).compose(applySchedulers())
                    .subscribe(pokemonsResponse -> {
                                onLoadDataSuccess(pokemonsResponse, pullToRefresh, paginate);
                            },
                            throwable -> {
                                ((HideShowContentSupport) getView()).showError(null);
                                throwable.printStackTrace();
                            },
                            () -> {
                            }));
        }
    }

    @Override
    public Map<String, String> createQueries(int limit, int page) {
        HashMap<String, String> query = new HashMap<>();
        query.put("limit", String.valueOf(limit));
        query.put("offset", String.valueOf(page));
        return query;
    }

}
