package com.mobidevtask.ui.info_pokemon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mobidevtask.R;
import com.mobidevtask.ui.base.BaseActivity;

public class InfoPokemonActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pokemon);
    }

    @Override
    public void showFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(InfoPokemonFragment.FRAGMENT_TAG);
        if (fragment == null) {
            fragment = new InfoPokemonFragment();
            if (getIntent() != null) {
                long id = getIntent().getLongExtra(FULL_ITEM_ID_EXTRA, 0);
                ((InfoPokemonFragment) fragment).setItemId(id);
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.flContainter, fragment, InfoPokemonFragment.FRAGMENT_TAG).commit();
        }
    }

    public static Intent getStartIntent(@NonNull Context context, long pokemonId) {
        Intent intent = new Intent(context, InfoPokemonActivity.class);
        intent.putExtra(FULL_ITEM_ID_EXTRA, pokemonId);
        return intent;
    }

}
