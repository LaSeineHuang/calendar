package com.example.calendar.activity.cumulativeDATA;

import com.example.calendar.activity.bean.BeanTest;

import javax.crypto.spec.PBEKeySpec;

public class MainCumulative {
    public static BeanTest cumulative(int y, int m, int day) {
        BeanTest beanTest=new BeanTest();

        Year year=new Ditui().mainCumulative(y,m);//这里用ditui存的数据
        beanTest.setYear(y);
        beanTest.setMonth(m);
        beanTest.setDay(day);
        beanTest.setCumulativeMonth(year.getCumulativeMonth());
        beanTest.setCumulativeYu(year.getCumulativeYu());
        //调用IntegerAndZero的方法求零整数
        IntegerAndZero IandZ = new IntegerAndZero();
        IntegerAndZero Li =new IntegerAndZero();//我会给个历元整数零数表 存本地
        Li.setIntegerAndZero(5,59);  //历元整数零数表
        year.setCumulativeMonth2(2); //这里用ditui存的数据
        IandZ=IandZ.cumulativeIntegerAndZero(year,Li);
        //IandZ.toStringIntegerAndZero();  //调用完成后 year.year(key) year.month(key) IandZ.integer(value) IandZ.zero(value)存本地
        beanTest.setInteger(IandZ.getInteger());
        beanTest.setZero(IandZ.getZero());

        //调用CelestialBase的方法求曜基数
        CelestialBase CB =new CelestialBase(); //我会给个历元曜基数表 存本地
        CB.setCelestialBase(6,28,13,4,166);//历元基数表里取
        CelestialBase celestialBase =new CelestialBase();
        celestialBase=celestialBase.cumulativeCelestiaBase(CB,year);
        //celestialBase.toStringCelestialBase(); //调用完成后 year.year(key) year.month(key) celestialBase(value)存本地
        beanTest.setCelestialBase(celestialBase.getCelestia(),celestialBase.getClepsydra(),celestialBase.getMinute(), celestialBase.getBreath(), celestialBase.getSub());

        //调用SunBase的方法求太阳基数
        SunBase SB=new SunBase();//我会给个历元太阳基数表 存本地
        SB.setSunBase(25,49,28,3,63);
        SunBase sunBase =new SunBase();
        sunBase=sunBase.cumulativeSunBase(SB,year);
        //sunBase.toStringSunBase(); //调用完成后 year.year(key) year.month(key) sunBase(value)存本地
        beanTest.setSunBase(sunBase.getConstellation(),sunBase.getRadian(),sunBase.getMinute(),sunBase.getBreath(),sunBase.getSub());

        //调用MiddleCelestia的方法求中曜
        MiddleCelestia middleCelestia=new MiddleCelestia();
        middleCelestia=middleCelestia.cumulativeMiddleCelestia(celestialBase,day);//入参是该月曜基数和日序数
        middleCelestia.toStringMiddleCelestial();//调用完成后 year.year(key) year.month(key) day(key) middleCelestial(value)存本地

        //调用MiddleSun的方法求中日
        MiddleSun middleSun=new MiddleSun();
        middleSun=middleSun.cumulativeMiddleSun(sunBase,day);//入参是该月太阳基数和日序数
        middleSun.toStringMiddleSun();//调用完成后 year.year(key) year.month(key) day(key) middleSun(value)存本地

        //调用NetRealisableValue的方法求曜净行值
        NetRealisableValue NRvalue=new NetRealisableValue();
        NRvalue=NRvalue.cumulativeNetRealisableValue(day,IandZ);//入参是该月零数整数和日序数
        NRvalue.toStringNetRealisableValue();//调用完成后 year.year(key) year.month(key) day(key) Nvalue(value)存本地

        //调用SunRealisableValue的方法求太阳净行值
        SunRealisableValue SRvalue=new SunRealisableValue();
        SRvalue=SRvalue.cumulativeSunRealisableValue(middleSun);//入参是该月零数整数和日序数
        SRvalue.toStringNetRealisableValue();//调用完成后 year.year(key) year.month(key) day(key) Nvalue(value)存本地

        //调用CertainSun的方法求定日
        CertainSun stepOfSun=new CertainSun();//先求日步
        stepOfSun=stepOfSun.cumulativeStepOfSun(SRvalue);//入参是该日太阳净行值,调用完成后 year.year(key) year.month(key) day(key) stepOfSun(value)存本地
        CertainSun certainSun=new CertainSun();
        certainSun=certainSun.cumulativeCertainSun(SRvalue,middleSun,stepOfSun);//入参是该日太阳净行值和中日
       // certainSun.toStringCertainSun();//调用完成后 year.year(key) year.month(key) day(key) certainSun(value)存本地
        beanTest.setCertainSun(certainSun.getConstellation(),certainSun.getRadian(),certainSun.getMinute(),certainSun.getBreath(),certainSun.getSub());

        //调用CertainCelestial中的方法求定曜
        CertainCelestial stepOfNet=new CertainCelestial();//先求月步
        stepOfNet=stepOfNet.cumulativeStepOfNet(NRvalue);//入参是该日曜净行值,调用完成后 year.year(key) year.month(key) day(key) stepOfNet(value)存本地
        CertainCelestial semideterminsticCelestial=new CertainCelestial();//求半定曜
        semideterminsticCelestial=semideterminsticCelestial.cumulativeSemideterminsticCelestial(NRvalue,stepOfNet,middleCelestia);
        CertainCelestial certainCelestial=new CertainCelestial();
        certainCelestial=certainCelestial.cumulativeCertainCelestial(SRvalue,stepOfSun,semideterminsticCelestial);
        //certainCelestial.toStringCertainCelestial();
        beanTest.setCertainCelestial(certainCelestial.getCelestia(),certainCelestial.getClepsydra(),certainCelestial.getMinute(),certainCelestial.getBreath(),certainCelestial.getSub(),certainCelestial.getSixthSub());

        //调用ConstellationOfNetAndSun中的方法求曜伴月宿
        ConstellationOfNetAndSun constellationOfLunar =new ConstellationOfNetAndSun();
        constellationOfLunar=constellationOfLunar.cumulativeConstellationOfLunar(certainSun,day);
        ConstellationOfNetAndSun COfNetAndSun= new ConstellationOfNetAndSun();
        COfNetAndSun=COfNetAndSun.cumulativeConstellationOfNetAndSun(constellationOfLunar,certainCelestial);
        //COfNetAndSun.toStringConstellationOfNetAndSun();
        beanTest.setCOfNetAndSun(COfNetAndSun.getConstellation(),COfNetAndSun.getRadian(),COfNetAndSun.getMinute(),COfNetAndSun.getBreath(),COfNetAndSun.getSub(),COfNetAndSun.getSixthSub());

        //调用Meet中的方法求会合值
        Meet meet =new Meet();
        meet=meet.cumulativeMeet(certainSun, COfNetAndSun);
        //meet.toStringMeet();
        beanTest.setMeet(meet.getConstellation(),meet.getRadian(),meet.getMinute(),meet.getBreath(),meet.getSub());

        //调用Date中的方法求日期名和作用名
        Date date =new Date();
        date=date.cumulativeNameOfDate(day);
        // date.toStringDate();
        beanTest.setName(date.getName(),date.getFname(),date.getLname());

        //调用SurplusDay的方法求五曜公积日
        SurplusDay Liyuan=new SurplusDay();//先带个数 最后查表
        Liyuan.setSurplusDay(0,34,630);
        SurplusDay surplusDay=new SurplusDay();
        surplusDay=surplusDay.cumulativeSurplusDay(Liyuan,year,day);
        //surplusDay.toStringSurplusDay();
        beanTest.setSurplusDay(surplusDay.getSurplusDay(),surplusDay.getMedian(),surplusDay.getInferior());

        //调用SpecialDay的方法求五曜殊日
        SpecialDay LY=new SpecialDay();//先带个数 最后查表
        LY.setSpecialDay(497,131,533,6743,932);
        SpecialDay specialDay=new SpecialDay();
        specialDay=specialDay.cumulativeSpecialDay(LY,surplusDay);
        //specialDay.toStringSpecialDay();
        beanTest.setSpecialDay(specialDay.getMars(),specialDay.getJupiter(),specialDay.getSaturn(),specialDay.getMercury(), specialDay.getVenus());

        //调用PlaceOfPlant的方法求五曜的方位
        //火曜
        PlaceOfPlant mars =new PlaceOfPlant();
        mars=mars.cumulativePlaceOfPlant(specialDay.mars,687);
        //System.out.println("火曜");
        //mars.toStringPlaceOfPlant();
        beanTest.setMars(mars.getCelestia(),mars.getClepsydra(),mars.getMinute(),mars.getBreath(),mars.getSub());

        //木曜
        PlaceOfPlant jupiter =new PlaceOfPlant();
        jupiter=jupiter.cumulativePlaceOfPlant(specialDay.jupiter,4332);
        //System.out.println("木曜");
        //jupiter.toStringPlaceOfPlant();
        beanTest.setJupiter(jupiter.getCelestia(),jupiter.getClepsydra(),jupiter.getMinute(),jupiter.getBreath(),jupiter.getSub());

        //土曜
        PlaceOfPlant saturn=new PlaceOfPlant();
        saturn=saturn.cumulativePlaceOfPlant(specialDay.saturn,10766);
        //System.out.println("土曜");
        //saturn.toStringPlaceOfPlant();
        beanTest.setSaturn(saturn.getCelestia(),saturn.getClepsydra(),saturn.getMinute(),saturn.getBreath(),saturn.getSub());

        //水曜
        PlaceOfPlant mercury =new PlaceOfPlant();
        mercury= mercury.cumulativePlaceOfPlant(specialDay.mercury,8797);
        //System.out.println("水曜");
        //mercury.toStringPlaceOfPlant();
        beanTest.setMercury(mercury.getCelestia(),mercury.getClepsydra(),mercury.getMinute(),mercury.getBreath(),mercury.getSub());

        //金曜
        PlaceOfPlant venus =new PlaceOfPlant();
        venus=venus.cumulativePlaceOfPlant(specialDay.venus,2247);
        //System.out.println("金曜");
        //venus.toStringPlaceOfPlant();
        beanTest.setVenus(venus.getCelestia(),venus.getClepsydra(),venus.getMinute(),venus.getBreath(),venus.getSub());

        return beanTest;
    }

}
