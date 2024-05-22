package com.example.calendar.activity.cumulativeDATA;

public class SurplusDay {
    int surplusDay;//太阳日公积日
    int median;//中位
    int inferior;//下位

    public void setSurplusDay(int surplusDay,int median,int inferior){
        this.surplusDay=surplusDay;
        this.median=median;
        this.inferior=inferior;
    }

    public void toStringSurplusDay() {
        System.out.println("五曜公积日："+this.surplusDay+" 中位"+this.median+" 下位"+this.inferior);
    }

    public int getSurplusDay() {
        return surplusDay;
    }

    public void setMedian(int median) {
        this.median = median;
    }

    public int getInferior() {
        return inferior;
    }

    public static SurplusDay cumulativeSurplusDay(SurplusDay Liyuan, Year year, int day){
        SurplusDay base=new SurplusDay();
        int surplusDayOfLunar=year.cumulativeMonth*30+day;

        int businessOfinferior=(surplusDayOfLunar+ Liyuan.inferior-1)/707;  //下位商
        int remainderOfinferior=(surplusDayOfLunar+ Liyuan.inferior-1)%707;  //下位余

        int businessOfmedian=(surplusDayOfLunar* Liyuan.median+businessOfinferior-1)/64;  //息商
        int remainderOfmedian=(surplusDayOfLunar* Liyuan.median+businessOfinferior-1)%64; //息余

        int SD=surplusDayOfLunar-businessOfmedian;
        base.setSurplusDay(SD,remainderOfmedian, remainderOfinferior);
        return base;
    }
}
