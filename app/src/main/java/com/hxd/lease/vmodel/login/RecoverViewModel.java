package com.hxd.lease.vmodel.login;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.text.TextUtils;

import com.hxd.lease.app.Constants;
import com.hxd.lease.base.BaseActivity;
import com.hxd.lease.bean.CommonBean;
import com.hxd.lease.http.HttpClient;
import com.hxd.lease.utils.ToastUtil;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Cazaea
 * @data 2018/5/7
 * @Description
 */

public class RecoverViewModel extends ViewModel {

    public final ObservableField<String> account = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();
    public final ObservableField<String> code = new ObservableField<>();
    public final ObservableField<String> referee_tel = new ObservableField<>();

    public final ObservableField<String> phone = new ObservableField<>();

    @SuppressLint("StaticFieldLeak")
    private BaseActivity activity;
    private LoginNavigator navigator;

    public RecoverViewModel(BaseActivity activity) {
        this.activity = activity;
    }

    public void setNavigator(LoginNavigator navigator) {
        this.navigator = navigator;
    }

    /**
     * 获取验证码
     */
    public void getCode() {
        if (!verifyPhoneInfo()) {
            return;
        }
        Subscription subscribe = HttpClient.Builder.getBaseService().getCode(phone.get(), Constants.CODE_TYPE_RECOVER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommonBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(CommonBean bean) {
                        if (bean != null && bean.getData() != null && bean.getCode() == 1000) {
                            ToastUtil.showShort(bean.getMsg());
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
    public void recover() {
        if (!verifyRecoverInfo()) {
            return;
        }
        Subscription subscribe = HttpClient.Builder.getBaseService().findPsw(account.get(), code.get(), password.get())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommonBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(CommonBean bean) {
                        if (bean != null && bean.getData() != null && bean.getCode() == 1000) {
                            ToastUtil.showShort(bean.getMsg());
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
     * 获取验证码验证
     *
     * @return 是否满足操作
     */
    private boolean verifyPhoneInfo() {
        if (TextUtils.isEmpty(phone.get())) {
            ToastUtil.showShort("请输入手机号");
            return false;
        }
        return true;
    }

    /**
     * 验证注册内容
     *
     * @return 是否满足操作
     */
    private boolean verifyRecoverInfo() {
        if (TextUtils.isEmpty(account.get())) {
            ToastUtil.showShort("请输入账号");
            return false;
        }
        if (TextUtils.isEmpty(code.get())) {
            ToastUtil.showShort("请输入验证码");
            return false;
        }
        if (TextUtils.isEmpty(password.get())) {
            ToastUtil.showShort("请输入新密码");
            return false;
        }
        return true;
    }

    public void onDestroy() {
        navigator = null;
    }
}
