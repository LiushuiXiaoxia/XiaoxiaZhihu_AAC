package cn.mycommons.xiaoxiazhihu.core.process;

/**
 * ProcessHelper <br/>
 * Created by xiaqiulei on 2015-08-12.
 */
public class ProcessHelper<P> {

    private Processor<P> processor;

    public ProcessHelper() {
        processor = new Processor();
    }

    public ProcessHelper<P> addProcess(String key, IProcess<P> process) {
        processor.put(key, process);
        return this;
    }

    public ProcessHelper<P> addProcess(String key, Class<IProcess<P>> processClass) {
        processor.put(key, processClass);
        return this;
    }


    public ProcessHelper<P> setDefaultProcess(IProcess<P> process) {
        setDefaultProcess(new ProcessItem<P>(null).setProcess(process));
        return this;
    }

    public ProcessHelper<P> setDefaultProcess(Class<IProcess<P>> process) {
        setDefaultProcess(new ProcessItem<P>(null).setProcess(process, false));
        return this;
    }

    public ProcessHelper<P> setDefaultProcess(ProcessItem<P> process) {
        processor.setDefaultProcess(process);
        return this;
    }

    public Processor<P> build() {
        return processor;
    }
}