package com.hxd.lease.vmodel.login;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.text.TextUtils;

import com.hxd.lease.app.Constants;
import com.hxd.lease.base.BaseActivity;
import com.hxd.lease.bean.login.LoginBean;
import com.hxd.lease.data.UserUtil;
import com.hxd.lease.data.room.Injection;
import com.hxd.lease.http.HttpClient;
import com.hxd.lease.utils.ToastUtil;
import com.thejoyrun.router.Router;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Cazaea
 * @data 2018/5/7
 * @Description
 */

public class LoginViewModel extends ViewModel {

    public final ObservableField<String> account = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();

    @SuppressLint("StaticFieldLeak")
    private BaseActivity activity;
    private LoginNavigator navigator;

    public LoginViewModel(BaseActivity activity) {
        this.activity = activity;
    }

    public void setNavigator(LoginNavigator navigator) {
        this.navigator = navigator;
    }

    /**
     * 用户登录
     */
    public void login() {
        if (!verifyUserInfo()) {
            return;
        }
        Subscription subscribe = HttpClient.Builder.getBaseService().login(account.get(), password.get())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(LoginBean bean) {
                        if (bean != null && bean.getData() != null) {
                            Injection.get().addData(bean.getData());
                            UserUtil.handleLoginSuccess();
                            navigator.loadSuccess();
                        } else {
                            if (bean != null) {
                                ToastUtil.showLong(bean.getMsg());
                            }
                        }
                    }
                });
        activity.addSubscription(subscribe);
    }

    /**
     * 用户找回密码
     */
    public void goRecover() {
        Router.startActivity(activity, Constants.ROUTER_TOTAL_HEAD + "recover");
    }

    /**
     * 手机号快速注册
     */
    public void goRegister() {
        Router.startActivity(activity, Constants.ROUTER_TOTAL_HEAD + "register");
    }

    /**
     * 登录验证内容
     *
     * @return 是否满足操作
     */
    private boolean verifyUserInfo() {
        if (TextUtils.isEmpty(account.get())) {
            ToastUtil.showShort("请输入用户名");
            return false;
        }
        if (TextUtils.isEmpty(password.get())) {
            ToastUtil.showShort("请输入密码");
            return false;
        }
        return true;
    }

    public void onDestroy() {
        navigator = null;
    }
}
