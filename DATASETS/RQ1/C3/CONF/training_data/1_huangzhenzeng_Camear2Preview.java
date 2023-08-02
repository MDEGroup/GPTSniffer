

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.*;
import android.hardware.SensorManager;
import android.hardware.camera2.*;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.*;
import androidx.annotation.NonNull;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
 * Fork of gist Camear2Preview.java by Sira
 * https://gist.github.com/siralam/1c4000a5af069ddb366705edd33ebeea
 * 
 * Modified by Ako Tulu
 * ako@koodinurk.ee
 * 2020-04-30
 */
public class CameraTextureView extends TextureView
{
    protected static final String TAG = CameraTextureView.class.getName();

    public static final int LENS_FACING_BACK = CameraCharacteristics.LENS_FACING_BACK;
    public static final int LENS_FACING_FRONT = CameraCharacteristics.LENS_FACING_FRONT;

    // Options
    protected int mFacing = LENS_FACING_BACK;
    protected float mAspectRatio = 9 / 16f;
    protected float mAspectRatioThreshold = 0.05f;
    protected int mImageQuality = 100;
    protected boolean mDisplayPreview = true;

    // Camera
    protected String mCameraId;
    protected CameraDevice mCameraDevice;
    protected CameraCharacteristics mCameraCharacteristics;
    protected CameraCaptureSession mCaptureSession;
    protected CaptureRequest.Builder mPreviewRequestBuilder;
    protected Size mPreviewSize;
    protected int mSensorOrientation;
    protected boolean mIsFlashSupported = false;

    // Image
    protected byte[] mImageByteArray;
    protected int mImageOrientation;

    // States
    protected Semaphore mCameraOpenCloseLock = new Semaphore( 1 );
    protected int mState = STATE_CLOSED;
    public static final int STATE_CLOSED = -2;
    public static final int STATE_OPENING = -1;
    public static final int STATE_STREAMING = 0;
    public static final int STATE_PREVIEW = 1;
    public static final int STATE_WAITING_LOCK = 2;
    public static final int STATE_WAITING_PRECAPTURE = 3;
    public static final int STATE_WAITING_NON_PRECAPTURE = 4;
    public static final int STATE_PICTURE_TAKEN = 5;

    // Zooming
    protected boolean mIsMultiTouch = false;
    protected float mFingerSpacing = 0;
    protected float mThumbFingerSize = 0; // TODO: as option
    protected float mZoomLevel = 1f; // TODO: as option
    protected float mMaximumZoomLevel; // TODO: as option
    protected float mMinimumZoomLevel; // TODO: as option
    protected Rect mZoom;

    protected static final SparseIntArray ORIENTATIONS = new SparseIntArray();

    static
    {
        ORIENTATIONS.append( Surface.ROTATION_0, 90 );
        ORIENTATIONS.append( Surface.ROTATION_90, 0 );
        ORIENTATIONS.append( Surface.ROTATION_180, 270 );
        ORIENTATIONS.append( Surface.ROTATION_270, 180 );
    }

    // Internals
    protected ImageReader mImageReader;
    protected Handler mBackgroundHandler;
    protected HandlerThread mBackgroundThread;
    protected WindowManager mWindowManager;

    public interface OnReadyListener
    {
        void onReady();

        static void handle( OnReadyListener callback )
        {
            Log.e( TAG, "onReady()" );

            if ( callback != null )
            {
                new Handler( Looper.getMainLooper() ).post( callback::onReady );
            }
        }
    }

    public interface OnPreviewListener
    {
        void onPreview();

        static void handle( OnPreviewListener callback )
        {
            Log.e( TAG, "onPreview()" );

            if ( callback != null )
            {
                new Handler( Looper.getMainLooper() ).post( callback::onPreview );
            }
        }
    }

    public interface OnPictureTakenListener
    {
        void onPictureTaken( byte[] data );

        static void handle( OnPictureTakenListener callback, byte[] data )
        {
            Log.e( TAG, "onPictureTaken( byte[] data )" );

            if ( callback != null )
            {
                new Handler( Looper.getMainLooper() ).post( () -> callback.onPictureTaken( data ) );
            }
        }
    }

    public interface OnCameraErrorListener
    {
        void onCameraError( Exception e );

        static void handle( OnCameraErrorListener callback, Exception e )
        {
            Log.e( TAG, Log.getStackTraceString( e ) );

            if ( callback != null )
            {
                new Handler( Looper.getMainLooper() ).post( () -> callback.onCameraError( e ) );
            }
        }
    }

    protected OnReadyListener mOnReadyCallback;
    protected OnPictureTakenListener mOnPictureTakenCallback;
    protected OnCameraErrorListener mCameraErrorCallback;
    protected OnPreviewListener mPreviewCallback;

    protected OrientationEventListener mOrientationEventListener;

