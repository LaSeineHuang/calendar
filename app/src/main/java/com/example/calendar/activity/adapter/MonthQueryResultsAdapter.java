package com.example.calendar.activity.adapter;



import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.calendar.R;
import com.example.calendar.activity.dao.ScheduleQueryBean;

import java.util.List;


/**
 * 日程查询结果Adapter
 */
public class MonthQueryResultsAdapter extends BaseQuickAdapter<ScheduleQueryBean, BaseViewHolder> {
    public MonthQueryResultsAdapter(List<ScheduleQueryBean> data) {
        super(R.layout.item_query_results, data);
        addChildClickViewIds(R.id.edit_img);
        addChildClickViewIds(R.id.del_img);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, ScheduleQueryBean bean) {
        baseViewHolder.setText(R.id.tv_item_query_results_content, bean.getTitle());
    }
}


