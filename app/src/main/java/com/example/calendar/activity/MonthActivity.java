package com.example.calendar.activity;

import static com.example.calendar.activity.AddScheduleActivity.ADD_SCHEDULE_BEAN_KEY;
import static com.example.calendar.activity.ScheduleQueryResultsActivity.QUERY_RESULT_KEY;
import static com.example.calendar.activity.ScheduleQueryResultsActivity.QUERY_TYPE_KEY;
import static com.example.calendar.activity.ScheduleQueryResultsActivity.QUERY_TYPE_START_TIME;
import static com.example.calendar.activity.ScheduleQueryResultsActivity.QUERY_TYPE_TITLE;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.PointerIcon;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.GsonUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.calendar.R;
import com.example.calendar.activity.adapter.MonthQueryResultsAdapter;
import com.example.calendar.activity.dao.ScheduleQueryBean;
import com.example.calendar.activity.adapter.ScheduleQueryResultsAdapter;
import com.example.calendar.activity.cumulativeDATA.Cumulative;
import com.example.calendar.activity.cumulativeDATA.TingYear;
import com.example.calendar.activity.dao.StudentDaoOpen;
import com.example.calendar.activity.dialog.DialogUtils;
import com.example.calendar.activity.dialog.IConfirmAndCancelCallBack;
import com.necer.calendar.BaseCalendar;
import com.necer.calendar.HuangCalendar;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;


/**
 * Created by necer on 2018/11/12.
 * updata by huang on 2024/3/27
 */
public class MonthActivity<activity_month> extends BaseActivity {

    private HuangCalendar miui10Calendar;

    private TextView tv_result;
    private TextView tv_data;
    private TextView tv_desc;
    private ImageView ivScheduleAdd;

    private FrameLayout flActivityMonthQuery;

    private TextView tv_zang, contentTv;//显示藏历

    private Button searchButton, btSchedule, btMonthView, yearView;

    private NestedScrollView svActivityMonthView;

    private RecyclerView rvActivityMonthQuery;
    private WeekBar wbActivityMonthView;


