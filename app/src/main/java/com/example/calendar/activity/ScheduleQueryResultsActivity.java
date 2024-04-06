package com.example.calendar.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calendar.R;
import com.example.calendar.activity.Bean.ScheduleQueryBean;
import com.example.calendar.activity.adapter.ScheduleQueryResultsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 日程查询结果的界面
 */
public class ScheduleQueryResultsActivity extends AppCompatActivity {

    public static String QUERY_RESULT_KEY = "query_result_key";

    private RecyclerView rvQueryResultsView;
    private ScheduleQueryResultsAdapter adapter;
    private List<ScheduleQueryBean> listData = new ArrayList<ScheduleQueryBean>();

    private TextView btActivityResultsReturn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_query_results);
        initView();
        initListener();
        initData();

    }
    private void initView(){
        rvQueryResultsView =  findViewById(R.id.rv_query_results_view);
        btActivityResultsReturn =  findViewById(R.id.bt_activity_results_return);
    }

    private void initListener(){
        btActivityResultsReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData(){
        String qString = getIntent().getStringExtra(QUERY_RESULT_KEY);//传递过来的数据查询条件
        //目前填写一些假数据
        listData.add(new ScheduleQueryBean("数据1","北京","1111","11111"));
        listData.add(new ScheduleQueryBean("数据2","上海","1111","11111"));
        listData.add(new ScheduleQueryBean("数据3","广州","1111","11111"));
        //这里填写数据
         adapter = new ScheduleQueryResultsAdapter(listData);
        rvQueryResultsView.setAdapter(adapter);
    }

}
