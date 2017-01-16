package com.mobidevtask.ui.base;


import com.mobidevtask.ui.base.list.BaseListItem;

import java.util.List;



public interface PaginateAdapterSupport {

    void addMoreItems(List<BaseListItem> items);

    boolean isLoading();

    void showLoading();

    void hideLoading();
}