    protected final TextureView.SurfaceTextureListener mSurfaceTextureListener = new TextureView.SurfaceTextureListener()
    {
        @Override
        public void onSurfaceTextureAvailable( SurfaceTexture texture, int width, int height )
        {
            Log.v( TAG, "onSurfaceTextureAvailable( SurfaceTexture texture, int width, int height )" );

            mBackgroundHandler.post( () -> openCamera( width, height ) );
        }

        @Override
        public void onSurfaceTextureSizeChanged( SurfaceTexture texture, int width, int height )
        {
            Log.v( TAG, "onSurfaceTextureSizeChanged( SurfaceTexture texture, int width, int height )" );

            mBackgroundHandler.post( () -> configureTransform( width, height ) );
        }

        @Override
        public boolean onSurfaceTextureDestroyed( SurfaceTexture texture )
        {
            Log.v( TAG, "onSurfaceTextureDestroyed( SurfaceTexture texture )" );

            return true;
        }

        @Override
        public void onSurfaceTextureUpdated( SurfaceTexture texture )
        {
        }
    };

    protected final CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback()
    {
        @Override
        public void onOpened( @NonNull CameraDevice cameraDevice )
        {
            Log.v( TAG, "onOpened( @NonNull CameraDevice cameraDevice )" );

            // This method is called when the camera is opened.  We start camera preview here.
            mCameraOpenCloseLock.release();
            mCameraDevice = cameraDevice;
            mBackgroundHandler.post( CameraTextureView.this::createCameraPreviewSession );
        }

        @Override
        public void onDisconnected( @NonNull CameraDevice cameraDevice )
        {
            Log.v( TAG, "onDisconnected( @NonNull CameraDevice cameraDevice )" );

            mCameraOpenCloseLock.release();
            cameraDevice.close();
            mCameraDevice = null;
        }

        @Override
        public void onError( @NonNull CameraDevice cameraDevice, int error )
        {
            final String[] errorString = new String[ 5 ];

            errorString[ 0 ] = "ERROR_CAMERA_IN_USE";
            errorString[ 1 ] = "ERROR_MAX_CAMERAS_IN_USE";
            errorString[ 2 ] = "ERROR_CAMERA_DISABLED";
            errorString[ 3 ] = "ERROR_CAMERA_DEVICE";
            errorString[ 4 ] = "ERROR_CAMERA_SERVICE";

            Log.e( TAG, "onError( CameraDevice camera, int error ) -> " + errorString[ error - 1 ] );

            mCameraOpenCloseLock.release();
            cameraDevice.close();
            mCameraDevice = null;
        }
    };

    protected final ImageReader.OnImageAvailableListener onImageAvailableListener = new ImageReader.OnImageAvailableListener()
    {
        @Override
        public void onImageAvailable( ImageReader reader )
        {
            Log.v( TAG, "onImageAvailable( ImageReader reader )" );

            try
            {
                AsyncTask.execute( () -> {
                    Image image = reader.acquireLatestImage();

                    if ( image == null )
                    {
                        Log.e( TAG, "onImageAvailable( ImageReader reader ) -> acquireLatestImage returned null" );
                        return;
                    }

                    ByteBuffer buffer = image.getPlanes()[ 0 ].getBuffer();
                    mImageByteArray = new byte[ buffer.capacity() ];
                    mImageOrientation = getOrientation();
                    buffer.get( mImageByteArray );
                    image.close();

                    if ( !mDisplayPreview )
                    {
                        OnPictureTakenListener.handle( mOnPictureTakenCallback, mImageByteArray );
                    }
                    else
                    {
                        OnPreviewListener.handle( mPreviewCallback );
                    }
                } );
            }
            catch ( Exception e )
            {
                OnCameraErrorListener.handle( mCameraErrorCallback, e );
            }
        }
    };

