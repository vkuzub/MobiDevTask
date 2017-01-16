package com.mobidevtask.ui.list_pokemon;

import com.mobidevtask.ui.base.list.BaseListMVP;

/**
 * Created by Vyacheslav on 16.01.2017.
 */

public interface PokemonListMVP {

    interface View extends BaseListMVP.View {

    }

    interface Presenter extends BaseListMVP.Presenter<PokemonListMVP.View> {

    }

}
