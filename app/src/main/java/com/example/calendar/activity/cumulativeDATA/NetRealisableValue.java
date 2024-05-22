package com.example.calendar.activity.cumulativeDATA;

/*曜净行值*/
public class NetRealisableValue {
    int celestia;//曜
    int clepsydra;//漏刻
    int minute;//分
    int breath;//息
    int sub;//子
    int business;//商
    int flag;//损益率属于前步还是后步，前步为1，后步为0
    int surplus_and_deficit;//盈缩积


    public void setNetRealisableValue(int celestia,int clepsydra,int minute,int breath,int sub,int business,int flag,int surplus_and_deficit){
        this.celestia=celestia;
        this.clepsydra=clepsydra;
        this.minute=minute;
        this.breath=breath;
        this.sub=sub;
        this.business=business;
        this.flag=flag;
        this.surplus_and_deficit=surplus_and_deficit;
    }

    public void toStringNetRealisableValue() {
        System.out.println("曜净行值："+this.celestia+"z"+this.clepsydra+"q"+this.minute+"'"+this.breath+"“"+this.sub+"'”"+"   商数:"+this.business+" 前步还是后步："+flag+" 盈缩积"+this.surplus_and_deficit);
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

    public static NetRealisableValue cumulativeNetRealisableValue(int day, IntegerAndZero IAZ) {
        StepsAwayTable[] Monthly_StepsAwayTable = new StepsAwayTable[14];
        Monthly_StepsAwayTable[0] = new StepsAwayTable(0, 5, 0);
        Monthly_StepsAwayTable[1] = new StepsAwayTable(1, 5, 5);
        Monthly_StepsAwayTable[2] = new StepsAwayTable(2, 5, 10);
        Monthly_StepsAwayTable[3] = new StepsAwayTable(3, 5, 15);
        Monthly_StepsAwayTable[4] = new StepsAwayTable(4, 4, 19);
        Monthly_StepsAwayTable[5] = new StepsAwayTable(5, 3, 22);
        Monthly_StepsAwayTable[6] = new StepsAwayTable(6, 2, 24);
        Monthly_StepsAwayTable[7] = new StepsAwayTable(7, 1, 25);
        Monthly_StepsAwayTable[8] = new StepsAwayTable(8, 1, 24);
        Monthly_StepsAwayTable[9] = new StepsAwayTable(9, 2, 22);
        Monthly_StepsAwayTable[10] = new StepsAwayTable(10, 3, 19);
        Monthly_StepsAwayTable[11] = new StepsAwayTable(11, 4, 15);
        Monthly_StepsAwayTable[12] = new StepsAwayTable(12, 5, 10);
        Monthly_StepsAwayTable[13] = new StepsAwayTable(13, 5, 5);

        int business;
        int remainder;
        int NextRemainder;
        business = (day + IAZ.integer) / 14;
        remainder = (day + IAZ.integer) % 14;
        NextRemainder = (remainder + 1) % 14;

        int businessOfclepsydra = Monthly_StepsAwayTable[NextRemainder].profitability * IAZ.zero / 126; //漏刻商
        int remainderOfclepsydra = Monthly_StepsAwayTable[NextRemainder].profitability * IAZ.zero % 126; //漏刻余

        int businessOfminute = remainderOfclepsydra * 60 / 126; //分商
        int remainderOfminute = remainderOfclepsydra * 60 % 126;//分余

        int businessOfbreath = remainderOfminute * 6/ 126; //息商
        int remainderOfbreath = remainderOfminute * 6 % 126; //息余

        int businessOfsub = remainderOfbreath * 707 / 126; //子余

        NetRealisableValue base = new NetRealisableValue();
        int flag;
        if(NextRemainder>0&&NextRemainder<=7){
            flag=1;//前步
        }else{
            flag=0;//后步
        }
        base.setNetRealisableValue(0, businessOfclepsydra, businessOfminute, businessOfbreath, businessOfsub, business,flag,Monthly_StepsAwayTable[remainder].surplus_and_deficit);
        return base;
    }

}