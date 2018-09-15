package com.hxd.lease.data.room;

import com.hxd.lease.utils.AppExecutors;

/**
 * @author Cazaea
 * @data 2018/4/19
 * @Description
 */

public class Injection {

    public static UserDataBaseSource get() {
        UserDataBase database = UserDataBase.getDatabase();
        return UserDataBaseSource.getInstance(new AppExecutors(), database.waitDao());
    }

}
