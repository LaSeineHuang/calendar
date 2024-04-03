package com.example.calendar.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calendar.R;
import com.example.calendar.activity.adapter.CurrentSurplusAdapter;
import com.example.calendar.activity.adapter.DataDisplayAdapter;

/**
 * 当日藏历天文数据界面
 */
public class DataDisplayActivity extends AppCompatActivity {
    private RecyclerView rvActivityDataView;
    private DataDisplayAdapter adapter;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);

        initView();
        initData();
        //当前的界面的布局整体为一个RecyclerView
        rvActivityDataView =  findViewById(R.id.rv_activity_data_view);
    }

    private void initView(){
        rvActivityDataView.setAdapter(adapter);
    }

    private void initData(){
        //这里填写数据
        // adapter = new DataDisplayAdapter();
    }
}
