package cn.mycommons.xiaoxiazhihu.biz.pojo.response;

import com.google.gson.annotations.SerializedName;

/**
 * BaseResponse <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class BaseResponse implements IResponse {

    @SerializedName("status")
    private int status;

    @SerializedName("error_msg")
    private String errorMsg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    public boolean isSuccess() {
        return status == 0;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}