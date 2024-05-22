package com.example.calendar.activity.cumulativeDATA;
/*中曜*/
public class MiddleCelestia {
    int celestia;//曜
    int clepsydra;//漏刻
    int minute;//分
    int breath;//息
    int sub;//子

    public void setMiddleCelestia(int celestia,int clepsydra,int minute,int breath,int sub){
        this.celestia=celestia;
        this.clepsydra=clepsydra;
        this.minute=minute;
        this.breath=breath;
        this.sub=sub;
    }
    public void toStringMiddleCelestial() {
        System.out.println("中曜："+this.celestia+"z"+this.clepsydra+"q"+this.minute+"'"+this.breath+"“"+this.sub+"'”");
    }

    public int getCelestia() {
        return celestia;
    }

    public int getClepsydra() {
        return clepsydra;
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

    public static MiddleCelestia cumulativeMiddleCelestia(CelestialBase celestialBase, int day) {
        MiddleCelestia base =new MiddleCelestia();

        int businessOfsub=(16* day+ celestialBase.sub)/707;  //子商
        int remainderOfsub=(16* day+ celestialBase.sub)%707;  //子余

        int businessOfbreath=(4*day+ celestialBase.breath+businessOfsub)/6;  //息商
        int remainderOfbreath=(4*day+ celestialBase.breath+businessOfsub)%6; //息余

        int businessOfminute=(3*day+ celestialBase.minute+businessOfbreath)/60; //分商
        int remainderOfminute=(3*day+ celestialBase.minute+businessOfbreath)%60; //分余

        int businessOfclepsydra=(59*day+ celestialBase.clepsydra+businessOfminute)/60;  //漏刻商
        int remainderOfclepsydra=(59*day+ celestialBase.clepsydra+businessOfminute)%60; //漏刻余

        int businessOfcelestia=(0*day+ celestialBase.celestia+businessOfclepsydra)/7;  //曜商
        int remainderOfclestia=(0*day+ celestialBase.celestia+businessOfclepsydra)%7;  //曜余

        base.setMiddleCelestia(remainderOfclestia,remainderOfclepsydra,remainderOfminute,remainderOfbreath,remainderOfsub);

        return base;

    }
}