





public final class SystemUiHelper {

    
    public static final int LEVEL_LOW_PROFILE = 0;

    
    public static final int LEVEL_HIDE_STATUS_BAR = 1;

    
    public static final int LEVEL_LEAN_BACK = 2;

    
    public static final int LEVEL_IMMERSIVE = 3;

    
    public static final int FLAG_LAYOUT_IN_SCREEN_OLDER_DEVICES = 0x1;

    
    public static final int FLAG_IMMERSIVE_STICKY = 0x2;

    private static final String LOG_TAG = SystemUiHelper.class.getSimpleName();

    private final SystemUiHelperImpl mImpl;

    private final Handler mHandler;
    private final Runnable mHideRunnable;

    
    public SystemUiHelper(Activity activity, int level, int flags) {
        this(activity, level, flags, null);
    }

    
    public SystemUiHelper(Activity activity, int level, int flags,
            OnVisibilityChangeListener listener) {

        mHandler = new Handler(Looper.getMainLooper());
        mHideRunnable = new HideRunnable();

        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mImpl = new SystemUiHelperImplKK(activity, level, flags, listener);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mImpl = new SystemUiHelperImplJB(activity, level, flags, listener);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            mImpl = new SystemUiHelperImplICS(activity, level, flags, listener);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mImpl = new SystemUiHelperImplHC(activity, level, flags, listener);
        } else {
            mImpl = new SystemUiHelperImplBase(activity, level, flags, listener);
        }
    }

    
    public boolean isShowing() {
        return mImpl.isShowing();
    }

    
    public void show() {
        
        removeQueuedRunnables();

        mImpl.show();
    }

    
    public void hide() {
        
        removeQueuedRunnables();

        mImpl.hide();
    }

    
    public void delayHide(long delayMillis) {
        
        removeQueuedRunnables();

        mHandler.postDelayed(mHideRunnable, delayMillis);
    }

    
    public void toggle() {
        if (mImpl.isShowing()) {
            mImpl.hide();
        } else {
            mImpl.show();
        }
    }

    private void removeQueuedRunnables() {
        
        mHandler.removeCallbacks(mHideRunnable);
    }

    
    public interface OnVisibilityChangeListener {
        
        public void onVisibilityChange(boolean visible);
    }

    static abstract class SystemUiHelperImpl {

        final Activity mActivity;
        final int mLevel;
        final int mFlags;
        final OnVisibilityChangeListener mOnVisibilityChangeListener;

        boolean mIsShowing = true;

        SystemUiHelperImpl(Activity activity, int level, int flags,
                OnVisibilityChangeListener onVisibilityChangeListener) {
            mActivity = activity;
            mLevel = level;
            mFlags = flags;
            mOnVisibilityChangeListener = onVisibilityChangeListener;
        }

        abstract void show();
        abstract void hide();

        boolean isShowing() {
            return mIsShowing;
        }

        void setIsShowing(boolean isShowing) {
            mIsShowing = isShowing;

            if (mOnVisibilityChangeListener != null) {
                mOnVisibilityChangeListener.onVisibilityChange(mIsShowing);
            }
        }
    }

    
    static class SystemUiHelperImplBase extends SystemUiHelperImpl {

        SystemUiHelperImplBase(Activity activity, int level, int flags,
                OnVisibilityChangeListener onVisibilityChangeListener) {
            super(activity, level, flags, onVisibilityChangeListener);

            if ((mFlags & SystemUiHelper.FLAG_LAYOUT_IN_SCREEN_OLDER_DEVICES) != 0) {
                mActivity.getWindow().addFlags(
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            }
        }

        @Override
        void show() {
            if (mLevel > SystemUiHelper.LEVEL_LOW_PROFILE) {
                mActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setIsShowing(true);
            }
        }

        @Override
        void hide() {
            if (mLevel > SystemUiHelper.LEVEL_LOW_PROFILE) {
                mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setIsShowing(false);
            }
        }
    }

    private class HideRunnable implements Runnable {
        @Override
        public void run() {
            hide();
        }
    }

}
