package com.example.calendar.activity.cumulativeDATA;

/*曜基数*/
public class CelestialBase {
    int celestia;//曜
    int clepsydra;//漏刻
    int minute;//分
    int breath;//息
    int sub;//子

    public void setCelestialBase(int celestia,int clepsydra,int minute,int breath,int sub){
        this.celestia=celestia;
        this.clepsydra=clepsydra;
        this.minute=minute;
        this.breath=breath;
        this.sub=sub;
    }

    public static CelestialBase cumulativeCelestiaBase(CelestialBase Liyuan, Year year) {
        CelestialBase base=new CelestialBase();

        int businessOfsub=(year.cumulativeMonth*480+Liyuan.sub)%707;  //子余
        int remainderOfsun=(year.cumulativeMonth*480+Liyuan.sub)/707;  //子商

        int businessOfbreath=(year.cumulativeMonth*0+Liyuan.breath+remainderOfsun)%6;  //息余
        int remainderOfbreath=(year.cumulativeMonth*0+Liyuan.breath+remainderOfsun)/6; //息商

        int businessOfminute=(year.cumulativeMonth*50+Liyuan.minute+remainderOfbreath)%60; //分余
        int remainderOfminute=(year.cumulativeMonth*50+Liyuan.minute+remainderOfbreath)/60; //分商

        int businessOfclepsydra=(year.cumulativeMonth*31+Liyuan.minute+remainderOfminute)%60;  //漏刻余
        int remainderOfclepsydra=(year.cumulativeMonth*31+Liyuan.minute+remainderOfminute)/60; //漏刻商

        int businessOfcelestia=(year.cumulativeMonth*1+Liyuan.minute+remainderOfclepsydra)%7;  //曜余
        int remainderOfclestia=(year.cumulativeMonth*1+Liyuan.minute+remainderOfclepsydra)/7;  //曜商

        base.setCelestialBase(businessOfcelestia,businessOfclepsydra,businessOfminute,businessOfbreath,businessOfsub);

        return base;

    }
}
