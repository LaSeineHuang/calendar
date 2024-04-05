package com.example.calendar.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calendar.R;
import com.example.calendar.activity.dialog.DialogUtils;

/**
 * 新建日程界面
 */
public class AddScheduleActivity extends AppCompatActivity {

    private EditText etStartQueryTime;//输入开始日期
    private EditText etEndQueryTime;//输入结束日期

    private ImageView ivStartQueryImage;//点击开始日期按钮
    private ImageView ivEndQueryImage;//点击结束日期按钮

    private Button btAddCancel;//取消

    private TextView btAddReturn,tvAddConfirm;//返回、确认

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
        initView();
        initData();
    }
    private void initView(){
        etStartQueryTime = findViewById(R.id.et_start_query_time);
        etEndQueryTime = findViewById(R.id.et_start_query_time);

        ivStartQueryImage = findViewById(R.id.iv_start_query_image);
        ivEndQueryImage = findViewById(R.id.iv_end_query_image);
        btAddCancel = findViewById(R.id.bt_add_cancel);
        btAddReturn = findViewById(R.id.bt_add_return);
        tvAddConfirm = findViewById(R.id.tv_add_confirm);
        tvAddConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击确认按钮,回调数据

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
                DialogUtils.showDatePickerDialog(AddScheduleActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //当选择完后将时间显示,记得月份i1加一
                        etStartQueryTime.setText(year + "年" + (month+1) + "月" + dayOfMonth + "日");

                    }
                });
            }
        });
        //点击结束日期选择
        ivEndQueryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showDatePickerDialog(AddScheduleActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //当选择完后将时间显示,记得月份i1加一
                        etEndQueryTime.setText(year + "年" + (month+1) + "月" + dayOfMonth + "日");
                    }
                });
            }
        });
    }

    private void initData(){

    }
}
