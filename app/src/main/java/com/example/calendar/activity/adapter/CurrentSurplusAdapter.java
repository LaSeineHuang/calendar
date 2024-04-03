package com.example.calendar.activity.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.calendar.R;
import com.example.calendar.activity.Bean.CurrentSurplusBean;

import java.util.List;

/**
 * 当前算余积月界面Adapter
 */
public class CurrentSurplusAdapter extends BaseQuickAdapter<CurrentSurplusBean, BaseViewHolder> {
    public CurrentSurplusAdapter(List<CurrentSurplusBean> data) {
        super(R.layout.item_current_surplus, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, CurrentSurplusBean bean) {
        baseViewHolder.setText(R.id.tv_item_current_one, bean.getOneContent());
        baseViewHolder.setText(R.id.tv_item_current_two, bean.getTwoContent());
        baseViewHolder.setText(R.id.tv_item_current_three, bean.getThreeContent());
    }
}
