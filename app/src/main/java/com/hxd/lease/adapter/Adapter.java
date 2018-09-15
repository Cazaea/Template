package com.hxd.lease.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.hxd.lease.R;
import com.hxd.lease.base.baseadapter.BaseRecyclerViewAdapter;
import com.hxd.lease.base.baseadapter.BaseRecyclerViewHolder;
import com.hxd.lease.databinding.ItemListBinding;

/**
 * Template Adapter
 * Created by Cazaea on 2016/11/30.
 */
public class Adapter extends BaseRecyclerViewAdapter<String> {

    @NonNull
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(parent, R.layout.item_list);
    }

    class ViewHolder extends BaseRecyclerViewHolder<String, ItemListBinding> {

        public ViewHolder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(String object, int position) {
            binding.tvText.setText("测试:  " + object);
        }
    }
}