    protected CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback()
    {
        @SuppressWarnings("ConstantConditions")
        private void process( CaptureResult result )
        {
            switch ( mState )
            {
                case STATE_STREAMING:
                {
                    //Log.v( TAG, "state: STATE_STREAMING" ); // PS: Crashes phone
                    // We have nothing to do when the camera preview is working normally.
                    break;
                }
                case STATE_WAITING_LOCK:
                {
                    Log.v( TAG, "state: STATE_WAITING_LOCK" );

                    final int afState = result.get( CaptureResult.CONTROL_AF_STATE );
                    Log.d( TAG, "autoFocus: " + controlAFStateToString( afState ) );

                    if ( CaptureResult.CONTROL_AF_STATE_FOCUSED_LOCKED == afState ||
                            CaptureResult.CONTROL_AF_STATE_NOT_FOCUSED_LOCKED == afState ||
                            CaptureResult.CONTROL_AF_STATE_INACTIVE == afState /*add this*/ )
                    {
                        int aeState = result.get( CaptureResult.CONTROL_AE_STATE );
                        Log.d( TAG, "autoExposure: " + controlAEStateToString( aeState ) );

                        if ( aeState == CaptureResult.CONTROL_AE_STATE_CONVERGED )
                        {
                            mState = STATE_PICTURE_TAKEN;
                            mBackgroundHandler.post( CameraTextureView.this::captureStillPicture );
                        }
                        else
                        {
                            mBackgroundHandler.post( CameraTextureView.this::runPreCaptureSequence );
                        }
                    }
                    break;
                }
                case STATE_WAITING_PRECAPTURE:
                {
                    Log.v( TAG, "state: STATE_WAITING_PRECAPTURE" );

                    final int aeState = result.get( CaptureResult.CONTROL_AE_STATE );
                    Log.d( TAG, "autoExposure: " + controlAEStateToString( aeState ) );

                    if ( aeState == CaptureResult.CONTROL_AE_STATE_PRECAPTURE ||
                            aeState == CaptureRequest.CONTROL_AE_STATE_FLASH_REQUIRED )
                    {
                        mState = STATE_WAITING_NON_PRECAPTURE;
                    }
                    break;
                }
                case STATE_WAITING_NON_PRECAPTURE:
                {
                    Log.v( TAG, "state: STATE_WAITING_NON_PRECAPTURE" );

                    final int aeState = result.get( CaptureResult.CONTROL_AE_STATE );
                    Log.d( TAG, "autoExposure: " + controlAEStateToString( aeState ) );

                    if ( aeState != CaptureResult.CONTROL_AE_STATE_PRECAPTURE )
                    {
                        mState = STATE_PICTURE_TAKEN;
                        mBackgroundHandler.post( CameraTextureView.this::captureStillPicture );
                    }
                    break;
                }
            }
        }

        @Override
        public void onCaptureStarted( @NonNull CameraCaptureSession session, @NonNull CaptureRequest request, long timestamp, long frameNumber )
        {
            super.onCaptureStarted( session, request, timestamp, frameNumber );
            //Log.v( TAG, "onCaptureStarted( session, request, timestamp, frameNumber )" );
        }

        @Override
        public void onCaptureProgressed( @NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull CaptureResult partialResult )
        {
            super.onCaptureProgressed( session, request, partialResult );

            process( partialResult );
        }

        @Override
        public void onCaptureCompleted( @NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result )
        {
            super.onCaptureCompleted( session, request, result );
            //Log.v( TAG, "onCaptureCompleted( session, request, result )" );

            process( result );
        }

        @Override
        public void onCaptureFailed( @NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull CaptureFailure failure )
        {
            super.onCaptureFailed( session, request, failure );
            Log.v( TAG, "onCaptureFailed( session, request, failure )" );
        }
    };

    public void setFacing( int facing )
    {
        if ( facing == LENS_FACING_BACK || facing == LENS_FACING_FRONT )
        {
            mFacing = facing;
            closeStream(); // TODO: overkill to stop the camera
            startStream();
        }
    }

    public void resetFacing()
    {
        setFacing( LENS_FACING_BACK );
    }

    public void setAspectRatio( float aspectRatio )
    {
        if ( aspectRatio > 0f && aspectRatio <= 1.0f )
        {
            mAspectRatio = aspectRatio;
            closeStream(); // TODO: same overkill
            startStream();
        }
    }

    public void setAspectRatioThreshold( float aspectRatioThreshold )
    {
        mAspectRatioThreshold = aspectRatioThreshold;
    }

    public void setImageQuality( int imageQuality )
    {
        if ( imageQuality > 0 && imageQuality < 101 )
        {
            mImageQuality = imageQuality;
        }
    }

    public void setDisplayPreview( boolean displayPreview )
    {
        mDisplayPreview = displayPreview;
    }

    public void setOnReadyListener( OnReadyListener callback )
    {
        mOnReadyCallback = callback;
    }

    public void setOnPreviewListener( OnPreviewListener callback )
    {
        mPreviewCallback = callback;
    }

    public void setOnPictureTakenListener( OnPictureTakenListener callback )
    {
        mOnPictureTakenCallback = callback;
    }

    public void setOnCameraErrorListener( OnCameraErrorListener callback )
    {
        mCameraErrorCallback = callback;
    }

    public boolean isFlashSupported()
    {
        return mIsFlashSupported;
    }

    @SuppressWarnings("ConstantConditions")
    public boolean isFlashActive()
    {
        if ( mPreviewRequestBuilder == null || !isFlashSupported() )
        {
            return false;
        }
        return mPreviewRequestBuilder.get( CaptureRequest.FLASH_MODE ) == CaptureRequest.FLASH_MODE_SINGLE;
    }

    public void setFlash( boolean active )
    {
        try
        {
            if ( active )
            {
                mPreviewRequestBuilder.set( CaptureRequest.FLASH_MODE, CaptureRequest.FLASH_MODE_SINGLE );
            }
            else
            {
                mPreviewRequestBuilder.set( CaptureRequest.FLASH_MODE, CaptureRequest.FLASH_MODE_OFF );
            }
            /* handler = null uses mBackgroundHandler, defined when camera was opened */
            mCaptureSession.setRepeatingRequest( mPreviewRequestBuilder.build(), mCaptureCallback, null );
        }
        catch ( NullPointerException | CameraAccessException e )
        {
            OnCameraErrorListener.handle( mCameraErrorCallback, e );
        }
    }

