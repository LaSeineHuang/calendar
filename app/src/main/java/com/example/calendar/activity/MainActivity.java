package com.example.calendar.activity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.calendar.activity.service.CheckService;
import com.necer.enumeration.CheckModel;

import com.example.calendar.R;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvVersion = (TextView) findViewById(R.id.tv_version);
        tvVersion.setText("版本：" + Utils.getCurrentVersion(this));
        //先停止再启动
        stopCheckService();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startCheckService();
            }
        }, 500);
    }
    public void huang(View view) {
        startActivity(getNewIntent(MonthActivity.class, CheckModel.SINGLE_DEFAULT_CHECKED, "小黄的东东"));
    }
    private Intent getNewIntent(Class<? extends BaseActivity> clazz, CheckModel checkModel, String title) {
        Intent intent = new Intent(this, clazz);
        intent.putExtra("selectedModel", checkModel);
        intent.putExtra("title", title);
        return intent;
    }


    //启动服务
    public void startCheckService() {
        Intent intent = new Intent(this, CheckService.class);
        if (!isServiceRunning(CheckService.class)) {
            ContextCompat.startForegroundService(MainActivity.this, intent);
        }
    }

    //停止服务
    public void stopCheckService() {
        try {
            Intent intent = new Intent(MainActivity.this, CheckService.class);
            stopService(intent);
        } catch (Exception e) {
            e.getMessage();
        }
    }


    //判断服务是否在运行
    private Boolean isServiceRunning(Class<CheckService> service) {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> runningServices = manager.getRunningServices(Integer.MAX_VALUE);
        for (int i = 0; i < runningServices.size(); i++) {
            if (runningServices.get(i).service.getClassName().equals(service.getClass().getName())) {
                return true;
            }
        }

        return false;
    }
}