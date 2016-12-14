package cn.mycommons.xiaoxiazhihu.ui.base.common;

/**
 * Created by xiaqiulei on 14/11/20.
 */
interface ICommonFragment {

    String EXTRA_REQ = "extra_req";

    String EXTRA_RESP = "extra_resp";

    /**
     * 当父activity点击触发onPressBack()时候，调用此方法，返回true则不调用父中的back
     *
     * @return
     */
    boolean onActivityPressBack();

    /**
     * 当父activity点击触发onSupportNavigateUp()时候，调用此方法，返回true则不调用父中的back
     *
     * @return
     */
    boolean onActivitySupportNavigateUp();
}