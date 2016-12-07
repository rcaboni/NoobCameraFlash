package com.noob.noobcameraflash.Utilities;

import android.app.Activity;

/**
 * Created by Abhishek on 08-12-2016.
 */

public abstract class BaseCameraUtil implements CameraFlashUtility {
    private Activity mContext;
    private boolean isCameraPermissionGranted = false;

    //private boolean torchModeOn = false;
    private TorchMode mTorchMode = TorchMode.None;
    private TorchModeCallback mTorchModeCallback;

    //region Constructors
    public BaseCameraUtil(Activity context) {
        mContext = context;
    }
    //endregion

    //region Overrides
    @Override
    public boolean isFlashOn() {
        return mTorchMode == TorchMode.SwitchedOn;
    }

    @Override
    public void setTorchModeCallback(TorchModeCallback torchModeCallback) {
        mTorchModeCallback = torchModeCallback;
    }
    //endregion

    //protected methods
    protected void onCameraTorchModeChanged(TorchMode torchMode) {
        if (mTorchModeCallback != null) {
            mTorchModeCallback.onTorchModeChanged(torchMode);
        }
    }

    //endregion

    //region Accessors
    public TorchMode getTorchMode() {
        return mTorchMode;
    }

    protected void setTorchMode(TorchMode torchMode) {
        mTorchMode = torchMode;
    }

    /*protected void setTorchModeOn(boolean torchModeOn) {
        this.torchModeOn = torchModeOn;
        if (torchModeOn)
            onCameraTorchModeChanged(TorchMode.SwitchedOn);
        else
            onCameraTorchModeChanged(TorchMode.SwitchedOff);
    }*/

    protected boolean isCameraPermissionGranted() {
        return isCameraPermissionGranted;
    }

    protected void setCameraPermissionGranted(boolean cameraPermissionGranted) {
        isCameraPermissionGranted = cameraPermissionGranted;
    }
    //endregion
}