    public float getAspectRatio()
    {
        return mAspectRatio;
    }

    public byte[] getImageByteArray()
    {
        return mImageByteArray.clone();
    }

    public int getImageOrientation()
    {
        return mImageOrientation;
    }

    public int getState()
    {
        return mState;
    }

    public CameraTextureView( Context context )
    {
        super( context );
        Log.v( TAG, "CameraTextureView( Context context )" );

        init( context );
    }

    public CameraTextureView( Context context, AttributeSet attrs )
    {
        super( context, attrs );
        Log.v( TAG, "CameraTextureView( Context context, AttributeSet attrs )" );

        init( context );
    }

    public CameraTextureView( Context context, AttributeSet attrs, int defStyleAttr )
    {
        super( context, attrs, defStyleAttr );
        Log.v( TAG, "CameraTextureView( Context context, AttributeSet attrs, int defStyleAttr )" );

        init( context );
    }

    public void startStream()
    {
        Log.v( TAG, "startStream()" );

        if ( mState != STATE_CLOSED )
        {
            return;
        }

        mZoom = null;
        mState = STATE_OPENING;
        mOrientationEventListener.enable();

        startBackgroundThread();

        if ( isAvailable() )
        {
            openCamera( getWidth(), getHeight() );
        }
        else
        {
            setSurfaceTextureListener( mSurfaceTextureListener );
        }
    }

    public void resumeStream()
    {
        Log.v( TAG, "resumeStream()" );

        if ( mState == STATE_PREVIEW )
        {
            mBackgroundHandler.post( this::unlockFocus );
        }
    }

    public void closeStream()
    {
        Log.v( TAG, "closeStream()" );

        mState = STATE_CLOSED;
        mOrientationEventListener.disable();

        closeCamera();
        stopBackgroundThread();
    }

    public void zoom( float delta )
    {
        Log.v( TAG, "zoom( float delta ) -> " + delta );

        final float zoomLevel = mZoomLevel + delta;

        if ( zoomLevel > mMaximumZoomLevel || zoomLevel < 0f )
        {
            return;
        }
        Log.v( TAG, "zoom = " + zoomLevel );

        mBackgroundHandler.post( () -> {
            final Rect rect = mCameraCharacteristics.get( CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE );

            mZoomLevel = zoomLevel;

            float ratio = 1f / mZoomLevel;

            int croppedWidth = rect.width() - Math.round( ( float ) rect.width() * ratio );
            int croppedHeight = rect.height() - Math.round( ( float ) rect.height() * ratio );

            mZoom = new Rect( croppedWidth / 2, croppedHeight / 2,
                    rect.width() - croppedWidth / 2, rect.height() - croppedHeight / 2 );
            try
            {
                mPreviewRequestBuilder.set( CaptureRequest.SCALER_CROP_REGION, mZoom );
                mCaptureSession.setRepeatingRequest( mPreviewRequestBuilder.build(), mCaptureCallback, null );
            }
            catch ( CameraAccessException e )
            {
                OnCameraErrorListener.handle( mCameraErrorCallback, e );
            }
        } );
    }

    public void capturePicture()
    {
        Log.v( TAG, "capturePicture()" );

        if ( mBackgroundHandler == null )
        {
            return;
        }

        if ( mState == STATE_PREVIEW )
        {
            mBackgroundHandler.post( this::unlockFocus );
        }
        else
        {
            mBackgroundHandler.post( this::lockFocus );
        }
    }

    // ------------------------------------------------------------------------
    // ------------------ PRIVATE METHODS -------------------------------------
    // ------------------------------------------------------------------------

    protected void init( Context context )
    {
        Log.v( TAG, "init( Context context )" );

        mWindowManager = ( WindowManager ) context.getSystemService( Context.WINDOW_SERVICE );

        mOrientationEventListener = new OrientationEventListener( context, SensorManager.SENSOR_DELAY_NORMAL )
        {
            @Override
            public void onOrientationChanged( int orientation )
            {
                int newRotation = mWindowManager.getDefaultDisplay().getRotation();

                if ( newRotation != mSensorOrientation )
                {
                    mSurfaceTextureListener.onSurfaceTextureSizeChanged( CameraTextureView.this.getSurfaceTexture(), CameraTextureView.this.getWidth(), CameraTextureView.this.getHeight() );
                    mSensorOrientation = newRotation;
                }
            }
        };
    }

