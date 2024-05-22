package com.example.calendar.activity.bean;

import android.widget.TextView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.calendar.R;


public class DataDisplayOne implements MultiItemEntity {
    int y;
    int m;
    int d;

    public DataDisplayOne() {


    }

    @Override
    public int getItemType() {
        return 1;
    }
    public void setDATA(int y,int m,int d) {
        this.y=y;
        this.m=m;
        this.d=d;

    }
    public String getDATA() {
        return y+"年"+ m+"月"+ d+"日";
    }

}
