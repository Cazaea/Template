package com.hxd.lease.ui.slider;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hxd.lease.R;
import com.hxd.lease.databinding.ActivityNavHomePageBinding;
import com.hxd.lease.utils.ShareUtils;

public class NavHomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNavHomePageBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_nav_home_page);
        // 解决7.0以上系统 滑动到顶部 标题裁减一半的问题
        setSupportActionBar(binding.detailToolbar);

        binding.fabShare.setOnClickListener(v -> ShareUtils.share(v.getContext(), R.string.string_share_text));
    }

    public static void startHome(Context mContext) {
        Intent intent = new Intent(mContext, NavHomePageActivity.class);
        mContext.startActivity(intent);
    }
}
