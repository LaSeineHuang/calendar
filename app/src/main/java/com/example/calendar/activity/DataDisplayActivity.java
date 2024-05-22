package com.example.calendar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.calendar.R;
import com.example.calendar.activity.bean.BeanTest;
import com.example.calendar.activity.bean.DataDisplayOne;
import com.example.calendar.activity.bean.DataDisplayTwo;
import com.example.calendar.activity.adapter.DataDisplayAdapter;
import com.example.calendar.activity.cumulativeDATA.MainCumulative;

import java.util.ArrayList;
import java.util.List;

/**
 * 当日藏历天文数据界面
 */
public class DataDisplayActivity extends AppCompatActivity {
    private RecyclerView rvActivityDataView;
    private DataDisplayAdapter adapter;
    private TextView dateTextView;
    int year;
    int month;
    int day;

    DataDisplayOne dataDisplayOne= new DataDisplayOne();
    DataDisplayTwo dataDisplayTwo=new DataDisplayTwo();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        // 从Intent中获取年月日
        Intent intent = getIntent();
        year = intent.getIntExtra("YEAR", -1); // 默认值为-1表示没有数据
        month = intent.getIntExtra("MONTH", -1);
        day = intent.getIntExtra("DAY", -1);
        // 使用这些数据来初始化界面或做其他操作

        initView();
        initData();

    }

    private void initView(){
        //当前的界面的布局整体为一个RecyclerView
        rvActivityDataView =  findViewById(R.id.rv_activity_data_view);

    }

    private void initData(){
        BeanTest beanTest= MainCumulative.cumulative(year,month,day);
        dataDisplayOne.setDate(beanTest.getYear(),beanTest.getMonth(),beanTest.getDay());
        dataDisplayOne.setData(beanTest.getCumulativeMonth(), beanTest.getCumulativeYu(),beanTest.getInteger(), beanTest.getZero());
        dataDisplayOne.setCelestialBase(beanTest.celestialBase1, beanTest.celestialBase2, beanTest.celestialBase3, beanTest.celestialBase4, beanTest.celestialBase5 );
        dataDisplayOne.setSunBase(beanTest.sunBase1,beanTest.sunBase2,beanTest.sunBase3,beanTest.sunBase4,beanTest.sunBase5);

        dataDisplayTwo.setDate(beanTest.getYear(),beanTest.getMonth(),beanTest.getDay());
        dataDisplayTwo.setCertainCelestial(beanTest.certainCelestial1,beanTest.certainCelestial2,beanTest.certainCelestial3, beanTest.certainCelestial4, beanTest.certainCelestial5,beanTest.certainCelestial6);
        dataDisplayTwo.setCOfNetAndSun(beanTest.cOfNetAndSun1, beanTest.cOfNetAndSun2, beanTest.cOfNetAndSun3, beanTest.cOfNetAndSun4, beanTest.cOfNetAndSun5, beanTest.cOfNetAndSun6);
        dataDisplayTwo.setCertainSun(beanTest.certainSun1, beanTest.certainSun2, beanTest.certainSun3, beanTest.certainSun4, beanTest.certainSun5);
        dataDisplayTwo.setMeet(beanTest.meet1, beanTest.meet2, beanTest.meet3, beanTest.meet4, beanTest.meet5);
        dataDisplayTwo.setName(beanTest.name, beanTest.Fname, beanTest.Lname);
        dataDisplayTwo.setSurplusDay(beanTest.surplusDay,beanTest.median, beanTest.inferior);
        dataDisplayTwo.setSpecialDay(beanTest.mars,beanTest.jupiter,beanTest.saturn,beanTest.mercury, beanTest.venus);
        dataDisplayTwo.setMars(beanTest.mars1, beanTest.mars2, beanTest.mars3, beanTest.mars4, beanTest.mars5);
        dataDisplayTwo.setJupiter(beanTest.jupiter1, beanTest.jupiter2, beanTest.jupiter3, beanTest.jupiter4, beanTest.jupiter5);
        dataDisplayTwo.setSaturn(beanTest.saturn1, beanTest.saturn2, beanTest.saturn3, beanTest.saturn4, beanTest.saturn5);
        dataDisplayTwo.setMercury(beanTest.mercury1, beanTest.mercury2, beanTest.mercury3, beanTest.mercury4, beanTest.mercury5);
        dataDisplayTwo.setVenus(beanTest.venus1, beanTest.venus2, beanTest.venus3, beanTest.venus4, beanTest.venus5);
        List<MultiItemEntity> data =  new ArrayList<>();
        data.add(dataDisplayOne);
        data.add(dataDisplayTwo);
        //这里填写数据
        adapter = new DataDisplayAdapter(data);
        rvActivityDataView.setAdapter(adapter);
    }
}
