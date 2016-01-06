package cn.mycommons.xiaoxiazhihu.core.process;

/**
 * IProcess <br/>
 * Created by xiaqiulei on 2015-08-12.
 */
public interface IProcess<P> {

    void process(String key, P param);
}