package com.example.calendar.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calendar.R;
import com.example.calendar.activity.Bean.ScheduleQueryBean;
import com.example.calendar.activity.dialog.DialogUtils;
import com.example.calendar.activity.dialog.IConfirmAndCancelCallBack;

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

    private TextView btAddReturn,tvAddConfirm;//返回、确认

    private EditText etTitleView,etLocaleView;

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
                //点击确认按钮,回调数据
                ScheduleQueryBean queryBean =  new ScheduleQueryBean(etTitleView.getText().toString(),
                        etLocaleView.getText().toString(),
                        etStartQueryTime.getText().toString(),
                        etEndQueryTime.getText().toString());
                Intent intent = new Intent();
                intent.putExtra(ADD_SCHEDULE_BEAN_KEY,queryBean);
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

    }
}