    protected static Size chooseOptimalSize( Size[] choices, int textureViewWidth,
                                             int textureViewHeight, int maxWidth, int maxHeight, Size aspectRatio )
    {
        Log.v( TAG, "chooseOptimalSize( Size[] choices, int textureViewWidth,\n" +
                "                                           int textureViewHeight, int maxWidth, int maxHeight, Size aspectRatio )" );

        // Collect the supported resolutions that are at least as big as the preview Surface
        List< Size > bigEnough = new ArrayList<>();
        // Collect the supported resolutions that are smaller than the preview Surface
        List< Size > notBigEnough = new ArrayList<>();
        int w = aspectRatio.getWidth();
        int h = aspectRatio.getHeight();
        for ( Size option : choices )
        {
            if ( option.getWidth() <= maxWidth && option.getHeight() <= maxHeight && option.getHeight() == option.getWidth() * h / w )
            {
                if ( option.getWidth() >= textureViewWidth && option.getHeight() >= textureViewHeight )
                {
                    bigEnough.add( option );
                }
                else
                {
                    notBigEnough.add( option );
                }
            }
        }

        // Pick the smallest of those big enough. If there is no one big enough, pick the
        // largest of those not big enough.
        if ( bigEnough.size() > 0 )
        {
            return Collections.min( bigEnough, new CompareSizesByArea() );
        }
        else if ( notBigEnough.size() > 0 )
        {
            return Collections.max( notBigEnough, new CompareSizesByArea() );
        }
        else
        {
            Log.e( TAG, "suitable preview size couldn't be determined" );
            return choices[ 0 ];
        }
    }

    @SuppressWarnings({ "ConstantConditions", "SuspiciousNameCombination" })
    protected void setUpCameraOutputs( int width, int height )
    {
        Log.v( TAG, "setUpCameraOutputs( int width, int height )" );
        try
        {
            CameraManager manager = ( CameraManager ) getContext().getSystemService( Context.CAMERA_SERVICE );
            String cameraId = null;

            for ( String id : manager.getCameraIdList() )
            {
                if ( mFacing == manager.getCameraCharacteristics( id ).get( CameraCharacteristics.LENS_FACING ) )
                {
                    cameraId = id;
                    break;
                }
            }
            if ( cameraId == null )
            {
                throw new Exception( "device is missing requested camera facing support" );
            }
            mCameraCharacteristics = manager.getCameraCharacteristics( cameraId );

            mMaximumZoomLevel = mCameraCharacteristics.get( CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM );
            mIsFlashSupported = mCameraCharacteristics.get( CameraCharacteristics.FLASH_INFO_AVAILABLE );

            StreamConfigurationMap map = mCameraCharacteristics.get( CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP );
            if ( map == null )
            {
                throw new Exception( "configuration map is null" );
            }

            // For still image captures, we use the largest available size.
            ArrayList< Size > sizes = new ArrayList<>();
            for ( Size size : map.getOutputSizes( ImageFormat.JPEG ) )
            {
                float thisAspect = ( float ) size.getHeight() / size.getWidth();
                if ( ( Math.abs( thisAspect - mAspectRatio ) ) < mAspectRatioThreshold )
                {
                    sizes.add( size );
                }
            }
            if ( sizes.size() == 0 )
            {
                return;
            }
            Size largest = Collections.max( sizes, new CompareSizesByArea() );
            mImageReader = ImageReader.newInstance( largest.getWidth(), largest.getHeight(), ImageFormat.JPEG, /*maxImages*/3 );
            mImageReader.setOnImageAvailableListener( onImageAvailableListener, mBackgroundHandler );

            // Find out if we need to swap dimension to get the preview size relative to sensor
            // coordinate.
            int displayRotation = getDisplay().getRotation();
            //noinspection ConstantConditions
            mSensorOrientation = mCameraCharacteristics.get( CameraCharacteristics.SENSOR_ORIENTATION );
            boolean swappedDimensions = false;
            switch ( displayRotation )
            {
                case Surface.ROTATION_0:
                case Surface.ROTATION_180:
                    if ( mSensorOrientation == Surface.ROTATION_90 || mSensorOrientation == Surface.ROTATION_270 )
                    {
                        swappedDimensions = true;
                    }
                    break;
                case Surface.ROTATION_90:
                case Surface.ROTATION_270:
                    if ( mSensorOrientation == Surface.ROTATION_0 || mSensorOrientation == Surface.ROTATION_180 )
                    {
                        swappedDimensions = true;
                    }
                    break;
                default:
                    Log.e( TAG, "display rotation is invalid: " + displayRotation );
            }

            Point displaySize = new Point();
            getDisplay().getSize( displaySize );
            int rotatedPreviewWidth = width;
            int rotatedPreviewHeight = height;
            int maxPreviewWidth = displaySize.x;
            int maxPreviewHeight = displaySize.y;

            if ( swappedDimensions )
            {
                rotatedPreviewWidth = height;
                rotatedPreviewHeight = width;
                maxPreviewWidth = displaySize.y;
                maxPreviewHeight = displaySize.x;
            }

            // Danger, W.R.! Attempting to use too large a preview size could  exceed the camera
            // bus' bandwidth limitation, resulting in gorgeous previews but the storage of
            // garbage capture data.
            mPreviewSize = chooseOptimalSize( map.getOutputSizes( SurfaceTexture.class ),
                    rotatedPreviewWidth, rotatedPreviewHeight, maxPreviewWidth,
                    maxPreviewHeight, largest );

            mCameraId = cameraId;
        }
        catch ( Exception e )
        {
            OnCameraErrorListener.handle( mCameraErrorCallback, e );
        }
    }

