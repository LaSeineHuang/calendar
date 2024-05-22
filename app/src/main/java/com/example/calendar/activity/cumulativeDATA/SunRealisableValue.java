package com.example.calendar.activity.cumulativeDATA;
/*太阳净行*/
public class SunRealisableValue {
    int constellation;//宿
    int radian;//弧刻
    int minute;//分
    int breath;//息
    int sub;//子

    int flag;//是否减半周标志位 减半周后为1 不减半周为0
    int surplus_and_deficit; //宫刻对应盈缩积

    public void setSunRealisableValue(int constellation,int radian,int minute,int breath,int sub,int flag,int surplus_and_deficit){
        this.constellation=constellation;
        this.radian=radian;
        this.minute=minute;
        this.breath=breath;
        this.sub=sub;
        this.flag=flag;
        this.surplus_and_deficit=surplus_and_deficit;
    }

    public void toStringNetRealisableValue() {
        System.out.println("太阳净行值："+this.constellation+"k"+this.radian+"q"+this.minute+"'"+this.breath+"“"+this.sub+"'”"+"   减半周标志:"+this.flag+"盈缩积："+this.surplus_and_deficit);
    }

    public static SunRealisableValue cumulativeSunRealisableValue(MiddleSun middleSun) {
        StepsAwayTable[] Solar_StepsAwayTable = new StepsAwayTable[6];
        Solar_StepsAwayTable[0] = new StepsAwayTable(0, 6, 0);
        Solar_StepsAwayTable[1] = new StepsAwayTable(1, 6, 6);
        Solar_StepsAwayTable[2] = new StepsAwayTable(2, 4, 10);
        Solar_StepsAwayTable[3] = new StepsAwayTable(3, 1, 11);
        Solar_StepsAwayTable[4] = new StepsAwayTable(4, 1, 10);
        Solar_StepsAwayTable[5] = new StepsAwayTable(5, 4, 6);
        //中日减去6宿45弧刻
        int radian,constellation,minute,breath,sub,flag;
        //弧刻位处理
        if(middleSun.radian<45){  //借宿位
            radian= middleSun.radian+60-45;
            constellation= middleSun.constellation-1;
        }else{ //不借位
            radian= middleSun.radian-45;
            constellation= middleSun.constellation;
        }
        //宿位处理
        if(constellation<6){  //补位
            constellation= constellation+27-6;
        }else{
            constellation= constellation-6;
        }
        //判断是否能减半周
        if((constellation*60+radian)>=810){  //13宿30弧刻=810弧刻
            int data=constellation*60+radian;
            radian=(data-810)%60;
            constellation=(data-810)/60;
            //   System.out.println(data+" "+constellation+" "+radian);
            flag=1;
        }else{
            flag=0;
        }
        //System.out.println(constellation+" "+radian);

        //化宫刻并查日踱步度表
        int business;
        int remainder;
        int NextBusiness;
        business = (constellation*60+radian) / 135;
        remainder = (constellation*60+radian) % 135;
        //System.out.println(business+"  "+remainder);
        NextBusiness = (business + 1) % 6;

        sub=middleSun.sub*Solar_StepsAwayTable[NextBusiness].profitability;
        breath=middleSun.breath*Solar_StepsAwayTable[NextBusiness].profitability;
        minute=middleSun.minute*Solar_StepsAwayTable[NextBusiness].profitability;
        radian=remainder*Solar_StepsAwayTable[NextBusiness].profitability;
        //System.out.println(sub+" "+breath+" "+minute+" "+radian);

        //化宫刻
        int businessOfradian = radian/135 ; //弧刻商
        int remainderOfradian = radian%135; //弧刻余

        int businessOfminute = (remainderOfradian * 60+minute) / 135; //分商
        int remainderOfminute =(remainderOfradian * 60+minute) % 135;//分余

        int businessOfbreath = (remainderOfminute * 6 +breath)/ 135; //息商
        int remainderOfbreath =( remainderOfminute * 6 +breath)% 135; //息余

        int businessOfsub = (remainderOfbreath * 67 +sub)/135; //子余
        SunRealisableValue base = new SunRealisableValue();
        if(business==1||business==2||business==3){
            base.setSunRealisableValue(business,businessOfradian,businessOfminute, businessOfbreath, businessOfsub, flag,Solar_StepsAwayTable[business].surplus_and_deficit);
        }else{
            base.setSunRealisableValue(business,businessOfradian,businessOfminute, businessOfbreath, businessOfsub,flag, Solar_StepsAwayTable[business].surplus_and_deficit);
        }
        return base;
    }
}
