package cn.mycommons.xiaoxiazhihu.core.process;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Processor <br/>
 * Created by xiaqiulei on 2015-08-12.
 */
public class Processor<P> {

    public static class Build<P> extends ProcessHelper<P> {
    }

    private Map<String, ProcessItem<P>> map;

    private ProcessItem<P> defaultProcess;

    public Processor() {
        map = new ConcurrentHashMap<>();
    }

    public void put(String key, IProcess<P> value) {
        map.put(key, new ProcessItem<P>(key).setProcess(value));
    }

    public void put(String key, Class<IProcess<P>> value) {
        map.put(key, new ProcessItem<P>(key).setProcess(value, false));
    }

    public ProcessItem<P> put(String key, ProcessItem<P> value) {
        return map.put(key, value);
    }

    public void setDefaultProcess(ProcessItem<P> defaultProcess) {
        this.defaultProcess = defaultProcess;
    }

    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    public void remove(Object key) {
        map.remove(key);
    }

    public ProcessItem<P> get(String key) {
        return map.get(key);
    }

    /**
     * 进行处理
     *
     * @param key
     * @param param
     * @return
     */
    public boolean process(String key, P param) {
        ProcessItem<P> item = map.get(key);
        if (item != null) {
            item.doProcess(param);
        }
        return item != null;
    }

    /**
     * 进行默认处理
     *
     * @param param
     * @return
     */
    public boolean processDefalut(P param) {
        if (defaultProcess != null) {
            defaultProcess.doProcess(param);
        }
        return defaultProcess != null;
    }

    public void clear() {
        map.clear();
    }
}