    @SuppressLint("MissingPermission")
    protected void openCamera( int width, int height )
    {
        Log.v( TAG, "openCamera( int width, int height )" );

        setUpCameraOutputs( width, height );
        configureTransform( width, height );
        CameraManager manager = ( CameraManager ) getContext().getSystemService( Context.CAMERA_SERVICE );
        try
        {
            if ( !mCameraOpenCloseLock.tryAcquire( 2500, TimeUnit.MILLISECONDS ) )
            {
                throw new RuntimeException( "acquiring camera mutex timed out" );
            }
            manager.openCamera( mCameraId, stateCallback, mBackgroundHandler );

            OnReadyListener.handle( mOnReadyCallback );
        }
        catch ( Exception e )
        {
            OnCameraErrorListener.handle( mCameraErrorCallback, e );
        }
    }

    private void closeCamera()
    {
        Log.v( TAG, "closeCamera()" );
        try
        {
            mCameraOpenCloseLock.acquire();
            if ( null != mCaptureSession )
            {
                mCaptureSession.close();
                mCaptureSession = null;
            }
            if ( null != mCameraDevice )
            {
                mCameraDevice.close();
                mCameraDevice = null;
            }
            if ( null != mImageReader )
            {
                mImageReader.close();
                mImageReader = null;
            }
        }
        catch ( InterruptedException e )
        {
            Log.e( TAG, Log.getStackTraceString( e ) );

            throw new RuntimeException( "interrupted while trying to lock closing camera", e );
        }
        finally
        {
            mCameraOpenCloseLock.release();
        }
    }

    protected void createCameraPreviewSession()
    {
        Log.v( TAG, "createCameraPreviewSession()" );
        try
        {
            SurfaceTexture texture = getSurfaceTexture();

            // We configure the size of default buffer to be the size of camera preview we want.
            texture.setDefaultBufferSize( mPreviewSize.getWidth(), mPreviewSize.getHeight() );

            // This is the output Surface we need to start preview.
            Surface surface = new Surface( texture );

            // We set up a CaptureRequest.Builder with the output Surface.
            mPreviewRequestBuilder = mCameraDevice.createCaptureRequest( CameraDevice.TEMPLATE_PREVIEW );
            mPreviewRequestBuilder.addTarget( surface );

            // Here, we create a CameraCaptureSession for camera preview.
            mCameraDevice.createCaptureSession( Arrays.asList( surface, mImageReader.getSurface() ), new CameraCaptureSession.StateCallback()
            {
                @Override
                public void onConfigured( @NonNull CameraCaptureSession cameraCaptureSession )
                {
                    // The camera is already closed
                    if ( null == mCameraDevice )
                    {
                        return;
                    }

                    // When the session is ready, we start displaying the preview.
                    mCaptureSession = cameraCaptureSession;
                    try
                    {
                        // Auto focus should be continuous for camera preview.
                        mPreviewRequestBuilder.set( CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE );

                        // Finally, we start displaying the camera preview.
                        mState = STATE_STREAMING;
                        mCaptureSession.setRepeatingRequest( mPreviewRequestBuilder.build(), mCaptureCallback, null );
                    }
                    catch ( CameraAccessException e )
                    {
                        OnCameraErrorListener.handle( mCameraErrorCallback, e );
                    }
                }

                @Override
                public void onConfigureFailed( @NonNull CameraCaptureSession cameraCaptureSession ) { }
            }, null );
        }
        catch ( NullPointerException | CameraAccessException e )
        {
            OnCameraErrorListener.handle( mCameraErrorCallback, e );
        }
    }

    protected void configureTransform( int viewWidth, int viewHeight )
    {
        Log.v( TAG, "configureTransform( int viewWidth, int viewHeight )" );

        if ( null == mPreviewSize )
        {
            return;
        }
        int rotation = getDisplay().getRotation();
        Matrix matrix = new Matrix();
        RectF viewRect = new RectF( 0, 0, viewWidth, viewHeight );
        RectF bufferRect = new RectF( 0, 0, mPreviewSize.getHeight(), mPreviewSize.getWidth() );
        float centerX = viewRect.centerX();
        float centerY = viewRect.centerY();
        if ( Surface.ROTATION_90 == rotation || Surface.ROTATION_270 == rotation )
        {
            bufferRect.offset( centerX - bufferRect.centerX(), centerY - bufferRect.centerY() );
            matrix.setRectToRect( viewRect, bufferRect, Matrix.ScaleToFit.FILL );
            float scale = Math.max(
                    ( float ) viewHeight / mPreviewSize.getHeight(),
                    ( float ) viewWidth / mPreviewSize.getWidth() );
            matrix.postScale( scale, scale, centerX, centerY );
            matrix.postRotate( 90 * ( rotation - 2 ), centerX, centerY );
        }
        else if ( Surface.ROTATION_180 == rotation )
        {
            matrix.postRotate( 180, centerX, centerY );
        }
        setTransform( matrix );
    }

