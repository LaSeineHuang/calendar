package com.example.calendar.activity.cumulativeDATA;

public class PlaceOfPlant {
    int celestia;//曜
    int clepsydra;//漏刻
    int minute;//分
    int breath;//息
    int sub;//子

    public void setPlaceOfPlant(int celestia,int clepsydra,int minute,int breath,int sub){
        this.celestia=celestia;
        this.clepsydra=clepsydra;
        this.minute=minute;
        this.breath=breath;
        this.sub=sub;
    }
    public void toStringPlaceOfPlant() {
        System.out.println(this.celestia+"z"+this.clepsydra+"q"+this.minute+"'"+this.breath+"“"+this.sub+"'”");
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

    public PlaceOfPlant cumulativePlaceOfPlant(int specialDay, int period){
        PlaceOfPlant base= new PlaceOfPlant();

        int businessOfconstellation=(specialDay*27)/period;  //宿商
        int remainderOfconstellation=(specialDay*27)%period;  //宿余

        int businessOfradian=(remainderOfconstellation*60)/period;  //弧刻商
        int remainderOfradian=(remainderOfconstellation*60)%period; //弧刻余

        int businessOfminute=(remainderOfradian*60)/period; //分商
        int remainderOfminute=(remainderOfradian*60)%period; //分余

        int businessOfbreath=(remainderOfminute*6)/period;  //息商
        int remainderOfbreath=(remainderOfminute*6)%period; //息余

        int businessOfsub=(remainderOfbreath*6)/period;  //子商
        base.setPlaceOfPlant(businessOfconstellation,businessOfradian,businessOfminute,businessOfbreath, businessOfsub);
        return base;
    }
}
