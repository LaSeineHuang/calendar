package com.example.calendar.activity.adapter;


import static com.blankj.utilcode.util.ActivityUtils.startActivity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.calendar.R;
import com.example.calendar.activity.WebViewActivity;
import com.example.calendar.activity.bean.DataDisplayOne;
import com.example.calendar.activity.bean.DataDisplayTwo;

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
                DataDisplayOne dataDisplayOne = (DataDisplayOne)multiItemEntity;
                baseViewHolder.<TextView>getView(R.id.tv_data).setText(dataDisplayOne.getDate());
                baseViewHolder.<TextView>getView(R.id.tv_month).setText(dataDisplayOne.getMonth());

                baseViewHolder.<TextView>getView(R.id.cumulative_Month).setText(dataDisplayOne.getCumulativeMonth());
                baseViewHolder.<TextView>getView(R.id.suan_yu).setText(dataDisplayOne.getSuanyu());

                baseViewHolder.<TextView>getView(R.id.tv_integer).setText(dataDisplayOne.getInteger());
                baseViewHolder.<TextView>getView(R.id.tv_zero).setText(dataDisplayOne.getZero());

                baseViewHolder.<TextView>getView(R.id.celestialBase1).setText(dataDisplayOne.getCelestialBase1());
                baseViewHolder.<TextView>getView(R.id.celestialBase2).setText(dataDisplayOne.getCelestialBase2());
                baseViewHolder.<TextView>getView(R.id.celestialBase3).setText(dataDisplayOne.getCelestialBase3());
                baseViewHolder.<TextView>getView(R.id.celestialBase4).setText(dataDisplayOne.getCelestialBase4());
                baseViewHolder.<TextView>getView(R.id.celestialBase5).setText(dataDisplayOne.getCelestialBase5());

                baseViewHolder.<TextView>getView(R.id.sunBase1).setText(dataDisplayOne.getSunBase1());
                baseViewHolder.<TextView>getView(R.id.sunBase2).setText(dataDisplayOne.getSunBase2());
                baseViewHolder.<TextView>getView(R.id.sunBase3).setText(dataDisplayOne.getSunBase3());
                baseViewHolder.<TextView>getView(R.id.sunBase4).setText(dataDisplayOne.getSunBase4());
                baseViewHolder.<TextView>getView(R.id.sunBase5).setText(dataDisplayOne.getSunBase5());
                break;

            case 2:
                DataDisplayTwo dataDisplayTwo = (DataDisplayTwo)multiItemEntity;
                baseViewHolder.<TextView>getView(R.id.date).setText(dataDisplayTwo.getDate());
                baseViewHolder.<TextView>getView(R.id.certainCelestial1).setText(dataDisplayTwo.getcertainCelestial1());
                baseViewHolder.<TextView>getView(R.id.certainCelestial2).setText(dataDisplayTwo.getcertainCelestial2());
                baseViewHolder.<TextView>getView(R.id.certainCelestial3).setText(dataDisplayTwo.getcertainCelestial3());
                baseViewHolder.<TextView>getView(R.id.certainCelestial4).setText(dataDisplayTwo.getcertainCelestial4());
                baseViewHolder.<TextView>getView(R.id.certainCelestial5).setText(dataDisplayTwo.getcertainCelestial5());
                baseViewHolder.<TextView>getView(R.id.certainCelestial6).setText(dataDisplayTwo.getcertainCelestial6());

                baseViewHolder.<TextView>getView(R.id.cOfNetAndSun1).setText(dataDisplayTwo.getCOfNetAndSun1());
                baseViewHolder.<TextView>getView(R.id.cOfNetAndSun2).setText(dataDisplayTwo.getCOfNetAndSun2());
                baseViewHolder.<TextView>getView(R.id.cOfNetAndSun3).setText(dataDisplayTwo.getCOfNetAndSun3());
                baseViewHolder.<TextView>getView(R.id.cOfNetAndSun4).setText(dataDisplayTwo.getCOfNetAndSun4());
                baseViewHolder.<TextView>getView(R.id.cOfNetAndSun5).setText(dataDisplayTwo.getCOfNetAndSun5());
                baseViewHolder.<TextView>getView(R.id.cOfNetAndSun6).setText(dataDisplayTwo.getCOfNetAndSun6());

                baseViewHolder.<TextView>getView(R.id.certainSun1).setText(dataDisplayTwo.getCertainSun1());
                baseViewHolder.<TextView>getView(R.id.certainSun2).setText(dataDisplayTwo.getCertainSun2());
                baseViewHolder.<TextView>getView(R.id.certainSun3).setText(dataDisplayTwo.getCertainSun3());
                baseViewHolder.<TextView>getView(R.id.certainSun4).setText(dataDisplayTwo.getCertainSun4());
                baseViewHolder.<TextView>getView(R.id.certainSun5).setText(dataDisplayTwo.getCertainSun5());

                baseViewHolder.<TextView>getView(R.id.meet1).setText(dataDisplayTwo.getMeet1());
                baseViewHolder.<TextView>getView(R.id.meet2).setText(dataDisplayTwo.getMeet2());
                baseViewHolder.<TextView>getView(R.id.meet3).setText(dataDisplayTwo.getMeet3());
                baseViewHolder.<TextView>getView(R.id.meet4).setText(dataDisplayTwo.getMeet4());
                baseViewHolder.<TextView>getView(R.id.meet5).setText(dataDisplayTwo.getMeet5());

                baseViewHolder.<TextView>getView(R.id.name).setText(dataDisplayTwo.getName());
                baseViewHolder.<TextView>getView(R.id.Fname).setText(dataDisplayTwo.getFname());
                baseViewHolder.<TextView>getView(R.id.Lname).setText(dataDisplayTwo.getLname());

                baseViewHolder.<TextView>getView(R.id.surplusDay).setText(dataDisplayTwo.getSurplusDay());
                baseViewHolder.<TextView>getView(R.id.median).setText(dataDisplayTwo.getMedian());
                baseViewHolder.<TextView>getView(R.id.inferior).setText(dataDisplayTwo.getInferior());

                baseViewHolder.<TextView>getView(R.id.mars).setText(dataDisplayTwo.getSDofMars());
                baseViewHolder.<TextView>getView(R.id.jupiter).setText(dataDisplayTwo.getSDofjupiter());
                baseViewHolder.<TextView>getView(R.id.saturn).setText(dataDisplayTwo.getSDofsaturn());
                baseViewHolder.<TextView>getView(R.id.mercury).setText(dataDisplayTwo.getSDofmercury());
                baseViewHolder.<TextView>getView(R.id.venus).setText(dataDisplayTwo.getSDofvenus());

                baseViewHolder.<TextView>getView(R.id.mars1).setText(dataDisplayTwo.getMars1());
                baseViewHolder.<TextView>getView(R.id.mars2).setText(dataDisplayTwo.getMars2());
                baseViewHolder.<TextView>getView(R.id.mars3).setText(dataDisplayTwo.getMars3());
                baseViewHolder.<TextView>getView(R.id.mars4).setText(dataDisplayTwo.getMars4());
                baseViewHolder.<TextView>getView(R.id.mars5).setText(dataDisplayTwo.getMars5());

                baseViewHolder.<TextView>getView(R.id.jupiter1).setText(dataDisplayTwo.getJupiter1());
                baseViewHolder.<TextView>getView(R.id.jupiter2).setText(dataDisplayTwo.getJupiter2());
                baseViewHolder.<TextView>getView(R.id.jupiter3).setText(dataDisplayTwo.getJupiter3());
                baseViewHolder.<TextView>getView(R.id.jupiter4).setText(dataDisplayTwo.getJupiter4());
                baseViewHolder.<TextView>getView(R.id.jupiter5).setText(dataDisplayTwo.getJupiter5());

                baseViewHolder.<TextView>getView(R.id.saturn1).setText(dataDisplayTwo.getSaturn1());
                baseViewHolder.<TextView>getView(R.id.saturn2).setText(dataDisplayTwo.getSaturn2());
                baseViewHolder.<TextView>getView(R.id.saturn3).setText(dataDisplayTwo.getSaturn3());
                baseViewHolder.<TextView>getView(R.id.saturn4).setText(dataDisplayTwo.getSaturn4());
                baseViewHolder.<TextView>getView(R.id.saturn5).setText(dataDisplayTwo.getSaturn5());

                baseViewHolder.<TextView>getView(R.id.mercury1).setText(dataDisplayTwo.getMercury1());
                baseViewHolder.<TextView>getView(R.id.mercury2).setText(dataDisplayTwo.getMercury2());
                baseViewHolder.<TextView>getView(R.id.mercury3).setText(dataDisplayTwo.getMercury3());
                baseViewHolder.<TextView>getView(R.id.mercury4).setText(dataDisplayTwo.getMercury4());
                baseViewHolder.<TextView>getView(R.id.mercury5).setText(dataDisplayTwo.getMercury5());

                baseViewHolder.<TextView>getView(R.id.venus1).setText(dataDisplayTwo.getVenus1());
                baseViewHolder.<TextView>getView(R.id.venus2).setText(dataDisplayTwo.getVenus2());
                baseViewHolder.<TextView>getView(R.id.venus3).setText(dataDisplayTwo.getVenus3());
                baseViewHolder.<TextView>getView(R.id.venus4).setText(dataDisplayTwo.getVenus4());
                baseViewHolder.<TextView>getView(R.id.venus5).setText(dataDisplayTwo.getVenus5());



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
