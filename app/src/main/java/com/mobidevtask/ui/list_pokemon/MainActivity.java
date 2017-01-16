package com.mobidevtask.ui.list_pokemon;

import android.os.Bundle;

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

    }
}
