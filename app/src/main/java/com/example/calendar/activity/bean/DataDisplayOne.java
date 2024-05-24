package com.example.calendar.activity.bean;

import android.widget.TextView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.calendar.R;


public class DataDisplayOne implements MultiItemEntity {
    public int y;
    public int m;
    public int d;
    public int GY;
    public int GM;
    public int GD;
    public int cumulativeMonth;
    public int suanyu;

    public int integer;
    public int zero;

    public int celestialBase1;
    public int celestialBase2;
    public int celestialBase3;
    public int celestialBase4;
    public int celestialBase5;

    public int sunBase1;
    public int sunBase2;
    public int sunBase3;
    public int sunBase4;
    public int sunBase5;


    public DataDisplayOne() {


    }

    @Override
    public int getItemType() {
        return 1;
    }
    public void setDate(int y,int m,int d) {
        this.y=y;
        this.m=m;
        this.d=d;

    }
    public void setGDate(int GY,int GM,int GD){
        this.GY=GY;
        this.GM=GM;
        this.GD=GD;
    }
    public String getGDate() {
        return "公历："+GY+"年"+ GM+"月"+ GD+"日";
    }

    public String getDate() {
        return "藏历："+y+"年"+ m+"月"+ d+"日";
    }
    public String getMonth(){
        return "藏历"+m+"月基础数据";
    }

    public void setData(int cumulativeMonth,int suanyu,int integer,int zero){
        this.suanyu=suanyu;
        this.cumulativeMonth=cumulativeMonth;
        this.integer=integer;
        this.zero=zero;
    }

    public String getCumulativeMonth() {
        return String.valueOf(cumulativeMonth);
    }

    public String getSuanyu() {
        return String.valueOf(suanyu);
    }

    public String getInteger() {
        return String.valueOf(integer);
    }

    public String getZero() {
        return String.valueOf(zero);
    }

    public void setCelestialBase(int celestialBase1,int celestialBase2,int celestialBase3,int celestialBase4,int celestialBase5) {
        this.celestialBase1 = celestialBase1;
        this.celestialBase2 =celestialBase2;
        this.celestialBase3= celestialBase3;
        this.celestialBase4=celestialBase4;
        this.celestialBase5=celestialBase5;
    }


    public String getCelestialBase1() {
        return String.valueOf(celestialBase1);
    }
    public String getCelestialBase2() {
        return String.valueOf(celestialBase2);
    }
    public String getCelestialBase3() {
        return String.valueOf(celestialBase3);
    }
    public String getCelestialBase4() {
        return String.valueOf(celestialBase4);
    }
    public String getCelestialBase5() {
        return String.valueOf(celestialBase5);
    }

    public void setSunBase(int sunBase1,int sunBase2,int sunBase3,int sunBase4,int sunBase5) {
        this.sunBase1=sunBase1;
        this.sunBase2=sunBase2;
        this.sunBase3=sunBase3;
        this.sunBase4=sunBase4;
        this.sunBase5=sunBase5;
    }

    public String getSunBase1() {
        return String.valueOf(sunBase1);
    }
    public String getSunBase2() {
        return String.valueOf(sunBase2);
    }
    public String getSunBase3() {
        return String.valueOf(sunBase3);
    }
    public String getSunBase4() {
        return String.valueOf(sunBase4);
    }
    public String getSunBase5() {
        return String.valueOf(sunBase5);
    }
}
