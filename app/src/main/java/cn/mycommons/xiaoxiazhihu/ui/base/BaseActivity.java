package cn.mycommons.xiaoxiazhihu.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.widget.Toast;

import butterknife.ButterKnife;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.ILoadDataView;
import roboguice.activity.RoboActionBarActivity;

public abstract class BaseActivity extends RoboActionBarActivity implements ILoadDataView {

    public static final int SHOW_LOADING_DIALOG = 1001;
    public static final int DISMISS_LOADING_DIALOG = 1002;

    protected Handler uiHandler;

    private DialogFragment loadingDialogFragment;
    /**
     * 载入对话框标题
     */
    private String loadingTitle;
    private boolean cancelable;

    private class UiHandler extends Handler {

        public UiHandler() {
            super(getMainLooper());
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SHOW_LOADING_DIALOG:
                    showLoadingInMainThread(msg.arg1, msg);
                    break;
                case DISMISS_LOADING_DIALOG:
                    hideLoadingInMainThread(msg.arg1, msg);
                    break;
                default:
                    break;
            }
            handleMessageInUiThread(msg);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
        initActionBar();
        uiHandler = new UiHandler();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void showLoading() {
        showLoading(LOADING_TYPE_DEFAULT);
    }

    @Override
    public final void showLoading(int loadingType) {
        sendShowLoadingMessage(loadingType);
    }

    public final void showLoading(String loadingTitle) {
        showLoading(loadingTitle, false);
    }

    public final void showLoading(String loadingTitle, boolean cancelable) {
        this.loadingTitle = loadingTitle;
        this.cancelable = cancelable;
        showLoading(LOADING_TYPE_DEFAULT);
    }

    @Override
    public void hideLoading() {
        hideLoading(LOADING_TYPE_DEFAULT);
    }

    @Override
    final public void hideLoading(int loadingType) {
        sendHideLoadingMessage(loadingType);
    }

    @Override
    public void showRetry() {
        //NO OP
    }

    @Override
    public void hideRetry() {
        //NO OP
    }

    @Override
    public void showError(String message) {
        Toast.makeText(BaseActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    private void initActionBar() {
        if (getSupportActionBar() != null) {
            int options = ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_USE_LOGO | ActionBar.DISPLAY_SHOW_TITLE;
            getSupportActionBar().setDisplayOptions(options);
        }
    }

    private void sendShowLoadingMessage(int loadingType) {
        sendShowOrHideLoadingMessage(true, loadingType);
    }

    private void sendHideLoadingMessage(int loadingType) {
        sendShowOrHideLoadingMessage(false, loadingType);
    }

    private void sendShowOrHideLoadingMessage(boolean isShowLoading, int loadingType) {
        Message message = buildLoadingMessage(isShowLoading, loadingType);
        uiHandler.sendMessage(message);
    }

    /**
     * 构建显示loading对话框的message，用于发送给uiHandle
     *
     * @return
     */
    private Message buildLoadingMessage(boolean isShowLoading, int loadingType) {
        Message message = uiHandler.obtainMessage();
        //类别
        if (isShowLoading) {
            message.what = SHOW_LOADING_DIALOG;
            message = machiningShowLoadingMessage(message.arg1, message);
        } else {
            message.what = DISMISS_LOADING_DIALOG;
            message = machiningHideLoadingMessage(message.arg1, message);
        }
        message.arg1 = loadingType;
        return message;
    }

    /**
     * 子类可重写此方法自定义自己的Message
     *
     * @param loadingType loading类型
     * @param message     消息。可以使用的字段 obj, arg2
     * @return 最终用于发送给uiHandle的消息
     */
    protected Message machiningShowLoadingMessage(int loadingType, Message message) {
        return message;
    }

    /**
     * 子类可重写此方法自定义自己的Message，可以使用的字段为obj,arg2
     *
     * @param loadingType loading类型
     * @param message     消息
     * @return 最终用于发送给uiHandle的消息
     */
    protected Message machiningHideLoadingMessage(int loadingType, Message message) {
        return message;
    }

    /**
     * 真正处理loading对话框显示的方法，子类可以通过重写此方法实现显示自定义loading
     *
     * @param loadingType loading类型
     * @param message     由{@link #machiningShowLoadingMessage(int, Message)}返回
     */
    protected void showLoadingInMainThread(int loadingType, Message message) {
        switch (loadingType) {
            case LOADING_TYPE_DEFAULT:
            default:
                showDefaultStyleLoadingDialog(loadingTitle);
                break;
        }
    }

    /**
     * 真正处理loading对话框隐藏的方法，子类可以通过重写此方法实现隐藏自定义loading
     *
     * @param loadingType loading类型
     * @param message     由{@link #machiningHideLoadingMessage(int, Message)}返回
     */
    protected void hideLoadingInMainThread(int loadingType, Message message) {
        switch (loadingType) {
            case LOADING_TYPE_DEFAULT:
            default:
                hideDefaultStyleLoadingDialog();
                break;
        }
    }

    /**
     * 显示用默认样式的Loading对话框
     *
     * @param loadingTitle loading的标题
     */
    final public void showDefaultStyleLoadingDialog(String loadingTitle) {
        if (loadingDialogFragment != null) {
            loadingDialogFragment.dismiss();
            loadingDialogFragment = null;
        }

        String LOADING_DIALOG_TAG = "loadingDialog";

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        // Create and show the dialog.
        String msg = null;
        if (!TextUtils.isEmpty(loadingTitle)) {
            msg = loadingTitle;
        }
        DialogFragment newFragment = LoadingDialogFragment.newInstance(msg);
        newFragment.setCancelable(cancelable);
        newFragment.show(ft, LOADING_DIALOG_TAG);
        loadingDialogFragment = newFragment;
    }

    /**
     * 隐藏默认样式的loading对话框
     */
    private void hideDefaultStyleLoadingDialog() {
        if (loadingDialogFragment != null) {
            loadingDialogFragment.dismiss();
            loadingDialogFragment = null;
        }
    }

    /**
     * 如果要处理UI相关消息，实现此方法接收
     *
     * @param msg 接收到的消息
     */
    protected void handleMessageInUiThread(Message msg) {
        // NO OP
    }

    public void setTitle(int titleId) {
        setTitle(getString(titleId));
    }

    public void setTitle(CharSequence title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}