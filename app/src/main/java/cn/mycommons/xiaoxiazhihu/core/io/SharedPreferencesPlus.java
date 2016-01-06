package cn.mycommons.xiaoxiazhihu.core.io;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

import cn.mycommons.xiaoxiazhihu.BuildConfig;
import cn.mycommons.xiaoxiazhihu.core.log.XLog;

/**
 * 帮助存取SharedPreferences,支持obj存取，obj是使用gson序列化的 <br/>
 * 同时提供在保存数据时候，可以保存app的版本
 *
 * @see SharedPreferencesPlus#putVersion(String)
 */
public class SharedPreferencesPlus {

    static final String KEY_VERION_POSTFIX = "___version";

    private SharedPreferences sp;

    private Gson gson;

    public SharedPreferencesPlus(Context context, String name) {
        sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    // 生成一个key对应版本的key
    private String generateVersionKey(String key) {
        return key + KEY_VERION_POSTFIX;
    }

    public String getString(String key) {
        return getString(key, "");
    }

    public String getString(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    public boolean putString(String key, String content) {
        return sp.edit().putString(key, content).commit();
    }

    public int getInt(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {
        return sp.getLong(key, defValue);
    }

    public boolean putInt(String key, int value) {
        return sp.edit().putInt(key, value).commit();
    }

    public boolean putLong(String key, long value) {
        return sp.edit().putLong(key, value).commit();
    }

    public boolean remove(String key) {
        return sp.edit().remove(key).remove(generateVersionKey(key)).commit();
    }


    public boolean putBoolean(String key, boolean value) {
        return sp.edit().putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    /**
     * 保存对象,对象是以json字符串形式保存，如果对象是null，则保存为null <br/>
     * 保存对象，暂时不处理对象的class类型
     *
     * @param key
     * @param object
     * @return
     */
    public boolean putObject(String key, Object object) {
        String json = null;
        if (object != null) {
            try {
                json = gson.toJson(object);
            } catch (Exception e) {
                String content = String.format("save (%s,%s) fail.", key, object);
                XLog.i(content);

                return false;
            }
        }

        return putString(key, json);
    }

    /**
     * 保存对象,对象是以json字符串形式保存，如果对象是null，则保存为null <br/>
     * 保存对象，暂时不处理对象的class类型<br>
     * 同时保存该对象保存时候，app的版本
     *
     * @param key
     * @param object
     * @return
     */
    public boolean putObjectWithVersion(String key, Object object) {
        boolean ret = putObject(key, object) && putVersion(key);
        return ret;
    }

    /**
     * 获取保存的对象，由于保存的时候是以json字符串保存，没有保存class类型，所以如果type与原先保存的对象的类型有冲突，结果返回是null
     *
     * @param key
     * @param type 对象的type，一般情况下是 object.class
     * @param <T>
     * @return
     */
    public <T> T getObject(String key, Type type) {

        T t = null;

        String string = getString(key);
        if (!TextUtils.isEmpty(string) && type != null) {
            try {
                t = gson.fromJson(string, type);
            } catch (Exception e) { // json解析出错
                String msg = String.format("get %s of %s fail", key, type);
                XLog.i(msg);
            }
        }

        return t;
    }

    /**
     * 提供键值对保存时保存版本 <br/>
     * key : value <br/>
     * key_version : version_code
     *
     * @param key
     * @return
     */
    public boolean putVersion(String key) {
        return putInt(generateVersionKey(key), BuildConfig.VERSION_CODE);
    }

    /**
     * 获取某个字段对应的版本，如没有则为-1
     *
     * @param key
     * @return
     */
    public int getObjectVersion(String key) {
        return getInt(generateVersionKey(key), -1);
    }
}