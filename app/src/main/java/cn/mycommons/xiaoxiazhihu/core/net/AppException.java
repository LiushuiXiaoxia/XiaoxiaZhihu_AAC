package cn.mycommons.xiaoxiazhihu.core.net;

/**
 * AppException <br/>
 * Created by xiaqiulei on 2015-10-21.
 */
public class AppException extends Throwable {

    private final Throwable detailThrowable;

    public AppException(Throwable throwable) {
        super(throwable);
        this.detailThrowable = throwable;
    }

    public Throwable getDetailThrowable() {
        return detailThrowable;
    }

    @Override
    public String toString() {
        return "AppException{" +
                "detailThrowable=" + detailThrowable +
                '}';
    }
}