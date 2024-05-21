package com.example.calendar.activity.adapter;


import static com.blankj.utilcode.util.ActivityUtils.startActivity;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.calendar.R;
import com.example.calendar.activity.DataDisplayActivity;
import com.example.calendar.activity.MonthActivity;
import com.example.calendar.activity.WebViewActivity;

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
                baseViewHolder.getView(R.id.tv_wu_yao_zhi).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击五曜值
                        Intent intent = new Intent(getContext(), WebViewActivity.class);
                        startActivity(intent);
                    }
                });

                break;

        }
    }
}
