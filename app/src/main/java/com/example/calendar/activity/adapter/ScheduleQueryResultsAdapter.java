package com.example.calendar.activity.adapter;


import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.GsonUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.calendar.R;
import com.example.calendar.activity.dao.ScheduleQueryBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


/**
 * 日程查询结果Adapter
 */
public class ScheduleQueryResultsAdapter extends BaseQuickAdapter<ScheduleQueryBean, BaseViewHolder> {
    public ScheduleQueryResultsAdapter(List<ScheduleQueryBean> data) {
        super(R.layout.item_query_results, data);
        addChildClickViewIds(R.id.edit_img);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, ScheduleQueryBean bean) {
        baseViewHolder.setText(R.id.tv_item_query_results_content, bean.getTitle());
        baseViewHolder.setBackgroundColor(R.id.lay,isEndTime(bean.getEndTime()) ? Color.WHITE:Color.GRAY);
    }

    //这里过滤下 小于结束时间的才展示
    private boolean isEndTime(String endTime) {
        if (!TextUtils.isEmpty(endTime)) {
            String end = endTime.
                    replace("年", "-")
                    .replace("月", "-")
                    .replace("日", " ")
                    .replace("时", ":")
                    .replace("分", "");
            String yhd = getYHD();
            if (timeCompare(end, yhd) != -1) {
                return false;
            } else {
                return true;
            }
        }
        return true;
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



