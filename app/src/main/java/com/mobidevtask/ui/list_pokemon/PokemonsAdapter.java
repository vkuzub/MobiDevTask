package com.mobidevtask.ui.list_pokemon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobidevtask.R;
import com.mobidevtask.network.pojo.PokemonItem;
import com.mobidevtask.ui.base.list.BaseListAdapter;
import com.mobidevtask.utils.CommonDataExtractUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PokemonsAdapter extends BaseListAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view;
        switch (viewType) {
            case ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
                holder = new ViewHolder(view);
                break;
            case LOADING:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
                holder = new ViewHolderLoading(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case ITEM:
                PokemonItem item = (PokemonItem) getData().get(position);
                ViewHolder castedHolder = (ViewHolder) holder;
                castedHolder.tvName.setText(CommonDataExtractUtils.getStringValue(item.getName()));
                break;
            case LOADING:

                break;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class ViewHolderLoading extends RecyclerView.ViewHolder {
        ViewHolderLoading(View view) {
            super(view);
        }
    }

}
