package cn.mycommons.xiaoxiazhihu.business.api.impl.retrofit;

import cn.mycommons.xiaoxiazhihu.core.net.NetWorkException;

/**
 * RetrofitAdapter <br/>
 * Created by xiaqiulei on 2016-01-10.
 */
public abstract class RetrofitAdapter<T> {

    abstract T call() throws Exception;

    protected T get() throws NetWorkException {
        T t;
        try {
            t = call();
        } catch (Exception e) {
            throw new NetWorkException(e);
        }
        return t;
    }
}