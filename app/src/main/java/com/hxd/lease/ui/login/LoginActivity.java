package com.hxd.lease.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hxd.lease.R;
import com.hxd.lease.base.BaseActivity;
import com.hxd.lease.databinding.ActivityLoginBinding;
import com.hxd.lease.vmodel.login.LoginNavigator;
import com.hxd.lease.vmodel.login.LoginViewModel;

/**
 * @author Cazaea
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements LoginNavigator {

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("登录");
        showContentView();

        viewModel = new LoginViewModel(this);
        viewModel.setNavigator(this);
        bindingView.setLogin(viewModel);
    }

    public void login(View view) {
        viewModel.login();
    }

    public void goRegister(View view) {
        viewModel.goRegister();
    }

    public void goRecover(View view) {
        viewModel.goRecover();
    }

    /**
     * 注册或登录成功
     */
    @Override
    public void loadSuccess() {
        finish();
    }

    /**
     * 进入页面
     *
     * @param mContext
     */
    public static void start(Context mContext) {
        Intent intent = new Intent(mContext, LoginActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
    }
}
