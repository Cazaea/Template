package com.hxd.lease.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.hxd.lease.R;
import com.hxd.lease.base.baseadapter.BaseRecyclerViewAdapter;
import com.hxd.lease.base.baseadapter.BaseRecyclerViewHolder;
import com.hxd.lease.databinding.ItemEmptyBinding;

/**
 * Created by Cazaea on 2016/12/24.
 */

public class EmptyAdapter extends BaseRecyclerViewAdapter<String> {

    @NonNull
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(parent, R.layout.item_empty);
    }

    class ViewHolder extends BaseRecyclerViewHolder<String, ItemEmptyBinding> {

        public ViewHolder(ViewGroup parent, int item_empty) {
            super(parent, item_empty);
        }

        @Override
        public void onBindViewHolder(String object, int position) {
            binding.setString(object);
        }
    }
}
