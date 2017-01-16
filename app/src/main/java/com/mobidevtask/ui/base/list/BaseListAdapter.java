package com.mobidevtask.ui.base.list;

import android.support.v7.widget.RecyclerView;

import com.mobidevtask.ui.base.PaginateAdapterSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vyacheslav on 27.12.2016.
 */

public abstract class BaseListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements PaginateAdapterSupport {

    protected final int ITEM = 0, LOADING = 1;
    protected final BaseListItem LOADING_ITEM = new BaseListItem();
    private boolean isLoading = false;

    private List<BaseListItem> data;

    public void setData(List<BaseListItem> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public List<BaseListItem> getData() {
        return data;
    }

    public void clear() {
        this.data = new ArrayList<>();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (getData() != null)
            return getData().size();
        return 0;
    }

    @Override
    public void addMoreItems(List<BaseListItem> items) {
        for (BaseListItem item : items) {
            if (!getData().contains(item)) {
                getData().add(item);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (getData().get(position).equals(LOADING_ITEM)) {
            return LOADING;
        }
        return ITEM;
    }

    @Override
    public boolean isLoading() {
        return isLoading;
    }

    @Override
    public void showLoading() {
        if (!getData().contains(LOADING_ITEM)) {
            isLoading = true;
            getData().add(LOADING_ITEM);
            notifyItemInserted(getData().size() - 1);
        }
    }

    @Override
    public void hideLoading() {
        if (getData().contains(LOADING_ITEM)) {
            isLoading = false;
            int pos = getData().indexOf(LOADING_ITEM);
            getData().remove(LOADING_ITEM);
            notifyItemRemoved(pos);
        }
    }

}
