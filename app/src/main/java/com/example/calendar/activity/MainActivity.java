package com.example.calendar.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.necer.enumeration.CheckModel;

import com.example.calendar.R;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvVersion = (TextView) findViewById(R.id.tv_version);
        tvVersion.setText("版本：" + Utils.getCurrentVersion(this));
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


}