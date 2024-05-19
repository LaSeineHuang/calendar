package com.example.calendar.activity;

import android.os.Bundle;

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
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);

        initView();
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
