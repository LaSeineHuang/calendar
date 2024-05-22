package com.example.calendar.activity.cumulativeDATA;

public class Meet {
    int constellation;//宿
    int radian;//弧刻
    int minute;//分
    int breath;//息
    int sub;//子

    public void setMeet(int constellation,int radian,int minute,int breath,int sub){
        this.constellation=constellation;
        this.radian=radian;
        this.minute=minute;
        this.breath=breath;
        this.sub=sub;
    }
    public void toStringMeet() {
        System.out.println("会合："+this.constellation+"k"+this.radian+"q"+this.minute+"'"+this.breath+"“"+this.sub+"'”");
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

    public static Meet cumulativeMeet(CertainSun certainSun, ConstellationOfNetAndSun constellationOfNetAndSun ) {
        Meet base=new Meet();

        int businessOfsub=(certainSun.sub+constellationOfNetAndSun.sub)/67;  //子商
        int remainderOfsub=(certainSun.sub+constellationOfNetAndSun.sub)%67;  //子余

        int businessOfbreath=(certainSun.breath+constellationOfNetAndSun.breath+businessOfsub)/6;  //息商
        int remainderOfbreath=(certainSun.breath+constellationOfNetAndSun.breath+businessOfsub)%6; //息余

        int businessOfminute=(certainSun.minute+constellationOfNetAndSun.minute+businessOfbreath)/60; //分商
        int remainderOfminute=(certainSun.minute+constellationOfNetAndSun.minute+businessOfbreath)%60; //分余

        int businessOfradian=(certainSun.radian+constellationOfNetAndSun.radian+businessOfminute)/60;  //弧刻商
        int remainderOfradian=(certainSun.radian+constellationOfNetAndSun.radian+businessOfminute)%60; //弧刻余

        int businessOfconstellation=(certainSun.constellation+constellationOfNetAndSun.constellation+businessOfradian)/27;  //宿商
        int remainderOfconstellation=(certainSun.constellation+constellationOfNetAndSun.constellation+businessOfradian)%27;  //宿余

        base.setMeet(remainderOfconstellation,remainderOfradian,remainderOfminute,remainderOfbreath,remainderOfsub);
        return base;

    }
}
