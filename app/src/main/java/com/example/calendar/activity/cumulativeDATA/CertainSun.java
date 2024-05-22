package com.example.calendar.activity.cumulativeDATA;

public class CertainSun {
    int constellation;//宿
    int radian;//弧刻
    int minute;//分
    int breath;//息
    int sub;//子
    public void setCertainSun(int constellation,int radian,int minute,int breath,int sub){
        this.constellation=constellation;
        this.radian=radian;
        this.minute=minute;
        this.breath=breath;
        this.sub=sub;
    }

    public void toStringCertainSun() {
        System.out.println("定日："+this.constellation+"k"+this.radian+"q"+this.minute+"'"+this.breath+"“"+this.sub+"'”");
    }

    public int getConstellation() {
        return constellation;
    }

    public int getRadian() {
        return radian;
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
    //求日步
    public static CertainSun cumulativeStepOfSun(SunRealisableValue SRValue){
        CertainSun stepOfSun=new CertainSun();
        int radianOfSTS=(SRValue.radian+SRValue.surplus_and_deficit)%60;
        int constellationOfSTS=(SRValue.radian+SRValue.surplus_and_deficit)/60;
        stepOfSun.setCertainSun(constellationOfSTS,radianOfSTS,SRValue.minute,SRValue.breath,SRValue.sub);
        // System.out.println("日bu："+stepOfSun.constellation+"k"+stepOfSun.radian+"q"+stepOfSun.minute+"'"+stepOfSun.breath+"“"+stepOfSun.sub+"'”");
        return stepOfSun;
    }
    //求定日
    public static CertainSun cumulativeCertainSun(SunRealisableValue SRValue, MiddleSun middleSun,CertainSun stepOfSun) {
        CertainSun base=new CertainSun();
        if(SRValue.flag==1){
            int businessOfsub=(middleSun.sub+stepOfSun.sub)/67;  //子商
            int remainderOfsub=(middleSun.sub+stepOfSun.sub)%67;  //子余

            int businessOfbreath=(middleSun.breath+stepOfSun.breath+businessOfsub)/6;  //息商
            int remainderOfbreath=(middleSun.breath+stepOfSun.breath+businessOfsub)%6; //息余

            int businessOfminute=(middleSun.minute+stepOfSun.minute+businessOfbreath)/60; //分商
            int remainderOfminute=(middleSun.minute+stepOfSun.minute+businessOfbreath)%60; //分余

            int businessOfradian=(middleSun.radian+stepOfSun.radian+businessOfminute)/60;  //弧刻商
            int remainderOfradian=(middleSun.radian+stepOfSun.radian+businessOfminute)%60; //弧刻余

            int businessOfconstellation=(middleSun.constellation+stepOfSun.constellation+businessOfradian)/27;  //宿商
            int remainderOfconstellation=(middleSun.constellation+stepOfSun.constellation+businessOfradian)%27;  //宿余

            base.setCertainSun(remainderOfconstellation,remainderOfradian,remainderOfminute,remainderOfbreath,remainderOfsub);
        }else
        {
            int minMiddleSun;//中日化到子位
            minMiddleSun=middleSun.constellation*60*60*6*67+middleSun.radian*60*6*67+middleSun.minute*6*67+middleSun.breath*67+middleSun.sub;
            int minStepOfSun;//日步化到子位
            minStepOfSun=stepOfSun.constellation*60*60*6*67+stepOfSun.radian*60*6*67+stepOfSun.minute*6*67+stepOfSun.breath*67+stepOfSun.sub;
            int minCertainSun;//定日化到子位
            if(minMiddleSun>=minStepOfSun){
                minCertainSun=minMiddleSun-minStepOfSun;
            }else{
                minCertainSun=minMiddleSun+27*60*60*6*67-minStepOfSun;
            }
            int businessOfsub=(minCertainSun)/67;  //子商
            int remainderOfsub=(minCertainSun)%67;  //子余

            int businessOfbreath=(businessOfsub)/6;  //息商
            int remainderOfbreath=(businessOfsub)%6; //息余

            int businessOfminute=(businessOfbreath)/60; //分商
            int remainderOfminute=(businessOfbreath)%60; //分余

            int businessOfradian=(businessOfminute)/60;  //弧刻商
            int remainderOfradian=(businessOfminute)%60; //弧刻余

            int businessOfconstellation=(businessOfradian)/27;  //宿商
            int remainderOfconstellation=(businessOfradian)%27;  //宿余
            base.setCertainSun(remainderOfconstellation,remainderOfradian,remainderOfminute,remainderOfbreath,remainderOfsub);
        }
        return base;

    }
}