    protected void lockFocus()
    {
        Log.v( TAG, "lockFocus()" );

        if ( mCaptureSession == null )
        {
            return;
        }
        try
        {
            // This is how to tell the camera to lock focus.
            mPreviewRequestBuilder.set( CaptureRequest.CONTROL_AF_TRIGGER, CameraMetadata.CONTROL_AF_TRIGGER_START );
            // Tell #captureCallback to wait for the lock.
            mState = STATE_WAITING_LOCK;
            mCaptureSession.capture( mPreviewRequestBuilder.build(), mCaptureCallback, null );
        }
        catch ( CameraAccessException e )
        {
            OnCameraErrorListener.handle( mCameraErrorCallback, e );
        }
    }

    protected void unlockFocus()
    {
        Log.v( TAG, "unlockFocus()" );
        try
        {
            // Reset the auto-focus trigger
            mPreviewRequestBuilder.set( CaptureRequest.CONTROL_AF_TRIGGER, CameraMetadata.CONTROL_AF_TRIGGER_CANCEL );
            mCaptureSession.capture( mPreviewRequestBuilder.build(), null, null );
            // After this, the camera will go back to the normal state of preview.
            mState = STATE_STREAMING;
            //resume Zoom effect after taking a picture
            mPreviewRequestBuilder.set( CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE );
            if ( mZoom != null )
            {
                mPreviewRequestBuilder.set( CaptureRequest.SCALER_CROP_REGION, mZoom );
            }
            mCaptureSession.setRepeatingRequest( mPreviewRequestBuilder.build(), mCaptureCallback, mBackgroundHandler );
        }
        catch ( CameraAccessException e )
        {
            OnCameraErrorListener.handle( mCameraErrorCallback, e );
        }
    }

    protected void runPreCaptureSequence()
    {
        Log.v( TAG, "runPreCaptureSequence()" );
        try
        {
            // This is how to tell the camera to trigger.
            mPreviewRequestBuilder.set( CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER_START );
            // Tell #captureCallback to wait for the precapture sequence to be set.
            mState = STATE_WAITING_PRECAPTURE;
            mCaptureSession.capture( mPreviewRequestBuilder.build(), mCaptureCallback, null );
        }
        catch ( CameraAccessException e )
        {
            OnCameraErrorListener.handle( mCameraErrorCallback, e );
        }
    }

    protected void captureStillPicture()
    {
        Log.v( TAG, "captureStillPicture()" );
        try
        {
            if ( null == mCameraDevice )
            {
                return;
            }
            // This is the CaptureRequest.Builder that we use to take a picture.
            final CaptureRequest.Builder captureBuilder = mCameraDevice.createCaptureRequest( CameraDevice.TEMPLATE_STILL_CAPTURE );
            captureBuilder.addTarget( mImageReader.getSurface() );

            // Use the same AE and AF modes as the preview.
            captureBuilder.set( CaptureRequest.FLASH_MODE, isFlashActive() ? CaptureRequest.FLASH_MODE_SINGLE : CaptureRequest.FLASH_MODE_OFF );
            captureBuilder.set( CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE );
            captureBuilder.set( CaptureRequest.JPEG_QUALITY, ( byte ) mImageQuality );

            // Orientation
            captureBuilder.set( CaptureRequest.JPEG_ORIENTATION, getOrientation() );

            //Zoom
            if ( mZoom != null )
            {
                captureBuilder.set( CaptureRequest.SCALER_CROP_REGION, mZoom );
            }

            CameraCaptureSession.CaptureCallback captureCallback = new CameraCaptureSession.CaptureCallback()
            {
                @Override
                public void onCaptureCompleted( @NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result )
                {
                    Log.v( TAG, "onCaptureCompleted( @NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result )" );

                    if ( mDisplayPreview )
                    {
                        mState = STATE_PREVIEW;
                    }
                    else
                    {
                        mBackgroundHandler.post( CameraTextureView.this::unlockFocus );
                    }
                }
            };

            mCaptureSession.stopRepeating();
            mCaptureSession.capture( captureBuilder.build(), captureCallback, null );
        }
        catch ( CameraAccessException e )
        {
            OnCameraErrorListener.handle( mCameraErrorCallback, e );
        }
    }

    protected int getOrientation()
    {
        Log.v( TAG, "getOrientation( int rotation )" );

        return ORIENTATIONS.get( mSensorOrientation );
    }

    static class CompareSizesByArea implements Comparator< Size >
    {
        @Override
        public int compare( Size lhs, Size rhs )
        {
            // We cast here to ensure the multiplications won't overflow
            return Long.signum( ( long ) lhs.getWidth() * lhs.getHeight() - ( long ) rhs.getWidth() * rhs.getHeight() );
        }
    }

