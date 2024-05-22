package com.example.calendar.activity.cumulativeDATA;

public class ConstellationOfNetAndSun {
    int constellation;//宿
    int radian;//弧刻
    int minute;//分
    int breath;//息
    int sub;//子
    int sixthSub;//第六子位
    public void setConstellationOfNetAndSun(int constellation,int radian,int minute,int breath,int sub,int sixthSub){
        this.constellation=constellation;
        this.radian=radian;
        this.minute=minute;
        this.breath=breath;
        this.sub=sub;
        this.sixthSub=sixthSub;
    }
    public void toStringConstellationOfNetAndSun() {
        System.out.println("曜伴月宿："+this.constellation+"k"+this.radian+"q"+this.minute+"'"+this.breath+"“"+this.sub+"'”"+this.sixthSub+"'”");
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

    public int getSixthSub() {
        return sixthSub;
    }

    //太阴日月宿计算
    public static ConstellationOfNetAndSun cumulativeConstellationOfLunar(CertainSun certainSun,int day){
        ConstellationOfNetAndSun constellationOfLunar =new ConstellationOfNetAndSun();
        int radianOfSuperMonth=(day*54)%60;
        int constellationOfSuperMonth=(day*54)/60;
        int sub=certainSun.sub;
        int minute= certainSun.minute;
        int breath= certainSun.breath;
        int businessOfradian=(certainSun.radian+radianOfSuperMonth)/60;  //弧刻商
        int remainderOfradian=(certainSun.radian+radianOfSuperMonth)%60; //弧刻余

        int businessOfconstellation=(certainSun.constellation+radianOfSuperMonth+businessOfradian)/27;  //宿商
        int remainderOfconstellation=(certainSun.constellation+radianOfSuperMonth+businessOfradian)%27;  //宿余

        constellationOfLunar.setConstellationOfNetAndSun(remainderOfconstellation,remainderOfradian,minute,breath,sub,0);
        return constellationOfLunar;
    }

    //曜伴月宿计算
    public static ConstellationOfNetAndSun cumulativeConstellationOfNetAndSun(ConstellationOfNetAndSun constellationOfLunar,CertainCelestial certainCelestial){
        ConstellationOfNetAndSun base= new ConstellationOfNetAndSun();

        int minConstellationOfLunar;//太阴日月宿化到子位
        minConstellationOfLunar=constellationOfLunar.constellation*60*60*6*67+constellationOfLunar.radian*60*6*67+constellationOfLunar.minute*6*67+constellationOfLunar.breath*707+constellationOfLunar.sub-1;
        int minCertainCelestial;//定曜化到子位
        minCertainCelestial=certainCelestial.celestia*60*60*6*67+certainCelestial.clepsydra*60*6*67+certainCelestial.minute*6*67+certainCelestial.breath*67+certainCelestial.sub;
        int minConstellationOfNetAndSun;//曜伴月宿化到子位
        if(minConstellationOfLunar>=minCertainCelestial){
            minConstellationOfNetAndSun=minConstellationOfLunar-minCertainCelestial;
        }else{
            minConstellationOfNetAndSun=minConstellationOfLunar+27*60*60*6*67-minCertainCelestial;
        }
        int businessOfsub=(minConstellationOfNetAndSun)/67;  //子商
        int remainderOfsub=(minConstellationOfNetAndSun)%67;  //子余

        int businessOfbreath=(businessOfsub)/6;  //息商
        int remainderOfbreath=(businessOfsub)%6; //息余

        int businessOfminute=(businessOfbreath)/60; //分商
        int remainderOfminute=(businessOfbreath)%60; //分余

        int businessOfradian=(businessOfminute)/60;  //弧刻商
        int remainderOfradian=(businessOfminute)%60; //弧刻余

        int businessOfconstellation=(businessOfradian)/27;  //宿商
        int remainderOfconstellation=(businessOfradian)%27;  //宿余

        int sixthSub =707-certainCelestial.sixthSub;

        base.setConstellationOfNetAndSun(remainderOfconstellation,remainderOfradian,remainderOfminute,remainderOfbreath,remainderOfsub,sixthSub);
        return base;
    }
}
