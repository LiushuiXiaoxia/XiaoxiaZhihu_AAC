package cn.mycommons.xiaoxiazhihu.ui.base.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;


/**
 * FragmentLauncher <br/>
 * Created by xiaqiulei on 2015-01-24.
 */
public class FragmentLauncher {

    public static void launch(Context context, Class<? extends ICommonFragment> fragmentClass) {
        launch(context, new CommonExtraParam(fragmentClass));
    }

    public static void launch(Context context, CommonExtraParam param) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            launch(activity, param, 0);
        } else {
            Intent it = new Intent(context, getTargetActivityClass(param));
            it.putExtra(ICommonFragment.EXTRA_REQ, param);
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(it);
        }
    }

    public static void launch(Activity activity, CommonExtraParam param, int req) {
        Intent it = new Intent(activity, getTargetActivityClass(param));

        it.putExtra(ICommonFragment.EXTRA_REQ, param);
        if (req == 0) {
            activity.startActivity(it);
        } else {
            activity.startActivityForResult(it, req);
        }
    }

    public static void launch(Fragment fragment, CommonExtraParam param, int req) {
        Intent it = new Intent(fragment.getActivity(), getTargetActivityClass(param));

        it.putExtra(ICommonFragment.EXTRA_REQ, param);
        if (req == 0) {
            fragment.startActivity(it);
        } else {
            fragment.startActivityForResult(it, req);
        }
    }

    private static Class<? extends Activity> getTargetActivityClass(CommonExtraParam param) {
        Class<? extends Activity> activityClass = CommonMvpFragmentActivity.class;
        if (param.getActivityClass() != null) {
            activityClass = param.getActivityClass();
        }
        param.setActivityClass(activityClass);

        return activityClass;
    }

    private FragmentLauncher() {
    }
}