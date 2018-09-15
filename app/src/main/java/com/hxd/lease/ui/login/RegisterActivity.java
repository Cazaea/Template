package com.hxd.lease.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hxd.lease.R;
import com.hxd.lease.base.BaseActivity;
import com.hxd.lease.databinding.ActivityRegisterBinding;
import com.hxd.lease.vmodel.login.LoginNavigator;
import com.hxd.lease.vmodel.login.RegisterViewModel;
import com.thejoyrun.router.RouterActivity;

/**
 * @author Cazaea
 */
@RouterActivity("register")
public class RegisterActivity extends BaseActivity<ActivityRegisterBinding> implements LoginNavigator {

    private RegisterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("注册");
        showContentView();

        viewModel = new RegisterViewModel(this);
        viewModel.setNavigator(this);
        bindingView.setRegister(viewModel);
    }

    public void register(View view) {
        viewModel.register();
    }

    /**
     * 注册或登录成功
     */
    @Override
    public void loadSuccess() {
        finish();
    }

    public static void start(Context mContext) {
        Intent intent = new Intent(mContext, RegisterActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
    }

}
