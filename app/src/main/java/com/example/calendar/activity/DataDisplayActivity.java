package com.example.calendar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.calendar.R;
import com.example.calendar.activity.bean.DataDisplayOne;
import com.example.calendar.activity.bean.DataDisplayTwo;
import com.example.calendar.activity.adapter.DataDisplayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 当日藏历天文数据界面
 */
public class DataDisplayActivity extends AppCompatActivity {
    private RecyclerView rvActivityDataView;
    private DataDisplayAdapter adapter;
    private TextView dateTextView;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        // 从Intent中获取年月日
        Intent intent = getIntent();
        int year = intent.getIntExtra("YEAR", -1); // 默认值为-1表示没有数据
        int month = intent.getIntExtra("MONTH", -1);
        int day = intent.getIntExtra("DAY", -1);
        // 使用这些数据来初始化界面或做其他操作

        initView();
        if (dateTextView != null) {
            dateTextView.setText(year + "年" + month + "月" + day + "日");
        }
        initData();

    }

    private void initView(){
        //当前的界面的布局整体为一个RecyclerView
        rvActivityDataView =  findViewById(R.id.rv_activity_data_view);

    }

    private void initData(){
        List<MultiItemEntity> data =  new ArrayList<>();
        data.add( new DataDisplayOne());
        data.add( new DataDisplayTwo());
        //这里填写数据
         adapter = new DataDisplayAdapter(data);
        rvActivityDataView.setAdapter(adapter);
    }
}
