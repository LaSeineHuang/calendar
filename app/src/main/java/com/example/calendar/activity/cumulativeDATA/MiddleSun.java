package com.example.calendar.activity.cumulativeDATA;
/*中日*/
public class MiddleSun {
    int constellation;//宿
    int radian;//弧刻
    int minute;//分
    int breath;//息
    int sub;//子

    public void setMiddleSun(int constellation,int radian,int minute,int breath,int sub){
        this.constellation=constellation;
        this.radian=radian;
        this.minute=minute;
        this.breath=breath;
        this.sub=sub;
    }
    public void toStringMiddleSun() {
        System.out.println("中日："+this.constellation+"k"+this.radian+"q"+this.minute+"'"+this.breath+"“"+this.sub+"'”");
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

    public static MiddleSun cumulativeMiddleSun(SunBase sunBase, int day) {
        MiddleSun base=new MiddleSun();

        int businessOfsub=(43*day+sunBase.sub)/67;  //子商
        int remainderOfsub=(43*day+sunBase.sub)%67;  //子余

        int businessOfbreath=(5*day+sunBase.breath+businessOfsub)/6;  //息商
        int remainderOfbreath=(5*day+sunBase.breath+businessOfsub)%6; //息余

        int businessOfminute=(21*day+sunBase.minute+businessOfbreath)/60; //分商
        int remainderOfminute=(21*day+sunBase.minute+businessOfbreath)%60; //分余

        int businessOfradian=(4*day+sunBase.radian+businessOfminute)/60;  //弧刻商
        int remainderOfradian=(4*day+sunBase.radian+businessOfminute)%60; //弧刻余

        int businessOfconstellation=(0*day+sunBase.constellation+businessOfradian)/27;  //宿商
        int remainderOfconstellation=(0*day+sunBase.constellation+businessOfradian)%27;  //宿余

        base.setMiddleSun(remainderOfconstellation,remainderOfradian,remainderOfminute, remainderOfbreath,remainderOfsub);

        return base;

    }
}