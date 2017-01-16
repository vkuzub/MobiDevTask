package com.mobidevtask.ui.list_pokemon;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.mobidevtask.R;
import com.mobidevtask.ui.base.DrawerActivity;

public class MainActivity extends DrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return POKEMONS_ACTIVITY;
    }

    @Override
    public void showFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(PokemonListFragment.FRAGMENT_TAG);
        if (fragment == null) {
            fragment = new PokemonListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainter, fragment, PokemonListFragment.FRAGMENT_TAG)
                    .commit();
        }
    }
}
