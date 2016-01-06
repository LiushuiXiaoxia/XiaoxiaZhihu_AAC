package cn.mycommons.xiaoxiazhihu.ui.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import roboguice.fragment.RoboDialogFragment;

public class LoadingDialogFragment extends RoboDialogFragment {

    public static final String DEFAULT_MSG = "数据加载中,请稍后……";
    private static final String DIMABLE = "dimable";
    private static final String MSG = "msg";

    public static LoadingDialogFragment newInstance() {
        return newInstance(null);
    }

    public static LoadingDialogFragment newInstance(boolean dimable) {
        return newInstance(dimable, "");
    }

    public static LoadingDialogFragment newInstance(String msg) {
        return newInstance(true, msg);
    }

    public static LoadingDialogFragment newInstance(boolean dimable, String msg) {
        LoadingDialogFragment f = new LoadingDialogFragment();
        Bundle args = new Bundle();
        args.putString(MSG, msg);
        args.putBoolean(DIMABLE, dimable);
        f.setArguments(args);
        return f;
    }

    private OnCancelListener onCancelListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        boolean dimable = getArguments().getBoolean(DIMABLE);
        String msg = getArguments().getString(MSG, DEFAULT_MSG);

        ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.setCancelable(dimable);
        dialog.setCanceledOnTouchOutside(dimable);
        dialog.setTitle(msg);

        return dialog;
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialog);
        }
    }

    public LoadingDialogFragment show(FragmentManager fragmentManager) {
        super.show(fragmentManager, null);
        return this;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }
}