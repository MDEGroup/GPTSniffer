



import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
class SystemUiHelperImplICS extends SystemUiHelperImplHC {

    SystemUiHelperImplICS(Activity activity, int level, int flags,
            SystemUiHelper.OnVisibilityChangeListener onVisibilityChangeListener) {
        super(activity, level, flags, onVisibilityChangeListener);
    }

    @Override
    protected int createShowFlags() {
        return View.SYSTEM_UI_FLAG_VISIBLE;
    }

    @Override
    protected int createTestFlags() {
        if (mLevel >= SystemUiHelper.LEVEL_LEAN_BACK) {
            
            return View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        return View.SYSTEM_UI_FLAG_LOW_PROFILE;
    }

    @Override
    protected int createHideFlags() {
        int flag = View.SYSTEM_UI_FLAG_LOW_PROFILE;

        if (mLevel >= SystemUiHelper.LEVEL_LEAN_BACK) {
            flag |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        return flag;
    }
}
