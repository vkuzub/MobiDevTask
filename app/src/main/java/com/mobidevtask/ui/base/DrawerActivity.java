package com.mobidevtask.ui.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mobidevtask.R;
import com.mobidevtask.ui.list_pokemon.MainActivity;

import butterknife.ButterKnife;



public abstract class DrawerActivity extends BaseActivity implements Drawer.OnDrawerListener {

    private static final int NAVDRAWER_LAUNCH_DELAY = 250;
    private static final int MAIN_CONTENT_FADEOUT_DURATION = 150;

    public static final int UNKNOWN_ACTIVITY = -1;
    public static final int PROFILE_ACTIVITY = 0;
    public static final int POKEMONS_ACTIVITY = 1;
    public static final int BERRIES_PRODUCTS_ACTIVITY = 2;


    public static final int LOGIN_ACTIVITY = 100;
    public static final int QUIT_ACTIVITY = 1000;

    public static final int SERVICE_LEVEL = 2;

    public static final int SERVICE_DRAWER_ITEM = 111;
    public static final int LOGOUT_DRAWER_ITEM = 112;

    private Drawer drawer;

    private Handler handler;
    private AccountHeader headerResult;

    private PrimaryDrawerItem pokemonsDrawerItem;
    private PrimaryDrawerItem berriesDrawerItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler();

        if (getSelfNavDrawerItem() != POKEMONS_ACTIVITY) {
            overridePendingTransition(0, 0);
        }
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initializeDrawer();
    }

    protected abstract int getSelfNavDrawerItem();

    Drawer.OnDrawerItemClickListener OnDrawerItemClickListenerImpl = new Drawer.OnDrawerItemClickListener() {
        @Override
        public boolean onItemClick(View view, final int position, final IDrawerItem drawerItem) {
            //close drawer if selected same activity
            if (drawerItem.getIdentifier() == getSelfNavDrawerItem()) {
                drawer.closeDrawer();
                return true;
            }

            // if selected drawer list should not open new activity, do not fade maincontent
            final int identifier = Long.valueOf(drawerItem.getIdentifier()).intValue();

            if (isSpecialItem(identifier)) {
                goToNavDrawerItem(identifier);
            } else {
                handler.postDelayed(() -> goToNavDrawerItem(identifier), NAVDRAWER_LAUNCH_DELAY);

                View mainContent = ButterKnife.findById(DrawerActivity.this, R.id.mainContent);
                if (mainContent != null) {
                    mainContent.animate().alpha(0).setDuration(MAIN_CONTENT_FADEOUT_DURATION);
                }
            }
            return true;
        }
    };

    private void initializeDrawer() {
        initializeDrawerItems();
        initializeDrawerHeader();

        drawer = new DrawerBuilder(this).
                withToolbar(mToolbar).
                withActionBarDrawerToggleAnimated(true).
                withSliderBackgroundColor(ContextCompat.getColor(this, R.color.primary)).
                addDrawerItems(
                        pokemonsDrawerItem,
                        berriesDrawerItem
                ).
                withOnDrawerListener(this).
                withAccountHeader(headerResult).
                withOnDrawerItemClickListener(OnDrawerItemClickListenerImpl).
                build();

        drawer.setSelection(getSelfNavDrawerItem(), false);

    }

    private boolean isSpecialItem(int itemId) {
        return itemId == SERVICE_DRAWER_ITEM || itemId == LOGOUT_DRAWER_ITEM;
    }

    public boolean isDrawerOpened() {
        return drawer.isDrawerOpen();
    }

    private void initializeDrawerItems() {

        pokemonsDrawerItem =
                new StyledPrimaryDrawerItem().
                        withName(R.string.pokemons).
                        withIdentifier(POKEMONS_ACTIVITY);

        berriesDrawerItem =
                new StyledPrimaryDrawerItem().
                        withName(R.string.berries).
                        withEnabled(false).
                        withIdentifier(UNKNOWN_ACTIVITY);

    }

    private void initializeDrawerHeader() {
        IProfile profile = new ProfileDrawerItem()
                .withName(getString(R.string.app_name))
                .withIcon(R.drawable.avatar_placeholder);

        AccountHeaderBuilder builder = new AccountHeaderBuilder().
                withActivity(this).
                withCompactStyle(true).
                withTranslucentStatusBar(true).
                addProfiles(profile);
        headerResult = builder.build();

    }

    private void goToNavDrawerItem(int item) {
        if (drawer != null) {
            drawer.closeDrawer();
        }
        switch (item) {
            case PROFILE_ACTIVITY:
                break;
            case LOGIN_ACTIVITY:
                break;
            case BERRIES_PRODUCTS_ACTIVITY:

                break;
            case POKEMONS_ACTIVITY:
                createBackStack(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }

    private void createBackStack(Intent intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            TaskStackBuilder builder = TaskStackBuilder.create(this);
            builder.addNextIntentWithParentStack(intent);
            builder.startActivities();
        } else {
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

}
