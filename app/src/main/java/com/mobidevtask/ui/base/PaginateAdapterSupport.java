package com.mobidevtask.ui.base;


import com.mobidevtask.ui.base.list.BaseListItem;

import java.util.List;

/**
 * Created by Vyacheslav on 14.11.2016.
 */

public interface PaginateAdapterSupport {

    void addMoreItems(List<BaseListItem> items);

    boolean isLoading();

    void showLoading();

    void hideLoading();
}
