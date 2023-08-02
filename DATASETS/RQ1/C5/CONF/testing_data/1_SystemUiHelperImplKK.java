



import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;

@TargetApi(Build.VERSION_CODES.KITKAT)
class SystemUiHelperImplKK extends SystemUiHelperImplJB {

    SystemUiHelperImplKK(Activity activity, int level, int flags,
            SystemUiHelper.OnVisibilityChangeListener onVisibilityChangeListener) {
        super(activity, level, flags, onVisibilityChangeListener);
    }

    @Override
    protected int createHideFlags() {
        int flag = super.createHideFlags();

        if (mLevel == SystemUiHelper.LEVEL_IMMERSIVE) {
            
            
            
            
            
            flag |= ((mFlags & SystemUiHelper.FLAG_IMMERSIVE_STICKY) != 0)
                            ? View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            : View.SYSTEM_UI_FLAG_IMMERSIVE;
        }

        return flag;
    }

}
