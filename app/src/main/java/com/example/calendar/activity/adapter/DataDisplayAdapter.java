package com.example.calendar.activity.adapter;


import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.calendar.R;

import java.util.List;

/**
 * 当日藏历天文数据界面Adapter
 */
public class DataDisplayAdapter  extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public DataDisplayAdapter(List<MultiItemEntity> data) {
        super(data);
        //每个子item
        addItemType(1, R.layout.item_data_display_one);
        addItemType(2, R.layout.item_data_display_two);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, MultiItemEntity multiItemEntity) {

        switch (multiItemEntity.getItemType()) {
            case 1:

                break;
            case 2:

                break;

        }
    }
}
