package com.example.calendar.activity.cumulativeDATA;

public class CertainCelestial {
    int celestia;//曜
    int clepsydra;//漏刻
    int minute;//分
    int breath;//息
    int sub;//子
    int sixthSub;//第六子位
    public void setCertainCelestial(int celestia,int clepsydra,int minute,int breath,int sub,int sixthSub){
        this.celestia=celestia;
        this.clepsydra=clepsydra;
        this.minute=minute;
        this.breath=breath;
        this.sub=sub;
        this.sixthSub=sixthSub;
    }

    public void toStringCertainCelestial() {
        System.out.println("定曜："+this.celestia+"z"+this.clepsydra+"q"+this.minute+"'"+this.breath+"“"+this.sub+"'”"+this.sixthSub+"'”");
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
    public int getSixthSub(){
        return this.sixthSub;
    }
    //求月步
    public static CertainCelestial cumulativeStepOfNet(NetRealisableValue NRValue){
        CertainCelestial stepOfNet=new CertainCelestial();
        if(NRValue.flag==1){
            int radianOfSTN=(NRValue.clepsydra+NRValue.surplus_and_deficit)%60;
            int constellationOfSTN=(NRValue.clepsydra+NRValue.surplus_and_deficit)/60%7;
            stepOfNet.setCertainCelestial(constellationOfSTN,radianOfSTN,NRValue.minute, NRValue.breath, NRValue.sub, 0);
        }if(NRValue.flag==0){
            int minSurplus_and_deficit=NRValue.surplus_and_deficit*60*6*707;
            int minNRvalue= NRValue.celestia*60*60*6*707+ NRValue.clepsydra*60*6*707+ NRValue.minute*6*707+ NRValue.breath*707+ NRValue.sub;
            int minStepOfCelestial=minSurplus_and_deficit-minNRvalue;

            int businessOfsub=(minStepOfCelestial)/707;  //子商
            int remainderOfsub=(minStepOfCelestial)%707;  //子余

            int businessOfbreath=(businessOfsub)/6;  //息商
            int remainderOfbreath=(businessOfsub)%6; //息余

            int businessOfminute=(businessOfbreath)/60; //分商
            int remainderOfminute=(businessOfbreath)%60; //分余

            int businessOfclepsydra=(businessOfminute)/60;  //漏刻商
            int remainderOfclepsydra=(businessOfminute)%60; //漏刻余

            int businessOfcelestia=(businessOfclepsydra)/7;  //曜商
            int remainderOfcelestia=(businessOfclepsydra)%7;  //曜余
            stepOfNet.setCertainCelestial(remainderOfcelestia,remainderOfclepsydra,remainderOfminute,remainderOfbreath,remainderOfsub,0);
        }
        return stepOfNet;
    }
    //求半定曜
    public static CertainCelestial cumulativeSemideterminsticCelestial(NetRealisableValue NRValue,CertainCelestial stepOfNet, MiddleCelestia middleCelestial){
        CertainCelestial semideterminsticCelestial=new CertainCelestial();
        if(NRValue.business%2==0){
            int businessOfsub=(middleCelestial.sub+stepOfNet.sub)/707;  //子商
            int remainderOfsub=(middleCelestial.sub+stepOfNet.sub)%707;  //子余

            int businessOfbreath=(middleCelestial.breath+stepOfNet.breath+businessOfsub)/6;  //息商
            int remainderOfbreath=(middleCelestial.breath+stepOfNet.breath+businessOfsub)%6; //息余

            int businessOfminute=(middleCelestial.minute+stepOfNet.minute+businessOfbreath)/60; //分商
            int remainderOfminute=(middleCelestial.minute+stepOfNet.minute+businessOfbreath)%60; //分余

            int businessOfclepsydra=(middleCelestial.minute+stepOfNet.minute+businessOfminute)/60;  //漏刻商
            int remainderOfclepsydra=(middleCelestial.minute+stepOfNet.minute+businessOfminute)%60; //漏刻余

            int businessOfcelestia=(middleCelestial.minute+stepOfNet.minute+businessOfclepsydra)/7;  //曜商
            int remainderOfcelestia=(middleCelestial.minute+stepOfNet.minute+businessOfclepsydra)%7;  //曜余

            int sub=(remainderOfsub*67)/707; //第五子位
            int sixthSub=(remainderOfsub*67)%707; //第六子位

            semideterminsticCelestial.setCertainCelestial(remainderOfcelestia,remainderOfclepsydra,remainderOfminute,remainderOfbreath,sub,sixthSub);
        }else{
            int minMiddleCelestial;//中曜化到子位
            minMiddleCelestial=middleCelestial.celestia*60*60*6*707+middleCelestial.clepsydra*60*6*707+middleCelestial.minute*6*707+middleCelestial.breath*707+middleCelestial.sub;
            int minStepOfNet;//月步化到子位
            minStepOfNet=stepOfNet.celestia*60*60*6*707+stepOfNet.clepsydra*60*6*707+stepOfNet.minute*6*707+stepOfNet.breath*707+stepOfNet.sub;
            int minSemideterminsticCelestial;//半定曜化到子位
            if(minMiddleCelestial>=minMiddleCelestial){
                minSemideterminsticCelestial=minMiddleCelestial-minStepOfNet;
            }else{
                minSemideterminsticCelestial=minMiddleCelestial+27*60*60*6*67-minStepOfNet;
            }
            int businessOfsub=(minSemideterminsticCelestial)/707;  //子商
            int remainderOfsub=(minSemideterminsticCelestial)%707;  //子余

            int businessOfbreath=(businessOfsub)/6;  //息商
            int remainderOfbreath=(businessOfsub)%6; //息余

            int businessOfminute=(businessOfbreath)/60; //分商
            int remainderOfminute=(businessOfbreath)%60; //分余

            int businessOfclepsydra=(businessOfminute)/60;  //漏刻商
            int remainderOfclepsydra=(businessOfminute)%60; //漏刻余

            int businessOfcelestia=(businessOfclepsydra)/7;  //曜商
            int remainderOfcelestia=(businessOfclepsydra)%7;  //曜余

            int sub=(remainderOfsub*67)/707; //第五子位
            int sixthSub=(remainderOfsub*67)%707; //第六子位

            semideterminsticCelestial.setCertainCelestial(remainderOfcelestia,remainderOfclepsydra,remainderOfminute,remainderOfbreath,sub,sixthSub);
        }
        return semideterminsticCelestial;
    }
    public static CertainCelestial cumulativeCertainCelestial(SunRealisableValue SRvalue,CertainSun stepOfSun, CertainCelestial semideterminsticCelestial){
        CertainCelestial base=new CertainCelestial();
        if(SRvalue.flag==1){
            int businessOfsub=(semideterminsticCelestial.sub+stepOfSun.sub)/707;  //子商
            int remainderOfsub=(semideterminsticCelestial.sub+stepOfSun.sub)%707;  //子余

            int businessOfbreath=(semideterminsticCelestial.breath+stepOfSun.breath+businessOfsub)/6;  //息商
            int remainderOfbreath=(semideterminsticCelestial.breath+stepOfSun.breath+businessOfsub)%6; //息余

            int businessOfminute=(semideterminsticCelestial.minute+stepOfSun.minute+businessOfbreath)/60; //分商
            int remainderOfminute=(semideterminsticCelestial.minute+stepOfSun.minute+businessOfbreath)%60; //分余

            int businessOfclepsydra=(semideterminsticCelestial.clepsydra+stepOfSun.radian+businessOfminute)/60;  //漏刻商
            int remainderOfclepsydra=(semideterminsticCelestial.clepsydra+stepOfSun.radian+businessOfminute)%60; //漏刻余

            int businessOfcelestia=(semideterminsticCelestial.celestia+stepOfSun.constellation+businessOfclepsydra)/7;  //曜商
            int remainderOfcelestia=(semideterminsticCelestial.celestia+stepOfSun.constellation+businessOfclepsydra)%7;  //曜余

            int sixthSub= semideterminsticCelestial.sixthSub; //第六子位

            base.setCertainCelestial(remainderOfcelestia,remainderOfclepsydra,remainderOfminute,remainderOfbreath,remainderOfsub,sixthSub);
        }else{
            int minSemideterminsticCelestial;//半定曜化到子位
            minSemideterminsticCelestial=semideterminsticCelestial.celestia*60*60*6*707+semideterminsticCelestial.clepsydra*60*6*707+semideterminsticCelestial.minute*6*707+semideterminsticCelestial.breath*707+semideterminsticCelestial.sub;
            int minStepOfSun;//日步化到子位
            minStepOfSun=stepOfSun.constellation*60*60*6*67+stepOfSun.radian*60*6*67+stepOfSun.minute*6*67+stepOfSun.breath*67+stepOfSun.sub;
            int minCertainNet;//半定曜化到子位
            if(minSemideterminsticCelestial>=minStepOfSun){
                minCertainNet=minSemideterminsticCelestial-minStepOfSun;
            }else{
                minCertainNet=minSemideterminsticCelestial+27*60*60*6*67-minStepOfSun;
            }
            int businessOfsub=(minCertainNet)/707;  //子商
            int remainderOfsub=(minCertainNet)%707;  //子余

            int businessOfbreath=(businessOfsub)/6;  //息商
            int remainderOfbreath=(businessOfsub)%6; //息余

            int businessOfminute=(businessOfbreath)/60; //分商
            int remainderOfminute=(businessOfbreath)%60; //分余

            int businessOfclepsydra=(businessOfminute)/60;  //漏刻商
            int remainderOfclepsydra=(businessOfminute)%60; //漏刻余

            int businessOfcelestia=(businessOfclepsydra)/7;  //曜商
            int remainderOfcelestia=(businessOfclepsydra)%7;  //曜余

            int sixthSub= semideterminsticCelestial.sixthSub; //第六子位

            base.setCertainCelestial(remainderOfcelestia,remainderOfclepsydra,remainderOfminute,remainderOfbreath,remainderOfsub,sixthSub);
        }
        return base;
    }
}
