package com.example.calendar.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calendar.R;
import com.example.calendar.activity.bean.CurrentSurplusBean;
import com.example.calendar.activity.adapter.CurrentSurplusAdapter;

import java.util.ArrayList;
import java.util.List;

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
    }

    private void initView(){
        rvActivityCurrentView =  findViewById(R.id.rv_activity_current_view);

    }

    private void initData(){
        List<CurrentSurplusBean> data = new ArrayList<>();
        data.add(new CurrentSurplusBean("3","256","43"));
        data.add(new CurrentSurplusBean("4","257","45"));
        data.add(new CurrentSurplusBean("5","258","47"));
        data.add(new CurrentSurplusBean("6","259","49"));
        data.add(new CurrentSurplusBean("6闰月","260","-"));
        data.add(new CurrentSurplusBean("7","261","53"));
        data.add(new CurrentSurplusBean("8","262","55"));
        data.add(new CurrentSurplusBean("9","263","57"));
        data.add(new CurrentSurplusBean("10","264","59"));
        data.add(new CurrentSurplusBean("11","265","61"));
        data.add(new CurrentSurplusBean("12","266","63"));
        data.add(new CurrentSurplusBean("1","267","65"));
        data.add(new CurrentSurplusBean("2","268","0"));
        //这里填写数据
         adapter = new CurrentSurplusAdapter(data);
        rvActivityCurrentView.setAdapter(adapter);
    }
}
