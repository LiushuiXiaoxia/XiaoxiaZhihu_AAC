package cn.mycommons.xiaoxiazhihu.biz.callback;

import cn.mycommons.xiaoxiazhihu.biz.pojo.response.BaseResponse;
import cn.mycommons.xiaoxiazhihu.core.log.AppLog;
import rx.Subscriber;

/**
 * SimpleSubscriber <br/>
 * Created by xiaqiulei on 2015-10-22.
 */
public class SimpleSubscriber<T extends BaseResponse> extends Subscriber<T> {

    private boolean isSuccess = false; // 是否成功
    private T response; // 得到的数据结果

    @Override
    public void onStart() {
        super.onStart();
        AppLog.d(this + "....onStart");
    }

    @Override
    public final void onNext(T response) {
        AppLog.d(this + "....onNext");

        if (response == null) {
            AppLog.e("response is null.");
            return;
        }
        if (response.isSuccess()) {
            isSuccess = true;
            onHandleSuccess(response);
        } else {
            onHandleFail(response.getErrorMsg(), null);
        }
    }

    @Override
    public final void onError(Throwable throwable) {
        AppLog.d(this + "....onError");
        onHandleFail(null, throwable);

        onHandleFinish();
    }

    @Override
    public final void onCompleted() {
        AppLog.d(this + "....onCompleted");

        onHandleFinish();
    }

    /**
     * 处理成功
     */
    public void onHandleSuccess(T response) {
        AppLog.d("response = " + response);
    }

    /**
     * 处理失败
     */
    public void onHandleFail(String message, Throwable throwable) {
        AppLog.d(this + "....onHandleFail");
        AppLog.e("message = %s ,throwable = %s", message, throwable);
    }

    /**
     * 处理结束
     */
    public void onHandleFinish() {
        AppLog.d(this + "....onHandleFinish");
    }

    public T getResponse() {
        return response;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}