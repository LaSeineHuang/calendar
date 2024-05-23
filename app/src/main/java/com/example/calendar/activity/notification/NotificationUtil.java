package com.example.calendar.activity.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;


import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.calendar.R;
import com.example.calendar.activity.MonthActivity;
import com.example.calendar.activity.bean.NotifiBean;


public class NotificationUtil {

    private Context context;
    private NotifiBean bean;

    private String mPath;
    private final String appName;

    public static String sharedChannelId = "sharedChannelId";
    public static String sharedChannelName = "sharedChannelName";
    public static String CHANNEL_ID = "id_0";
    public static String CHANNEL_NAME = "channel_name_2";

    public static String CHANNEL_IDService = "channel_idSer";
    public static String CHANNEL_IDWarn = "channel_idWarn";


    public NotificationUtil(Context context, NotifiBean bean) {
        this.context = context;
        this.bean = bean;
//        mPath = SharedPreUtils.create(context).getString(ConfigPush.notificationMusicPath, "android.resource://" + context.getPackageName() + "/" + R.raw.notice);
        PackageManager pm = context.getPackageManager();
        appName = context.getApplicationInfo().loadLabel(pm).toString();
    }


    public void setNofi() {
        NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Intent mainIntent = null;
            if (bean.getArouterType() == 887) {
                mainIntent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                mainIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
            } else {
                mainIntent = new Intent(context, MonthActivity.class);
                mainIntent.putExtra(ConfigPush.intentActData, String.valueOf(bean.getArouterType()));
                mainIntent.putExtra(ConfigPush.intentActBean,bean);
            }

            String CHANNEL_ID = initO_Notification(context);

            PendingIntent mainPendingIntent = PendingIntent.getActivity(context, 0, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID);
            try {
                builder.setContentTitle(appName+bean.getTitle())
                        .setContentIntent(mainPendingIntent)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentText(bean.getContent())
                        .setDefaults(android.app.Notification.DEFAULT_VIBRATE)
                        .setLights(0xFF0000, 3000, 3000)
//                        .setSound(Uri.parse(mPath))// 设置通道的时候设置了
                        .setAutoCancel(true);
                notifyManager.notify(bean.getType(), builder.build());
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        } else {
            Intent mainIntent = new Intent(context, MonthActivity.class);
            mainIntent.putExtra(ConfigPush.intentActData, String.valueOf(bean.getArouterType()));
            mainIntent.putExtra(ConfigPush.intentActBean,bean);
            PendingIntent mainPendingIntent = PendingIntent.getActivity(context, 0, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(appName)
                    .setContentText(bean.getContent())
                    .setContentIntent(mainPendingIntent)
                    .setDefaults(android.app.Notification.DEFAULT_VIBRATE)
                    .setLights(0xFF0000, 3000, 3000)
//                    .setSound(Uri.parse(mPath))
                    .setAutoCancel(true);
            notifyManager.notify(bean.getType(), builder.build());
        }
    }

    // app 启动时 初始化通知信道
    public void setSettingNotification() {
        NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Intent mainIntent = null;
            if (bean.getArouterType() == 887) {
                mainIntent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                mainIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
            }

            String CHANNEL_ID = settingNotifSound(context);
            PendingIntent mainPendingIntent = PendingIntent.getActivity(context, 0, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(appName)
                    .setContentText(bean.getContent())
                    .setContentIntent(mainPendingIntent)
                    .setDefaults(android.app.Notification.DEFAULT_VIBRATE)
                    .setLights(0xFF0000, 3000, 3000)
                    .setSound(Uri.parse(mPath))
                    .setAutoCancel(true);
            notifyManager.notify(bean.getType(), builder.build());
        }
    }


    public static boolean deleteNotification(Context context) {
        try {
            NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            String id = CHANNEL_ID;
//            String id = SharedPreUtils.create(context).getString(sharedChannelId, CHANNEL_ID);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notifyManager.deleteNotificationChannel(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.fillInStackTrace();
            return false;
        }
    }

    // 一下 appliction 中初始化
    public static String initO_ServiceNotification(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_IDService,
                    "name_service", NotificationManager.IMPORTANCE_MIN);
            notificationChannel.setShowBadge(false);
            notificationChannel.enableLights(false);

            try {
                PackageManager pm = context.getPackageManager();
                notificationChannel.setDescription(context.getApplicationInfo().loadLabel(pm).toString());
            } catch (Exception e) {
                e.fillInStackTrace();
            }

            if (notifyManager != null) {
                notifyManager.createNotificationChannel(notificationChannel);
            }
        }
        return CHANNEL_IDService;
    }

    public static String initO_Notification(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

//            String mPath = SharedPreUtils.create(context).getString(ConfigPush.notificationMusicPath, "android.resource://" + context.getPackageName() + "/" + R.raw.notice);
            NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            CHANNEL_ID = SharedPreUtils.create(context).getString(sharedChannelId, CHANNEL_ID);
            CHANNEL_NAME = SharedPreUtils.create(context).getString(sharedChannelName, CHANNEL_NAME);

            SharedPreUtils.create(context).putString(sharedChannelId, CHANNEL_ID);
            SharedPreUtils.create(context).putString(sharedChannelName, CHANNEL_NAME);

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setShowBadge(false);
            notificationChannel.enableLights(false);
//            notificationChannel.setSound(Uri.parse(mPath), null);

            try {
                PackageManager pm = context.getPackageManager();
                notificationChannel.setDescription(context.getApplicationInfo().loadLabel(pm).toString());
            } catch (Exception e) {
                e.fillInStackTrace();
            }
            if (notifyManager != null) {
                notifyManager.createNotificationChannel(notificationChannel);
            }
        }
        return CHANNEL_ID;
    }

    public static void initO_Notification(Context context, String id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            String mPath = SharedPreUtils.create(context).getString(ConfigPush.notificationMusicPath, "android.resource://" + context.getPackageName() + "/" + R.raw.notice);
            NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            SharedPreUtils.create(context).putString(sharedChannelId, id);
            SharedPreUtils.create(context).putString(sharedChannelName, CHANNEL_NAME);

            NotificationChannel notificationChannel = new NotificationChannel(id,
                    CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setShowBadge(false);
            notificationChannel.enableLights(false);
//            notificationChannel.setSound(Uri.parse(mPath), null);

            try {
                PackageManager pm = context.getPackageManager();
                notificationChannel.setDescription(context.getApplicationInfo().loadLabel(pm).toString());
            } catch (Exception e) {
                e.fillInStackTrace();
            }

            if (notifyManager != null) {
                notifyManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    public static String getNotificationId(Context context) {
        return SharedPreUtils.create(context).getString(sharedChannelId, CHANNEL_ID);
    }

    public static void setNotificationId(Context context, String msg) {
        initO_Notification(context, msg);
    }


    public static String settingNotifSound(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            String mPath = "android.resource://" + context.getPackageName() + "/" + R.raw.error;
            NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_IDWarn,
                    "name_warn", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setShowBadge(false);
            notificationChannel.enableLights(false);
//            notificationChannel.setSound(Uri.parse(mPath), null);

            try {
                PackageManager pm = context.getPackageManager();
                notificationChannel.setDescription( context.getApplicationInfo().loadLabel(pm).toString());
            }catch (Exception e){
                e.fillInStackTrace();
            }

            if (notifyManager != null) {
                notifyManager.createNotificationChannel(notificationChannel);
            }
        }
        return CHANNEL_IDWarn;
    }

    //    当通知总开关被关闭时即areNotificationsEnabled()返回false时，
//    渠道开关即areChannelsEnabled("")可能是true。
//    所以判断渠道版本开关前应该先判断总开关
    /*
     * 判断App通知是否打开(总开关)
     * true：开
     */
    public static boolean areNotificationsEnabled(Context context) {
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        return notificationManagerCompat.areNotificationsEnabled();
    }

    /*
     * 判断当前渠道通知是否打开
     * true：开
     */
    public static boolean areChannelsEnabled(@NonNull String channelId, Context context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            LogHelper.write("notification", "--SDK_INT-->" + Build.VERSION.SDK_INT);
//            Log.i("notification", "--SDK_INT-->" + Build.VERSION.SDK_INT);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelId);
            if (notificationChannel != null && notificationChannel.getImportance() == NotificationManager.IMPORTANCE_NONE) {
                return false;
            }
            return true;
        }
        return true;
    }

    /*
     * 跳转到渠道设置页
     */
    public static Intent gotoChannelSetting(@NonNull String channelId, @NonNull Context context) {
//        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
//        intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.getPackageName());
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));

//        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
//        intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.getPackageName());
        return intent;
//        intent.putExtra(Settings.EXTRA_CHANNEL_ID, channelId);
//        context.startActivity(intent);
    }

}
