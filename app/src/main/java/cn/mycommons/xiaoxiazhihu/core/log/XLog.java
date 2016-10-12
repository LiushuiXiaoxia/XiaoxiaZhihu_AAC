package cn.mycommons.xiaoxiazhihu.core.log;

import android.util.Log;

/**
 * XLog <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class XLog {

    private static final String XIAOXIA_ZHIHU = "XiaoxiaZhihu";

    public static int v(String msg, Object... args) {
        String msgLocal = msg;
        if (args != null && args.length != 0) {
            msgLocal = String.format(msg, args);
        }
        return Log.v(XIAOXIA_ZHIHU, msgLocal);
    }

    public static int d(String msg, Object... args) {
        String msgLocal = msg;
        if (args != null && args.length != 0) {
            msgLocal = String.format(msg, args);
        }
        return Log.d(XIAOXIA_ZHIHU, msgLocal);
    }

    public static int i(String msg, Object... args) {
        String msgLocal = msg;
        if (args != null && args.length != 0) {
            msgLocal = String.format(msg, args);
        }
        return Log.i(XIAOXIA_ZHIHU, msgLocal);
    }

    public static int w(String msg, Object... args) {
        String msgLocal = msg;
        if (args != null && args.length != 0) {
            msgLocal = String.format(msg, args);
        }
        return Log.w(XIAOXIA_ZHIHU, msgLocal);
    }

    public static int w(Throwable tr) {
        return Log.w(XIAOXIA_ZHIHU, tr);
    }

    public static int e(String msg, Object... args) {
        String msgLocal = msg;
        if (args != null && args.length != 0) {
            msgLocal = String.format(msg, args);
        }
        return Log.e(XIAOXIA_ZHIHU, msgLocal);
    }

    public static int e(String msg, Throwable tr) {
        return Log.e(XIAOXIA_ZHIHU, msg, tr);
    }

    private XLog() {
    }
}