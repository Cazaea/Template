package com.hxd.lease.bean.mine;

import android.databinding.BaseObservable;

/**
 * 作 者： Cazaea
 * 日 期： 2018/8/24
 * 邮 箱： wistorm@sina.com
 */
public class UpdateBean extends BaseObservable {

    /**
     * code : 1000
     * msg : 成功
     * data : {"url":"https://itunes.apple.com/us/app/id1383543751"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * url : https://itunes.apple.com/us/app/id1383543751
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
