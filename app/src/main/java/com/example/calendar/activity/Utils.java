package com.example.calendar.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;


public class Utils {

    /**
     * 获取当前版本信息.
     *
     * @param context
     */
    public static String getCurrentVersion(Context context) {
        String versionName = "";
        try {
            final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }


}
