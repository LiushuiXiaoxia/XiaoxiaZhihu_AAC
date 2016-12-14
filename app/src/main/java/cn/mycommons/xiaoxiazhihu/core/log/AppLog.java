package cn.mycommons.xiaoxiazhihu.core.log;

import android.util.Log;

/**
 * AppLog <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class AppLog {

    private static final String TAG = "XiaoxiaZhihu";

    public static int v(String msg, Object... args) {
        String msgLocal = msg;
        if (args != null && args.length != 0) {
            msgLocal = String.format(msg, args);
        }
        return Log.v(TAG, msgLocal);
    }

    public static int d(String msg, Object... args) {
        String msgLocal = msg;
        if (args != null && args.length != 0) {
            msgLocal = String.format(msg, args);
        }
        return Log.d(TAG, msgLocal);
    }

    public static int i(String msg, Object... args) {
        String msgLocal = msg;
        if (args != null && args.length != 0) {
            msgLocal = String.format(msg, args);
        }
        return Log.i(TAG, msgLocal);
    }

    public static int w(String msg, Object... args) {
        String msgLocal = msg;
        if (args != null && args.length != 0) {
            msgLocal = String.format(msg, args);
        }
        return Log.w(TAG, msgLocal);
    }

    public static int w(Throwable tr) {
        return Log.w(TAG, tr);
    }

    public static int e(String msg, Object... args) {
        String msgLocal = msg;
        if (args != null && args.length != 0) {
            msgLocal = String.format(msg, args);
        }
        return Log.e(TAG, msgLocal);
    }

    public static int e(String msg, Throwable tr) {
        return Log.e(TAG, msg, tr);
    }

    private AppLog() {
    }
}