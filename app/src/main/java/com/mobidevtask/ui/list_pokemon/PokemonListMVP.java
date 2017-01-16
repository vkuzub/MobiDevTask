package com.mobidevtask.ui.list_pokemon;

import com.mobidevtask.ui.base.list.BaseListMVP;



public interface PokemonListMVP {

    interface View extends BaseListMVP.View {

    }

    interface Presenter extends BaseListMVP.Presenter<PokemonListMVP.View> {

    }

}
