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


    public void toStringCelestialBase() {
        System.out.println("曜基数："+this.celestia+"z"+this.clepsydra+"q"+this.minute+"'"+this.breath+"“"+this.sub+"'”");
    }

    public int getCelestia(){
        return this.celestia;
    }
    public int getClepsydra(){
        return this.clepsydra;
    }
    public int getMinute(){
        return this.minute;
    }
    public int getBreath(){
        return this.breath;
    }

    public int getSub(){
        return this.sub;
    }

    public static CelestialBase cumulativeCelestiaBase(CelestialBase Liyuan, Year year) {
        CelestialBase base=new CelestialBase();//查表

        int businessOfsub=(year.cumulativeMonth*480+Liyuan.sub)/707;  //子商
        int remainderOfsub=(year.cumulativeMonth*480+Liyuan.sub)%707;  //子余

        int businessOfbreath=(year.cumulativeMonth*0+Liyuan.breath+businessOfsub)/6;  //息商
        int remainderOfbreath=(year.cumulativeMonth*0+Liyuan.breath+businessOfsub)%6; //息余

        int businessOfminute=(year.cumulativeMonth*50+Liyuan.minute+businessOfbreath)/60; //分商
        int remainderOfminute=(year.cumulativeMonth*50+Liyuan.minute+businessOfbreath)%60; //分余

        int businessOfclepsydra=(year.cumulativeMonth*31+Liyuan.clepsydra+businessOfminute)/60;  //漏刻商
        int remainderOfclepsydra=(year.cumulativeMonth*31+Liyuan.clepsydra+businessOfminute)%60; //漏刻余

        int businessOfcelestia=(year.cumulativeMonth*1+Liyuan.celestia+businessOfclepsydra)/7;  //曜商
        int remainderOfclestia=(year.cumulativeMonth*1+Liyuan.celestia+businessOfclepsydra)%7;  //曜余

        base.setCelestialBase(remainderOfclestia,remainderOfclepsydra,remainderOfminute,remainderOfbreath,remainderOfsub);

        return base;

    }

}
