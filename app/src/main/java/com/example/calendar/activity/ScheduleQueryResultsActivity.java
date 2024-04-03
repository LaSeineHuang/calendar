package com.example.calendar.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calendar.R;
import com.example.calendar.activity.adapter.ScheduleQueryResultsAdapter;

/**
 * 日程查询结果的界面
 */
public class ScheduleQueryResultsActivity extends AppCompatActivity {

    private RecyclerView rvQueryResultsView;
    private ScheduleQueryResultsAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_query_results);
        initView();
        initData();
        rvQueryResultsView =  findViewById(R.id.rv_query_results_view);
    }
    private void initView(){
        rvQueryResultsView.setAdapter(adapter);
    }

    private void initData(){
        //这里填写数据
        // adapter = new ScheduleQueryResultsAdapter();
    }

}
