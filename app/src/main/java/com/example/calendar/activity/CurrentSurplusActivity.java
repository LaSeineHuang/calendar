package com.example.calendar.activity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calendar.R;
import com.example.calendar.activity.adapter.CurrentSurplusAdapter;
import com.example.calendar.activity.adapter.ScheduleQueryResultsAdapter;

/**
 * 当前算余积月界面
 */
public class CurrentSurplusActivity extends AppCompatActivity  {

    private RecyclerView rvActivityCurrentView;
    private CurrentSurplusAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_surplus);
        initView();
        initData();
        rvActivityCurrentView =  findViewById(R.id.rv_activity_current_view);

    }

    private void initView(){
        rvActivityCurrentView.setAdapter(adapter);
    }

    private void initData(){
        //这里填写数据
        // adapter = new CurrentSurplusAdapter();
    }
}
