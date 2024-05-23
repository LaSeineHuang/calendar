package com.example.calendar.activity;

import static com.example.calendar.activity.AddScheduleActivity.ADD_SCHEDULE_BEAN_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.GsonUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.calendar.R;
import com.example.calendar.activity.adapter.ScheduleQueryResultsAdapter;
import com.example.calendar.activity.dao.ScheduleQueryBean;
import com.example.calendar.activity.dao.StudentDaoOpen;

import java.util.ArrayList;
import java.util.List;

/**
 * 日程查询结果的界面
 */
public class ScheduleQueryResultsActivity extends AppCompatActivity {

    public static String QUERY_RESULT_KEY = "query_result_key";
    public static String QUERY_TYPE_KEY = "query_result_type";

    public static String QUERY_TYPE_TITLE = "query_result_title";
    public static String QUERY_TYPE_START_TIME = "query_result_start_time";
    public static String QUERY_TYPE_END_TIME = "query_type_end_time";

    private RecyclerView rvQueryResultsView;
    private ScheduleQueryResultsAdapter adapter;
    private List<ScheduleQueryBean> listData = new ArrayList<ScheduleQueryBean>();

    private TextView btActivityResultsReturn;
    private String qString;
    private String type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_query_results);
        initView();
        initListener();

        //传递过来的数据查询条件
        qString = getIntent().getStringExtra(QUERY_RESULT_KEY);
        //传递过来的数据的类型
        type = getIntent().getStringExtra(QUERY_TYPE_KEY);
        initData();

    }
    private void initView(){
        rvQueryResultsView =  findViewById(R.id.rv_query_results_view);
        btActivityResultsReturn =  findViewById(R.id.bt_activity_results_return);
        adapter = new ScheduleQueryResultsAdapter(listData);
        rvQueryResultsView.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                ScheduleQueryBean queryBean = listData.get(position);
                Intent intent = new Intent(ScheduleQueryResultsActivity.this, AddScheduleActivity.class);
                intent.putExtra(ADD_SCHEDULE_BEAN_KEY, GsonUtils.toJson(queryBean));
                startActivityForResult(intent, 10001);
            }
        });
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
        Log.i("stf","---qString--->"+ qString +"----QUERY_TYPE_KEY-->"+type);
        listData.clear();
        if(type.equals(QUERY_TYPE_TITLE)){
            List<ScheduleQueryBean> list = StudentDaoOpen.queryAllByTitleLike(ScheduleQueryResultsActivity.this, qString);
            listData.addAll(list);
        }
        Log.i("stf","---listData--->"+ GsonUtils.toJson(listData));
        //这里填写数据
        adapter.setList(listData);
        adapter.notifyDataSetChanged();

        //目前填写一些假数据
//        listData.add(new ScheduleQueryBean("数据1","北京","1111","11111"));
//        listData.add(new ScheduleQueryBean("数据2","上海","1111","11111"));
//        listData.add(new ScheduleQueryBean("数据3","广州","1111","11111"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10001 && resultCode == RESULT_OK && data != null) {
            //这里是添加日程返回来的数据
            initData();
        }
    }

}
