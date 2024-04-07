package com.example.calendar.activity;

import static com.example.calendar.activity.AddScheduleActivity.ADD_SCHEDULE_BEAN_KEY;
import static com.example.calendar.activity.ScheduleQueryResultsActivity.QUERY_RESULT_KEY;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calendar.R;
import com.example.calendar.activity.Bean.ScheduleQueryBean;
import com.example.calendar.activity.adapter.ScheduleQueryResultsAdapter;
import com.example.calendar.activity.cumulativeDATA.Cumulative;
import com.example.calendar.activity.cumulativeDATA.TingYear;
import com.example.calendar.activity.dialog.DialogUtils;
import com.example.calendar.activity.dialog.IConfirmAndCancelCallBack;
import com.necer.calendar.BaseCalendar;
import com.necer.calendar.HuangCalendar;
import com.necer.calendar.Miui10Calendar;
import com.necer.entity.CalendarDate;
import com.necer.entity.Lunar;
import com.necer.enumeration.DateChangeBehavior;
import com.necer.listener.OnCalendarChangedListener;
import com.necer.listener.OnCalendarMultipleChangedListener;
//import com.necer.ncalendar.R;
import com.necer.painter.InnerPainter;
import com.necer.utils.CalendarUtil;
import com.necer.view.WeekBar;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by necer on 2018/11/12.
 * updata by huang on 2024/3/27
 */
public class MonthActivity<activity_month> extends BaseActivity {

    private HuangCalendar miui10Calendar;

    private TextView tv_result;
    private TextView tv_data;
    private TextView tv_desc;
    private TextView ivScheduleAdd;

    private FrameLayout flActivityMonthQuery;

    private TextView tv_zang;//显示藏历

    private Button searchButton,btSchedule,btMonthView;

    private NestedScrollView svActivityMonthView;

    private RecyclerView rvActivityMonthQuery;
    private WeekBar wbActivityMonthView;


