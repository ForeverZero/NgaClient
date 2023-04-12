package org.zhd.ngaclient.util;

import java.sql.Time;

public class TimeUtil {
    private TimeUtil() {

    }

    public static String getTimeStr() {
        return (System.currentTimeMillis() / 1000) + "";
    }
}
