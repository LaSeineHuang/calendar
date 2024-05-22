package com.example.calendar.activity.cumulativeDATA;

public class SpecialDay {

    public int mars;//火曜
    public int jupiter;//木曜
    public int saturn;//土曜
    public int mercury;//水曜
    public int venus;//金曜

    public void setSpecialDay(int mars,int jupiter,int saturn,int mercury,int venus){
        this.mars=mars;
        this.jupiter=jupiter;
        this.saturn=saturn;
        this.mercury=mercury;
        this.venus=venus;
    }

    public void toStringSpecialDay() {
        System.out.println("殊日： 火曜："+this.mars+"木曜："+this.jupiter+"土曜："+this.saturn+"水曜："+this.mercury+"金曜："+this.venus);
    }

    public int getMars() {
        return mars;
    }

    public int getJupiter() {
        return jupiter;
    }

    public int getSaturn() {
        return saturn;
    }

    public int getMercury() {
        return mercury;
    }

    public int getVenus() {
        return venus;
    }

    public SpecialDay cumulativeSpecialDay(SpecialDay Liyuan, SurplusDay surplusDay){
        SpecialDay specialDay= new SpecialDay();
        //火曜
        int mars= (surplusDay.surplusDay+ Liyuan.mars+30)%687;
        //木曜
        int jupiter= (surplusDay.surplusDay+ Liyuan.jupiter+30)%4332;
        //土曜
        int saturn= (surplusDay.surplusDay+ Liyuan.saturn+30)%10766;
        //水曜
        int mercury=(surplusDay.surplusDay+ Liyuan.mercury+30)%8797;
        //金曜
        int venus=(surplusDay.surplusDay+ Liyuan.venus+30)%2247;
        specialDay.setSpecialDay(mars,jupiter,saturn,mercury,venus);
        return specialDay;
    }
}