    private List<ScheduleQueryBean> listData = new ArrayList<ScheduleQueryBean>();//查询日程对应的数据
    private MonthQueryResultsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);
        initView();
        initListener();

        //这里填写数据
        adapter = new MonthQueryResultsAdapter(listData);
        rvActivityMonthQuery.setAdapter(adapter);

        adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                ScheduleQueryBean queryBean = listData.get(position);
                Intent intent = new Intent(MonthActivity.this, AddScheduleActivity.class);
                intent.putExtra(ADD_SCHEDULE_BEAN_KEY, GsonUtils.toJson(queryBean));
                MonthActivity.this.startActivityForResult(intent, 10001);
            }
        });

        initData();
    }

    private void initView() {
        tv_result = findViewById(R.id.tv_result);
        tv_data = findViewById(R.id.tv_data);
        tv_desc = findViewById(R.id.tv_desc);
        tv_zang = findViewById(R.id.tv_zang);
        contentTv = findViewById(R.id.content_tv);
        btMonthView = findViewById(R.id.bt_monthView);
        btSchedule = findViewById(R.id.bt_schedule);
        svActivityMonthView = findViewById(R.id.sv_activity_month_view);
        rvActivityMonthQuery = findViewById(R.id.rv_activity_month_query);
        wbActivityMonthView = findViewById(R.id.wb_activity_month_view);
        flActivityMonthQuery = findViewById(R.id.fl_activity_month_query);
        ivScheduleAdd = findViewById(R.id.iv_schedule_add);
        yearView = findViewById(R.id.yearView);


//        List<String> pointList = Arrays.asList("2024-5-25", "2024-5-23");
        miui10Calendar = findViewById(R.id.huangCalendar);
        miui10Calendar.setCheckMode(checkModel);

//        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
//        miui10Calendar.setMonthCalendarBackground(new CalendarBackground() {
//            @Override
//            public Drawable getBackgroundDrawable(LocalDate localDate, int currentDistance, int totalDistance) {
//                return drawable;
//            }
//        });


//        Map<String, String> strMap = new HashMap<>();
//        strMap.put("2024-05-25", "测试");
//        strMap.put("2024-05-26", "测试2");
//        innerPainter.setReplaceLunarStrMap(strMap);

//        Map<String, Integer> colorMap = new HashMap<>();
//        colorMap.put("2024-05-23", Color.RED);
//
//        colorMap.put("2024-05-24", Color.GREEN);
//        innerPainter.setReplaceLunarColorMap(colorMap);//农历

//        List<String> holidayList = new ArrayList<>();
//        holidayList.add("2019-7-20");
//        holidayList.add("2019-7-21");
//        holidayList.add("2019-7-22");
//
//        List<String> workdayList = new ArrayList<>();
//        workdayList.add("2019-7-23");
//        workdayList.add("2019-7-24");
//        workdayList.add("2019-7-25");
//
//        innerPainter.setLegalHolidayList(holidayList, workdayList);
    }

    private void setCalendarPointList(List<ScheduleQueryBean> list) {

        List<String> pointList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ScheduleQueryBean bean = list.get(i);
            if (!TextUtils.isEmpty(bean.getEndTime())) {
                String[] endArray = bean.getEndTime().split("日");
                String end = endArray[0].
                        replace("年", "-")
                        .replace("月", "-");
                if (!pointList.contains(end)) {
                    pointList.add(end);
                }
            }

            if (!TextUtils.isEmpty(bean.getStartTime())) {
                String[] endArray = bean.getStartTime().split("日");
                String end = endArray[0].
                        replace("年", "-")
                        .replace("月", "-");
                if (!pointList.contains(end)) {
                    pointList.add(end);
                }
            }
        }
        InnerPainter innerPainter = (InnerPainter) miui10Calendar.getCalendarPainter();
        innerPainter.setPointList(pointList);
    }

    private void initListener() {
        final LocalDate[] selectedDate = {new LocalDate()};
        miui10Calendar.setOnCalendarChangedListener(new OnCalendarChangedListener() {
            @Override
            public void onCalendarChange(BaseCalendar baseCalendar, int year, int month, LocalDate localDate, DateChangeBehavior dateChangeBehavior) {
                tv_result.setText(year + "年" + month + "月" + "   当前页面选中 " + localDate);
                selectedDate[0] =localDate;
                Log.d(TAG, "   当前页面选中 " + localDate);
                Log.d(TAG, "   dateChangeBehavior " + dateChangeBehavior);

                Log.e(TAG, "baseCalendar::" + baseCalendar);
                TingYear tingYear = Cumulative.mainCumulative(year, month);
//                tv_zang.setText("藏历："+tingYear.getYear() + "年" + tingYear.getMonth() + "月" );
                //tv_zang.setText("藏历一月十三日");

                if (localDate != null) {
                    CalendarDate calendarDate = CalendarUtil.getCalendarDate(localDate);
                    Lunar lunar = calendarDate.lunar;
                    tv_data.setText(localDate.toString("yyyy年MM月dd日"));
                    tv_desc.setText(lunar.chineseEra + lunar.animals + "年" + lunar.lunarMonthStr + lunar.lunarDayStr);
                    tv_zang.setText("藏历"+ lunar.lunarMonthStr + lunar.lunarDayStr);
                    queryToDay(tv_data.getText().toString());
                } else {
                    tv_data.setText("");
                    tv_desc.setText("");
                    contentTv.setText("");
                    contentTv.setVisibility(View.GONE);
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
                Intent intent = new Intent(MonthActivity.this, AddScheduleActivity.class);
                MonthActivity.this.startActivityForResult(intent, 10001);
            }
        });
        //点击年
        yearView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MonthActivity.this, DataDisplayActivity.class);
                // 获取当前选中的日期
                Log.d(TAG, "   当前页面选中 " + selectedDate[0]);
                intent.putExtra("YEAR", selectedDate[0].getYear());
                intent.putExtra("MONTH", selectedDate[0].getMonthOfYear());
                intent.putExtra("DAY", selectedDate[0].getDayOfMonth());
                startActivity(intent);
            }
        });
    }


    //查询当天的日程
    private void queryToDay(String time) {
        List<ScheduleQueryBean> listStart = StudentDaoOpen.queryAllByStartTimeLike(MonthActivity.this, time);
        List<ScheduleQueryBean> listEnd = StudentDaoOpen.queryAllByEndimeLike(MonthActivity.this, time);
        List<ScheduleQueryBean> tempList = new ArrayList<>();
        tempList.addAll(listStart);
        tempList.addAll(listEnd);
        StringBuilder stringBuilder = new StringBuilder();
        if (tempList.isEmpty()) {
            contentTv.setVisibility(View.GONE);
        }else {
            stringBuilder.append("今日日程").append(":\r\n");
            contentTv.setVisibility(View.VISIBLE);
        }
        for (int i = 0; i < tempList.size(); i++) {
            ScheduleQueryBean bean = tempList.get(i);
            stringBuilder.append(i + 1).append(". ").append(bean.getTitle()).append("~").append(bean.getStartTime()).append(";\r\n");
        }
        contentTv.setText(stringBuilder.toString());
    }

    private void initData() {
        List<ScheduleQueryBean> students = StudentDaoOpen.queryAll(MonthActivity.this);
        listData.clear();
        listData.addAll(filterEndTime(students));
        setCalendarPointList(listData);
        adapter.setList(listData);
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
                            miui10Calendar.jumpDate(year, month + 1, dayOfMonth);
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
                            Intent intent = new Intent(MonthActivity.this, ScheduleQueryResultsActivity.class);
                            intent.putExtra(QUERY_RESULT_KEY, content);
                            intent.putExtra(QUERY_TYPE_KEY, QUERY_TYPE_TITLE);
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
        if (requestCode == 10001 && resultCode == RESULT_OK && data != null) {
            initData();
        }
    }


    //这里过滤下 小于结束时间的才展示
    private List<ScheduleQueryBean> filterEndTime(List<ScheduleQueryBean> students) {
        List<ScheduleQueryBean> listData = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            ScheduleQueryBean bean = students.get(i);
            String endTime = bean.getEndTime();
            if (!TextUtils.isEmpty(endTime)) {
                String end = endTime.
                        replace("年", "-")
                        .replace("月", "-")
                        .replace("日", " ")
                        .replace("时", ":")
                        .replace("分", "");
                String yhd = getYHD();
                if (timeCompare(end, yhd) != -1) {
                    listData.add(bean);
                } else {
                    Log.i("stf", "隐藏掉的日程" + GsonUtils.toJson(bean));
                }
            }
        }
        return listData;
    }


    /**
     * @remark 相等 0；
     * date1 在date2 前，-1；
     * date1 在date2 后，1；
     */
    public static int timeCompare(String date1, String date2) {
        try {
            SimpleDateFormat CurrentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date beginTime = CurrentTime.parse(date1);
            Date endTime = CurrentTime.parse(date2);
            int i = 0;
            if (beginTime.compareTo(endTime) > 0) {
                i = 1;
            } else if (beginTime.compareTo(endTime) < 0) {
                i = -1;
            } else if (beginTime.compareTo(endTime) == 0) {
                i = 0;
            }
            return i;
        } catch (Exception e) {
            e.fillInStackTrace();
            Log.i("stf", "---getMessage--->" + e.getMessage());
            return -1;
        }
    }

    public String getYHD() {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dff.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String dateString = dff.format(new Date());
        return dateString;
    }

}
