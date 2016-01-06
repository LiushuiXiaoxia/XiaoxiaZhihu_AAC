package cn.mycommons.xiaoxiazhihu.business.callback;

import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.app.AppContext;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;
import cn.mycommons.xiaoxiazhihu.core.log.XLog;
import cn.mycommons.xiaoxiazhihu.core.net.NetWorkException;

/**
 * 业务层建议使用这个，可以抓取到日志
 * <p/>
 * AdvancedSubscriber <br/>
 * Created by xiaqiulei on 2015-10-22.
 */
public class AdvancedSubscriber<T extends BaseResponse> extends SimpleSubscriber<T> {

    @Override
    public void onHandleSuccess(T response) {
        XLog.i("response = " + response);
    }

    @Override
    public void onHandleFail(String message, Throwable throwable) {
        super.onHandleFail(message, throwable);

        if (message != null) { // 业务异常
            doHandleBusinessFail(message);
        } else if (throwable != null) { // 运行异常
            doHandleException(throwable);
        } else { // 未知异常
            XLog.i("AdvancedSubscriber.onHandleFail message = null, e = null");
        }
    }

    private void doHandleBusinessFail(String msg) {
        XLog.d(this + "....doHandleBusinessFail");
        if (TextUtils.isEmpty(msg)) {
            showToast("未知错误");
        } else {
            showToast(msg);
        }
    }

    private void doHandleException(Throwable throwable) {
        XLog.d(this + "....doHandleException");
        if (throwable != null) {
            XLog.e("AdvancedSubscriber.doHandleException throwable = " + throwable.getMessage(), throwable);
        }

        String toastText = null;
        if (throwable instanceof NetWorkException) {
            NetWorkException netWorkException = (NetWorkException) throwable;
            Throwable detailException = netWorkException.getDetailThrowable();
            if (detailException instanceof ConnectException) {
                toastText = "Connect Fail";
            } else if (detailException instanceof UnknownHostException) {
                toastText = "Unknown Host";
            } else if (detailException instanceof TimeoutException || detailException instanceof InterruptedIOException) {
                toastText = "Time out";
            } else if (detailException instanceof JSONException) {
                toastText = "Json error";
            } else if (detailException instanceof JsonParseException) {
                toastText = "Gson parse error";
            }
        }
        if (TextUtils.isEmpty(toastText)) {
            showToast(R.string.network_disable);
        } else {
            showToast("[" + toastText + "]");
        }
    }


    protected void showToast(int msg) {
        showToast(AppContext.getInstance().getString(msg));
    }

    protected void showToast(String msg) {
        XLog.d("showToast = " + msg);
        Toast.makeText(AppContext.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }
}