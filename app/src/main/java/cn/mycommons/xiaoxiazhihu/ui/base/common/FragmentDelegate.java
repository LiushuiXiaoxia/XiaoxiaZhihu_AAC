package cn.mycommons.xiaoxiazhihu.ui.base.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import java.security.InvalidParameterException;

import cn.mycommons.xiaoxiazhihu.core.log.AppLog;

/**
 * Created by xiaqiulei on 14/11/20.
 */
class FragmentDelegate<F extends Fragment, P extends CommonExtraParam> {


    private P extraReqParam;
    private F fragment;

    FragmentDelegate(F f) {
        if (f == null) {
            throw new InvalidParameterException("fragment is null.");
        }
        this.fragment = f;
    }

    void beforeOnViewCreated(View view, Bundle savedInstanceState) {
        AppLog.i("beforeOnViewCreated");
    }

    void afterOnViewCreated(View view, Bundle savedInstanceState) {
        AppLog.i("afterOnViewCreated");

        extraReqParam = CommonExtraParam.getReqExtraParam(fragment.getActivity());

        String content = String.format("fragment = %s, extraReqParam = %s", fragment, extraReqParam);
        AppLog.d(content);
    }

    P getReqExtraParam() {
        return extraReqParam;
    }

    void setSuccessResult(CommonExtraParam extraParam) {
        Intent it = new Intent();
        it.putExtra(ICommonFragment.EXTRA_RESP, extraParam);
        fragment.getActivity().setResult(Activity.RESULT_OK, it);
        fragment.getActivity().finish();
    }
}