package com.hxd.lease.app;

/**
 * Created by Cazaea on 2016/11/26.
 * 固定参数
 */

public class Constants {

    /**
     * 路由配置信息
     */
    public static final String ROUTER_HEAD = "lease";
    public static final String ROUTER_TOTAL_HEAD = "lease://";
    public static final String ROUTER_WEBSITE = "www.lease.com";

    /**
     * 验证码类型
     * 0 注册 1修改密码 2找回密码 3付款 4绑定银行卡
     */
    public static final String CODE_TYPE_REGISTER = "0";
    public static final String CODE_TYPE_MODIFY = "1";
    public static final String CODE_TYPE_RECOVER = "2";
    public static final String CODE_TYPE_PAY = "3";
    public static final String CODE_TYPE_BIND = "4";

    /**
     * App Skin Theme
     */
    public static final String NIGHT_SKIN = "night.skin";
    public static final String KEY_MODE_NIGHT = "mode-night";

    // 是否登录
    public static String IS_LOGIN = "is_login";

    // 热映缓存
    public static String ONE_HOT_MOVIE = "one_hot_movie";
    // 保存每日推荐轮播图url
    public static String BANNER_PIC = "banner_pic";
    // 保存每日推荐轮播图的跳转数据
    public static String BANNER_PIC_DATA = "banner_pic_data";
    // 保存每日推荐RecyclerView内容
    public static String EVERYDAY_CONTENT = "everyday_content";
    // 干货订制类别
    public static String GANK_CALA = "gank_cala";

}
