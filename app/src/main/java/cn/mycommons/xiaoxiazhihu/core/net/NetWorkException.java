package cn.mycommons.xiaoxiazhihu.core.net;

/**
 * NetWorkException <br/>
 * Created by xiaqiulei on 2015-10-21.
 */
public class NetWorkException extends Throwable {

    private Throwable detailThrowable;

    public NetWorkException(Throwable throwable) {
        super(throwable);
        this.detailThrowable = throwable;
    }

    public Throwable getDetailThrowable() {
        return detailThrowable;
    }

    @Override
    public String toString() {
        return "NetWorkException{" +
                "detailThrowable=" + detailThrowable +
                '}';
    }
}