package com.hxd.lease.app;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.multidex.MultiDexApplication;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;

import i.am.lucky.http.HttpUtils;
import com.hxd.lease.utils.DebugUtil;
import com.thejoyrun.router.Router;

/*
 * @author Cazaea
 * @time 2017/11/22 22:22
 * @mail wistorm@sina.com
 * @description Inherit MultiDexApplication to implement subcontract processing
 *
 *                        ___====-_  _-====___
 *                  _--^^^#####//      \\#####^^^--_
 *               _-^##########// (    ) \\##########^-_
 *              -############//  |\^^/|  \\############-
 *            _/############//   (@::@)   \\############\_
 *           /#############((     \\//     ))#############\
 *          -###############\\    (oo)    //###############-
 *         -#################\\  / VV \  //#################-
 *        -###################\\/      \//###################-
 *       _#/|##########/\######(   /\   )######/\##########|\#_
 *       |/ |#/\#/\#/\/  \#/\##\  |  |  /##/\#/  \/\#/\#/\#| \|
 *       `  |/  V  V  `   V  \#\| |  | |/#/  V   '  V  V  \|  '
 *          `   `  `      `   / | |  | | \   '      '  '   '
 *                           (  | |  | |  )
 *                          __\ | |  | | /__
 *                         (vvv(VVV)(VVV)vvv)
 *
 *                           HERE BE DRAGONS
 *
 */

public class RootApplication extends MultiDexApplication {

    private static RootApplication sRootApplication;

    public static RootApplication getInstance() {
        return sRootApplication;
    }

    @SuppressWarnings("unused")
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        sRootApplication = this;
        // Logger工具初始化
        Logger.addLogAdapter(new AndroidLogAdapter());
        // 初始化路由框架
        Router.init(Constants.ROUTER_HEAD);
        Router.setHttpHost(Constants.ROUTER_WEBSITE);
        // 初始化网络工具
        HttpUtils.getInstance().init(this, DebugUtil.DEBUG);
        // 加载内存优化检查工具
        LeakCanary.install(this);
        // 初始化Bugly强制更新
        CrashReport.initCrashReport(getApplicationContext(), "3977b2d86f", DebugUtil.DEBUG);
        // 不跟随系统更改字体大小
        initTextSize();
    }

    /**
     * Make its system change the font size invalid
     */
    private void initTextSize() {
        Resources res = getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

}