    private List<ScheduleQueryBean> listData = new ArrayList<ScheduleQueryBean>();//查询日程对应的数据
    private ScheduleQueryResultsAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);
        initView();
        initListener();
        initData();
    }

    private void initView(){
        tv_result = findViewById(R.id.tv_result);
        tv_data = findViewById(R.id.tv_data);
        tv_desc = findViewById(R.id.tv_desc);
        tv_zang = findViewById(R.id.tv_zang);
        btMonthView = findViewById(R.id.bt_monthView);
        btSchedule = findViewById(R.id.bt_schedule);
        svActivityMonthView = findViewById(R.id.sv_activity_month_view);
        rvActivityMonthQuery = findViewById(R.id.rv_activity_month_query);
        wbActivityMonthView = findViewById(R.id.wb_activity_month_view);
        flActivityMonthQuery = findViewById(R.id.fl_activity_month_query);
        ivScheduleAdd = findViewById(R.id.iv_schedule_add);


        List<String> pointList = Arrays.asList("2018-10-01", "2018-11-19", "2018-11-20", "2018-05-23", "2019-01-01", "2018-12-23");

        miui10Calendar = findViewById(R.id.huangCalendar);
        miui10Calendar.setCheckMode(checkModel);
        InnerPainter innerPainter = (InnerPainter) miui10Calendar.getCalendarPainter();
        innerPainter.setPointList(pointList);


//        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
//        miui10Calendar.setMonthCalendarBackground(new CalendarBackground() {
//            @Override
//            public Drawable getBackgroundDrawable(LocalDate localDate, int currentDistance, int totalDistance) {
//                return drawable;
//            }
//        });


        Map<String, String> strMap = new HashMap<>();
        strMap.put("2019-01-25", "测试");
        strMap.put("2019-01-23", "测试1");
        strMap.put("2019-01-24", "测试2");
        innerPainter.setReplaceLunarStrMap(strMap);

        Map<String, Integer> colorMap = new HashMap<>();
        colorMap.put("2019-08-25", Color.RED);

        colorMap.put("2019-08-5", Color.parseColor("#000000"));
        innerPainter.setReplaceLunarColorMap(colorMap);


        List<String> holidayList = new ArrayList<>();
        holidayList.add("2019-7-20");
        holidayList.add("2019-7-21");
        holidayList.add("2019-7-22");

        List<String> workdayList = new ArrayList<>();
        workdayList.add("2019-7-23");
        workdayList.add("2019-7-24");
        workdayList.add("2019-7-25");

        innerPainter.setLegalHolidayList(holidayList, workdayList);
    }
    private void initListener(){
        miui10Calendar.setOnCalendarChangedListener(new OnCalendarChangedListener() {
            @Override
            public void onCalendarChange(BaseCalendar baseCalendar, int year, int month, LocalDate localDate, DateChangeBehavior dateChangeBehavior) {
                tv_result.setText(year + "年" + month + "月" + "   当前页面选中 " + localDate);
                Log.d(TAG, "   当前页面选中 " + localDate);
                Log.d(TAG, "   dateChangeBehavior " + dateChangeBehavior);

                Log.e(TAG, "baseCalendar::" + baseCalendar);
                TingYear tingYear = Cumulative.mainCumulative(year,month);
                tv_zang.setText("藏历："+tingYear.getYear() + "年" + tingYear.getMonth() + "月" );
                if (localDate != null) {
                    CalendarDate calendarDate = CalendarUtil.getCalendarDate(localDate);
                    Lunar lunar = calendarDate.lunar;
                    tv_data.setText(localDate.toString("yyyy年MM月dd日"));
                    tv_desc.setText(lunar.chineseEra + lunar.animals + "年" + lunar.lunarMonthStr + lunar.lunarDayStr);
                } else {
                    tv_data.setText("");
                    tv_desc.setText("");
                }
            }

        });
        miui10Calendar.setOnCalendarMultipleChangedListener(new OnCalendarMultipleChangedListener() {
            @Override
            public void onCalendarChange(BaseCalendar baseCalendar, int year, int month, List<LocalDate> currPagerCheckedList, List<LocalDate> totalCheckedList, DateChangeBehavior dateChangeBehavior) {
                tv_result.setText(year + "年" + month + "月" + " 当前页面选中 " + currPagerCheckedList.size() + "个  总共选中" + totalCheckedList.size() + "个");
                Log.d(TAG, year + "年" + month + "月");
                Log.d(TAG, "当前页面选中：：" + currPagerCheckedList);
                Log.d(TAG, "全部选中：：" + totalCheckedList);
            }

        });
        // 找到Search按钮并设置点击监听器
        searchButton = findViewById(R.id.Search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();
            }
        });

        btSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击日程
                flActivityMonthQuery.setVisibility(View.VISIBLE);
                miui10Calendar.setVisibility(View.GONE);
                tv_result.setVisibility(View.GONE);
                wbActivityMonthView.setVisibility(View.GONE);
            }
        });
        btMonthView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击月
                flActivityMonthQuery.setVisibility(View.GONE);
                miui10Calendar.setVisibility(View.VISIBLE);
                tv_result.setVisibility(View.VISIBLE);
                wbActivityMonthView.setVisibility(View.VISIBLE);
            }
        });
        //点击添加新日程的按钮
        ivScheduleAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到添加日程界面
                Intent intent = new Intent(MonthActivity.this,AddScheduleActivity.class);
                MonthActivity.this.startActivityForResult(intent,10001);
            }
        });
    }
    private void initData(){

        //这里目前设置的查询的假数据
        listData.add(new ScheduleQueryBean("数据1","北京","1111","11111"));
        listData.add(new ScheduleQueryBean("数据2","上海","1111","11111"));
        listData.add(new ScheduleQueryBean("数据3","广州","1111","11111"));
        //这里填写数据
        adapter = new ScheduleQueryResultsAdapter(listData);
        rvActivityMonthQuery.setAdapter(adapter);
    }



    private void showOptionsDialog() {
        // 创建AlertDialog.Builder对象
        AlertDialog.Builder builder = new AlertDialog.Builder(MonthActivity.this);

        // 定义选项和点击事件监听器
        CharSequence[] options = {"跳转到指定日期", "查询日程"};
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    // “跳转到指定日期”选项被选中
                    // 在这里添加跳转逻辑
//                    Toast.makeText(MonthActivity.this, "跳转到指定日期", Toast.LENGTH_SHORT).show();
                    DialogUtils.showDatePickerDialog(MonthActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            //当选择完后将时间显示,记得月份i1加一
//                            etEndQueryTime.setText(year + "年" + (month+1) + "月" + dayOfMonth + "日");
                            flActivityMonthQuery.setVisibility(View.GONE);
                            miui10Calendar.setVisibility(View.VISIBLE);
                            tv_result.setVisibility(View.VISIBLE);
                            wbActivityMonthView.setVisibility(View.VISIBLE);
                            miui10Calendar.jumpDate(year,month+1,dayOfMonth);
                        }
                    });
                } else if (which == 1) {
                    // “查询日程”选项被选中
                    // 在这里添加查询逻辑
//                    Toast.makeText(MonthActivity.this, "查询日程", Toast.LENGTH_SHORT).show();
                    DialogUtils.showDateQueryDialog(MonthActivity.this, new IConfirmAndCancelCallBack() {
                        @Override
                        public void confirm(String content) {
                            //跳转到日程查询结果界面
                            Intent intent = new Intent(MonthActivity.this,ScheduleQueryResultsActivity.class);
                            intent.putExtra(QUERY_RESULT_KEY,content);
                            MonthActivity.this.startActivity(intent);
                        }

                        public void cancel() {

                        }
                    });
                }
            }
        });

        // 创建并显示AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            // 这里可以调整位置，例如：
            layoutParams.gravity = Gravity.TOP | Gravity.LEFT; // 设置为顶部左侧
            layoutParams.x = 700; // 从左侧边缘向右侧移动700像素
            layoutParams.y = 300; // 从顶部向下移动300像素
            layoutParams.width = 700; // 宽度设置为700像素
            layoutParams.height = 400; // 高度设置为400像素

            window.setAttributes(layoutParams);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10001 && resultCode == RESULT_OK && data!= null){
            //这里是添加日程返回来的数据
            ScheduleQueryBean bean = (ScheduleQueryBean) data.getSerializableExtra(ADD_SCHEDULE_BEAN_KEY);
            adapter.addData(bean);
        }
    }
}
