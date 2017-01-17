package com.mobidevtask.ui.list_pokemon;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mobidevtask.R;
import com.mobidevtask.network.pojo.PokemonItem;
import com.mobidevtask.ui.base.list.BaseListPresenter;
import com.mobidevtask.ui.base.list.BaseMVPListFragment;
import com.mobidevtask.ui.info_pokemon.InfoPokemonActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class PokemonListFragment extends BaseMVPListFragment<PokemonListMVP.View> implements PokemonListMVP.View {

    public static final String FRAGMENT_TAG = "pokemon_list";

    @Override
    public BaseListPresenter<PokemonListMVP.View> createPresenter() {
        return new PokemonListPresenter();
    }

    @Override
    public void initAdapter() {
        if (adapter == null)
            adapter = new PokemonsAdapter();
    }

    @Override
    public void onRvItemClick(RecyclerView recyclerView, int position, View v) {
        if (position != -1) {
            PokemonItem item = (PokemonItem) adapter.getData().get(position);
            startActivity(InfoPokemonActivity.getStartIntent(getActivity(), item.getUrlId()));
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_pokemon_list;
    }
}
