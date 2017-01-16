package com.mobidevtask.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mobidevtask.R;

import butterknife.BindView;
import butterknife.ButterKnife;



public abstract class BaseActivity extends AppCompatActivity {

    public static final String FULL_ITEM_ID_EXTRA = "full_id";
    @BindView(R.id.toolbar)
    @Nullable
    Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public void initToolBar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        initToolBar();
        showFragment();
    }

    public abstract void showFragment();

}
