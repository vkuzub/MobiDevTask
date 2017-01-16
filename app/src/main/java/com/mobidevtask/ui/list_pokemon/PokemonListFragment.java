package com.mobidevtask.ui.list_pokemon;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mobidevtask.R;
import com.mobidevtask.ui.base.list.BaseListPresenter;
import com.mobidevtask.ui.base.list.BaseMVPListFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class PokemonListFragment extends BaseMVPListFragment<PokemonListMVP.View> {

    public static final String FRAGMENT_TAG = "products_new";

    public PokemonListFragment() {
        // Required empty public constructor
    }

    @Override
    public BaseListPresenter<PokemonListMVP.View> createPresenter() {
        return new PokemonListPresenter();
    }

    @Override
    public void initAdapter() {
        adapter = new PokemonsAdapter();
    }

    @Override
    public void onRvItemClick(RecyclerView recyclerView, int position, View v) {

    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_pokemon_list;
    }
}
