package com.example.calendar.activity.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.calendar.activity.bean.NotifiBean;
import com.example.calendar.activity.dao.ScheduleQueryBean;
import com.example.calendar.activity.dao.StudentDaoOpen;
import com.example.calendar.activity.notification.NotificationUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


public class CheckService extends Service {

    private String channelId = "channel";
    private boolean isOnly = true;

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
        startForeground(1001, createNotification());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(isOnly){
            isOnly = false;
            checkDate();
        }
        return START_STICKY;
    }

    private void checkDate() {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy年MM月dd日");
        dff.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String ymd = dff.format(new Date());
//        Log.i("stf", "---ymd--->" + ymd);
        List<ScheduleQueryBean> list = StudentDaoOpen.queryAllByStartTimeLike(this, ymd);
        Log.i("stf", "--list--今日日程ymd->"+ymd+" "+ GsonUtils.toJson(list));
        if (!list.isEmpty()) {
            ToastUtils.showShort("今日有" + list.size() + "个日程 ");
            showNot(list, ymd);
        } else {
            ToastUtils.showShort("今日无日程 ");
        }
    }

    private void showNot(List<ScheduleQueryBean> list, String ymd) {
        for (int i = 0; i < list.size(); i++) {
            ScheduleQueryBean scheduleQueryBean = list.get(i);
            String title = scheduleQueryBean.getTitle();
            String startTime = scheduleQueryBean.getStartTime();
            String endTime = scheduleQueryBean.getEndTime();
            String location = scheduleQueryBean.getLocation();
            String remark = scheduleQueryBean.getRemark();
            not(title, location + "\r\n" + startTime.replace(ymd, "") + "~" + endTime.replace(ymd, "")+remark.replace(ymd, ""));
        }
    }

    private void not(String title, String msg) {
        int randomnum = (int) (Math.random() * 999);
        NotifiBean notifiBean = new NotifiBean();
        notifiBean.setContent(msg);
        notifiBean.setArouterType(1);
        notifiBean.setType(randomnum);
        notifiBean.setTitle(title);
        new NotificationUtil(this, notifiBean).setNofi();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, "Service", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private Notification createNotification() {
        return new NotificationCompat.Builder(this, channelId)
                .setContentTitle("日历")
                .setContentText("检查当天是否存在日程")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT).build();
    }
}
