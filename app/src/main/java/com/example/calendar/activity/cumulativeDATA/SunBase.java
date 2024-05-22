package com.example.calendar.activity.cumulativeDATA;
/*太阳基数*/
public class SunBase {
    int constellation;//宿
    int radian;//弧刻
    int minute;//分
    int breath;//息
    int sub;//子

    public void setSunBase(int constellation,int radian,int minute,int breath,int sub){
        this.constellation=constellation;
        this.radian=radian;
        this.minute=minute;
        this.breath=breath;
        this.sub=sub;
    }
    public void toStringSunBase() {
        System.out.println("太阳基数："+this.constellation+"k"+this.radian+"q"+this.minute+"'"+this.breath+"“"+this.sub+"'”");
    }

    public int getConstellation() {
        return constellation;
    }

    public int getRadian() {
        return radian;
    }

    public int getMinute() {
        return minute;
    }

    public int getBreath() {
        return breath;
    }

    public int getSub() {
        return sub;
    }

    public static SunBase cumulativeSunBase(SunBase sunBase, Year year) {
        SunBase base=new SunBase();

        int businessOfsub=(17*year.cumulativeMonth+sunBase.sub)/67;  //子商
        int remainderOfsub=(17*year.cumulativeMonth+sunBase.sub)%67;  //子余

        int businessOfbreath=(1*year.cumulativeMonth+sunBase.breath+businessOfsub)/6;  //息商
        int remainderOfbreath=(1*year.cumulativeMonth+sunBase.breath+businessOfsub)%6; //息余

        int businessOfminute=(58*year.cumulativeMonth+sunBase.minute+businessOfbreath)/60; //分商
        int remainderOfminute=(58*year.cumulativeMonth+sunBase.minute+businessOfbreath)%60; //分余

        int businessOfradian=(10*year.cumulativeMonth+sunBase.radian+businessOfminute)/60;  //弧刻商
        int remainderOfradian=(10*year.cumulativeMonth+sunBase.radian+businessOfminute)%60; //弧刻余

        int businessOfconstellation=(2*year.cumulativeMonth+sunBase.constellation+businessOfradian)/27;  //宿商
        int remainderOfconstellation=(2*year.cumulativeMonth+sunBase.constellation+businessOfradian)%27;  //宿余

        base.setSunBase(remainderOfconstellation,remainderOfradian,remainderOfminute,remainderOfbreath,remainderOfsub);
        return base;

    }
}