    protected void startBackgroundThread()
    {
        Log.v( TAG, "startBackgroundThread()" );

        mBackgroundThread = new HandlerThread( TAG );
        mBackgroundThread.start();
        mBackgroundHandler = new Handler( mBackgroundThread.getLooper() );
    }

    protected void stopBackgroundThread()
    {
        Log.v( TAG, "stopBackgroundThread()" );

        if ( mBackgroundThread == null )
        {
            mBackgroundHandler = null;
            return;
        }
        mBackgroundThread.quitSafely();
        try
        {
            mBackgroundThread.join();
            mBackgroundThread = null;
            mBackgroundHandler = null;
        }
        catch ( InterruptedException e )
        {
            OnCameraErrorListener.handle( mCameraErrorCallback, e );
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent( MotionEvent event )
    {
        Log.v( TAG, "onTouchEvent( MotionEvent event )" );
        try
        {
            Rect rect = mCameraCharacteristics.get( CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE );
            if ( rect == null )
            {
                return super.onTouchEvent( event );
            }
            float currentFingerSpacing;

            int action = event.getAction();

            if ( ( action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP ) && mIsMultiTouch )
            {
                mIsMultiTouch = false;

                return false;
            }

            if ( event.getPointerCount() == 2 )
            { //Multi touch.
                currentFingerSpacing = getFingerSpacing( event );
                float delta = 0.05f;
                if ( mFingerSpacing != 0 )
                {
                    if ( currentFingerSpacing > mFingerSpacing )
                    {
                        if ( ( mMaximumZoomLevel - mZoomLevel ) <= delta )
                        {
                            delta = mMaximumZoomLevel - mZoomLevel;
                        }
                        mZoomLevel = mZoomLevel + delta;
                    }
                    else if ( currentFingerSpacing < mFingerSpacing )
                    {
                        if ( ( mZoomLevel - delta ) < 1f )
                        {
                            delta = mZoomLevel - 1f;
                        }
                        mZoomLevel = mZoomLevel - delta;
                    }
                    float ratio = 1f / mZoomLevel;

                    int croppedWidth = rect.width() - Math.round( ( float ) rect.width() * ratio );
                    int croppedHeight = rect.height() - Math.round( ( float ) rect.height() * ratio );

                    mZoom = new Rect( croppedWidth / 2, croppedHeight / 2,
                            rect.width() - croppedWidth / 2, rect.height() - croppedHeight / 2 );

                    mPreviewRequestBuilder.set( CaptureRequest.SCALER_CROP_REGION, mZoom );
                }
                mFingerSpacing = currentFingerSpacing;
                mCaptureSession.setRepeatingRequest( mPreviewRequestBuilder.build(), mCaptureCallback, null );
                mIsMultiTouch = true;
            }
        }
        catch ( Exception e )
        {
            OnCameraErrorListener.handle( mCameraErrorCallback, e );
        }
        return super.onTouchEvent( event );
    }

    protected float getFingerSpacing( MotionEvent event )
    {
        float x = event.getX( 0 ) - event.getX( 1 );
        float y = event.getY( 0 ) - event.getY( 1 );
        return ( float ) Math.sqrt( x * x + y * y );
    }

    protected static String controlAFStateToString( int controlAFState )
    {
        switch ( controlAFState )
        {
            case CaptureResult.CONTROL_AF_STATE_INACTIVE:
                return "inactive";
            case CaptureResult.CONTROL_AF_STATE_PASSIVE_SCAN:
                return "passive_scan";
            case CaptureResult.CONTROL_AF_STATE_PASSIVE_FOCUSED:
                return "passive_focused";
            case CaptureResult.CONTROL_AF_STATE_ACTIVE_SCAN:
                return "active_scan";
            case CaptureResult.CONTROL_AF_STATE_FOCUSED_LOCKED:
                return "focus_locked";
            case CaptureResult.CONTROL_AF_STATE_NOT_FOCUSED_LOCKED:
                return "not_focus_locked";
            case CaptureResult.CONTROL_AF_STATE_PASSIVE_UNFOCUSED:
                return "passive_unfocused";
            default:
                return "unknown";
        }
    }

    protected static String controlAEStateToString( int controlAEState )
    {
        switch ( controlAEState )
        {
            case CaptureResult.CONTROL_AE_STATE_INACTIVE:
                return "inactive";
            case CaptureResult.CONTROL_AE_STATE_SEARCHING:
                return "searching";
            case CaptureResult.CONTROL_AE_STATE_CONVERGED:
                return "converged";
            case CaptureResult.CONTROL_AE_STATE_LOCKED:
                return "locked";
            case CaptureResult.CONTROL_AE_STATE_FLASH_REQUIRED:
                return "flash_required";
            case CaptureResult.CONTROL_AE_STATE_PRECAPTURE:
                return "pre_capture";
            default:
                return "unknown";
        }
    }

}
