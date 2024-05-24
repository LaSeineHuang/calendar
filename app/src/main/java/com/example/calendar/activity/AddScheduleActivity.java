package com.example.calendar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.calendar.R;
import com.example.calendar.activity.dao.ScheduleQueryBean;
import com.example.calendar.activity.dao.StudentDaoOpen;
import com.example.calendar.activity.dialog.DialogUtils;
import com.example.calendar.activity.dialog.IConfirmAndCancelCallBack;

import java.io.Serializable;

/**
 * 新建日程界面
 */
public class AddScheduleActivity extends AppCompatActivity {

    public static String ADD_SCHEDULE_BEAN_KEY = "add_schedule_bean_key";

    private TextView etStartQueryTime;//输入开始日期
    private TextView etEndQueryTime;//输入结束日期

    private ImageView ivStartQueryImage;//点击开始日期按钮
    private ImageView ivEndQueryImage;//点击结束日期按钮

    private Button btAddCancel;//取消

    private TextView tvAddConfirm;//确认

    private TextView titleTv;//标题

    private ImageView btAddReturn;//返回

    private EditText etTitleView,etLocaleView,markEdit;
    private ScheduleQueryBean scheduleQueryBean;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
        initView();
        initData();
    }
    private void initView(){
        etStartQueryTime = findViewById(R.id.et_start_query_time);
        etEndQueryTime = findViewById(R.id.et_end_query_time);
        markEdit = findViewById(R.id.mark_edit);

        titleTv = findViewById(R.id.title_tv);
        ivStartQueryImage = findViewById(R.id.iv_start_query_image);
        ivEndQueryImage = findViewById(R.id.iv_end_query_image);
        btAddCancel = findViewById(R.id.bt_add_cancel);
        btAddReturn = findViewById(R.id.bt_add_return);
        tvAddConfirm = findViewById(R.id.tv_add_confirm);
        etTitleView = findViewById(R.id.et_title_view);
        etLocaleView = findViewById(R.id.et_locale_view);
        tvAddConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StringUtils.isEmpty(etTitleView.getText().toString())
                        ||StringUtils.isEmpty(etLocaleView.getText().toString())
                        ||StringUtils.isEmpty(etStartQueryTime.getText().toString())
                        ||StringUtils.isEmpty(etEndQueryTime.getText().toString())){
                    ToastUtils.showLong("填写数据不得为空!");
                    return;
                }

                //点击确认按钮,回调数据
                if(scheduleQueryBean == null){
                    ScheduleQueryBean queryBean =  new ScheduleQueryBean(etTitleView.getText().toString(),
                            etLocaleView.getText().toString(),
                            etStartQueryTime.getText().toString(),
                            etEndQueryTime.getText().toString());
                    StudentDaoOpen.insertData(AddScheduleActivity.this,queryBean);
                }else {
                    scheduleQueryBean.setTitle(etTitleView.getText().toString());
                    scheduleQueryBean.setLocation(etLocaleView.getText().toString());
                    scheduleQueryBean.setStartTime(etStartQueryTime.getText().toString());
                    scheduleQueryBean.setEndTime(etEndQueryTime.getText().toString());
                    StudentDaoOpen.saveData(AddScheduleActivity.this,scheduleQueryBean);
                }

                Intent intent = new Intent();
//                intent.putExtra(ADD_SCHEDULE_BEAN_KEY,queryBean);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btAddCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btAddReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //点击开始日期选择
        ivStartQueryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showDateTimePickerDialog(AddScheduleActivity.this, new IConfirmAndCancelCallBack() {
                    @Override
                    public void confirm(String content) {
                        etStartQueryTime.setText(content);
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        });
        //点击结束日期选择
        ivEndQueryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogUtils.showDateTimePickerDialog(AddScheduleActivity.this, new IConfirmAndCancelCallBack() {
                    @Override
                    public void confirm(String content) {
                        etEndQueryTime.setText(content);
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        });
    }

    private void initData(){
        String json = getIntent().getStringExtra(ADD_SCHEDULE_BEAN_KEY);
        if(!TextUtils.isEmpty(json)){
            scheduleQueryBean = GsonUtils.fromJson(json, ScheduleQueryBean.class);
        }

        if(scheduleQueryBean != null){
            titleTv.setText("修改日程");
            etTitleView.setText(scheduleQueryBean.getTitle());
            etLocaleView.setText(scheduleQueryBean.getLocation());
            etStartQueryTime.setText(scheduleQueryBean.getStartTime());
            etEndQueryTime.setText(scheduleQueryBean.getEndTime());
        }
    }
}