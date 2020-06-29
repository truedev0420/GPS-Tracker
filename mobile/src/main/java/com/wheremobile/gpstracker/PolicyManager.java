package com.wheremobile.gpstracker;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;

public class PolicyManager {

    public static final int DPM_ACTIVATION_REQUEST_CODE = 1;

    private Context mContext;
    private DevicePolicyManager mDPM;
    private ComponentName adminComponent;

    public PolicyManager(Context context) {
        // TODO Auto-generated constructor stub
        this.mContext = context;
        mDPM = (DevicePolicyManager) mContext
                .getSystemService(Context.DEVICE_POLICY_SERVICE);
        /*adminComponent = new ComponentName(mContext.getPackageName(),
				mContext.getPackageName() + ".SampleDeviceAdminReceiver");*/
        adminComponent = new ComponentName(context, SampleDeviceAdminReceiver.class);
    }

    public boolean isAdminActive() {
        return mDPM.isAdminActive(adminComponent);
    }

    public ComponentName getAdminComponent() {
        return adminComponent;
    }

    public void disableAdmin() {
        mDPM.removeActiveAdmin(adminComponent);
    }

}
