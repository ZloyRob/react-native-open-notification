package com.riwu.notification.open;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.content.res.ResourcesCompat;
import android.util.Log;

class OpenNotificationConfig {
    private static final String KEY_CHANNEL_ID = "com.dieam.reactnativepushnotification.notification_channel_id";
    private static final String KEY_CHANNEL_NAME = "com.dieam.reactnativepushnotification.notification_channel_name";
    private static final String KEY_CHANNEL_DESCRIPTION = "com.dieam.reactnativepushnotification.notification_channel_description";
    private static final String KEY_NOTIFICATION_COLOR = "com.dieam.reactnativepushnotification.notification_color";

    private static Bundle metadata;
    private Context context;

    public OpenNotificationConfig(Context context) {
        this.context = context;
        if (metadata == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
                metadata = applicationInfo.metaData;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                Log.e(OpenNotificationModule.LOG_TAG, "Error reading application meta, falling back to defaults");
                metadata = new Bundle();
            }
        }
    }

    public String getChannelId() {
        String channelId = null;
        try {
            channelId = metadata.getString(KEY_CHANNEL_ID);
        } catch (Exception e) {
            Log.w(OpenNotificationModule.LOG_TAG, "Unable to find " + KEY_CHANNEL_ID + " in manifest. Falling back to default");
        }
        // Default
        if (channelId == null)
            channelId = "rn-push-notification-channel-id";
        return channelId;
    }
    public String getChannelName() {
        String channelName = null;
        try {
            channelName = metadata.getString(KEY_CHANNEL_NAME);
        } catch (Exception e) {
            Log.w(OpenNotificationModule.LOG_TAG, "Unable to find " + KEY_CHANNEL_NAME + " in manifest. Falling back to default");
        }
        // Default
        if (channelName == null)
            channelName = "rn-push-notification-channel";
        return channelName;
    }
    public String getChannelDescription() {
        String channelDescription = null;
        try {
            channelDescription = metadata.getString(KEY_CHANNEL_DESCRIPTION);
        } catch (Exception e) {
            Log.w(OpenNotificationModule.LOG_TAG, "Unable to find " + KEY_CHANNEL_DESCRIPTION + " in manifest. Falling back to default");
        }
        // Default
        if (channelDescription == null)
            channelDescription = "";
        return channelDescription;
    }
}
