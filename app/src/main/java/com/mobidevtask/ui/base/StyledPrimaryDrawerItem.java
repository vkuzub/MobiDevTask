package com.mobidevtask.ui.base;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mobidevtask.R;

/**
 * Created by Vyacheslav on 19.09.2016.
 */
public class StyledPrimaryDrawerItem extends PrimaryDrawerItem {

    public StyledPrimaryDrawerItem() {
        super();
        withTextColorRes(android.R.color.white).
                withSelectedTextColorRes(R.color.colorPrimary).
                withSelectedIconColorRes(R.color.colorPrimary).
                withIconColorRes(android.R.color.white).
                withIconTintingEnabled(true);
    }
}
