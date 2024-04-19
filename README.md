# 积年与积月
* 藏历属阴阳合历，根据月相变化周期置月，每年12个月，闰年13个月。
* 计算藏历的积年积月，需要给定一个精确到月份的时间，下文中用年份代指输入的年份，月份代指输入的月份。
## 一、历元的判断
1. 概念 : 藏历1026年传入，1027年3月作为第一个起始的历元；每六十年更换一次历元。下表为历元表:   

| 历元序数 | 历元年 |  
|:----:|:---:|  
|    0   | 1027 |  
|    1   | 1087 |  
|    2   | 1147 |  
|    3   | 1207 |  
|   ...  |  ... |

2. 历元年确认公式
    * 历元序数 = （年份 - 1027）/ 60
    * 历元 = 历元序数 * 60 + 1027

3. 实现代码  
```   java 
public static int Liyuan(int year)
    {
        int liyuanNum,liyuan;
        liyuanNum = (year - 1027 )/60;
        liyuan = liyuanNum * 60 + 1027;
        return liyuan;
    }
```
## 二、积年
1. 概念 ：藏历中以三月为岁首，积年既相对于历元的已过年数。

2. 公式 ：
    * 当该月小于3月时：  
    积年 = 年份 - 历元 - 1
    * 当该月大于3月时：  
    积年 = 年份 - 历元 

3. 实现代码
```java
    public static int CumulativeYear(int year,int month){
        int CumulativeYear;
        if(month>2){
            CumulativeYear=(year-1027)%60;
        }else{
            CumulativeYear=(year-1027)%60-1;
        }
        return CumulativeYear;
    }
```
## 三、积月
1. 概念： 从历元年3月累计到所求日期的月份。1027年10月后置1个闰10月，为第一个闰月；之后每33和32个月后轮流置一个闰月。是否为闰月可以通过[^闰余]来判断。
2. 规律：藏历跟其他阴阳合历一样，需要调节朔望月与回归年之间的关系，使每个月所在的季节基本不变，所以一定时间会增加一个闰月。藏历遵循时轮历的规则，闰章为每65年置24个闰月。既每65年置闰月的年份和月份会循环一次。  
    * 可用如下公式对应查表计算：
    余数 =（年份-1026）% 65
    * 判断该年是是否是闰年  

| 余数 | 闰月数 | 年份循环1 | 年份循环2| 年份循环3 | ... | 
|:----:|:-----:|:--------:|:--------:|:--------:| :--:| 
|1     | 闰10月|  1027    |  1092    |   1157   | ... |
|4     | 闰6月 |  1030    |  1095    |   1160   | ... |
|7     | 闰3月 |  1033    |  1098    |   1163   | ... |
|9     | 闰11月|  1035    |  1100    |   1165   | ... |
|12    | 闰8月 |  1038    |  1103    |   1168   | ... |
|15    | 闰4月 |  1041    |  1106    |   1171   | ... |
|17    | 闰1月 |  1043    |  1108    |   1173   | ... |
|20    | 闰9月 |  1046    |  1111    |   1176   | ... |
|23    | 闰6月 |  1049    |  1114    |   1179   | ... |
|25    | 闰2月 |  1051    |  1116    |   1181   | ... |
|28    | 闰11月|  1054    |  1119    |   1184   | ... |
|31    | 闰7月 |  1057    |  1122    |   1187   | ... |
|34    | 闰4月 |  1060    |  1125    |   1190   | ... |
|36    | 闰12月|  1062    |  1127    |   1192   | ... |
|39    | 闰9月 |  1065    |  1130    |   1195   | ... |
|42    | 闰5月 |  1068    |  1133    |   1198   | ... |
|44    | 闰2月 |  1070    |  1135    |   1200   | ... |
|47    | 闰10月|  1073    |  1138    |   1203   | ... |
|50    | 闰7月 |  1076    |  1141    |   1206   | ... |
|53    | 闰3月 |  1079    |  1144    |   1209   | ... |
|55    | 闰12月|  1081    |  1146    |   1211   | ... |
|58    | 闰8月 |  1084    |  1149    |   1214   | ... |
|61    | 闰5月 |  1087    |  1152    |   1217   | ... |
|63    | 闰1月 |  1089    |  1154    |   1219   | ... |

   实现代码:返回1是该年有闰月，返回0时该年无闰月
```java
    public static int preYearIsCumulativeYear(int preYear){
        int yu = (preYear-1026)%65;
        if(yu==1||yu==4||yu==7||yu==9||yu==12||yu==15||yu==17||yu==20||yu==23||yu==25||yu==28||yu==31||yu==34||yu==36||yu==39||yu==42||yu==44||yu==47||yu==50||yu==53||yu==55||yu==58||yu==61||yu==63){
            return 1;
        }else {
            return 0;
        }
    }
```
积月计算：  
    *(（积年*12+（月份-3）+preYearIsCumulativeYear（年份））*2+历元闰余)%65=商......余    
    积月=积年*12+（月份-3）+商
    闰余=余  
    当闰余为48或49时，后一个月为闰月。  

# 五要素
## 一、曜基数
1、概念：
朔日的曜基数是所求月的平朔时刻和平朔日的周日。为所求月之前一月的三十日的值日曜(星期序数)和该太阴日结束时刻。1曜31漏刻50分0息480/707，加上四周的天数28，是朔望月的长度，即为29.53087太阳日。  
    
2、单位  
|位数|第一位|第二位|第三位|第四位|第五位|
|:--:|:---:|:--:|:--:|:--:|:--:|  
|单位|曜 |漏刻|分 |息 |子 |  
|符号| z | q | ' | " | '"|
|进位|7 |60|60|6|707|  

曜位的周序日名称：  
1：日曜  
2：月曜   
3：火曜   
4：水曜  
5：木曜  
6：金曜  
0：土曜    
  
漏刻：直译为”水量”，由滴漏计时而来。其时间长度为现代钟表的24分，接近于15分钟的刻，而与60分钟的小时相差较大，所以译为“漏刻”。在计量弧长时，也借用这个名词，把一宿的六十分之一叫作“刻”，本译解中为了与时间单位相区别，译为“弧刻”。在没有混淆的情况下，都简称为刻。凡第一位是曜数的，第二位必是漏刻;第一位是宿数的，第二位必是弧刻。当第一位是零而不写出单位时，第二位是漏刻还是弧刻，需根据具体情况作出判断。在算式中都用q表示。
  
3、计算
例如:3<sup>z</sup>37<sup>q</sup>43'2"140'"为历元之平朔时刻。此数与积月乘朔望月值相加后，以7除之，其商余即是星期之序数和该月的平朔时刻。三十日之太阴日结束时刻，即为平朔时刻。  
子：  
(积月*480+历元曜基数子位)/707=子商
(积月*480+历元曜基数子位)%707=子余  
息：  
(积月*0+历元曜基数息位+子商)/6=息商  
(积月*0+历元曜基数息位+子商)%6=息余  
分：  
(积月*50+历元曜基数分位+息商)/60=分商  
(积月*50+历元曜基数分位+息商)%60=分余  
漏刻：  
(积月*31+历元曜基数漏刻位+分商)/60=漏刻商  
(积月*31+历元曜基数漏刻位+分商)%60=漏刻余  
曜：  
(积月*1+历元曜基数曜位+漏刻商)/7=曜商  
(积月*1+历元曜基数曜位+漏刻商)%7=曜余  
结果为：曜余<sup>z</sup>漏刻余<sup>q</sup>分余'商余"子余'"
   
4、代码实现
```java
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
```  

## 整数与零数
1、概念：指月亮在所求月平朔距远地点的整日数，零数为日下之余分。    
  
2、计算  
零数：  
（积月*1+历元零数）/126=零数商  
（积月*1+历元零数）%126=零数余  
整数：  
（积月*2+历元整数+零数商）/28=整数商  
（积月*2+历元整数+零数商）%28=整数余    
计算结果：    
整数=整数余    
零数=零数余  

3、代码实现
```java
    public IntegerAndZero cumulativeIntegerAndZero(Year year,IntegerAndZero Liyuan){
        IntegerAndZero base= new IntegerAndZero();

        int businessOfzero=(year.cumulativeMonth*1+Liyuan.zero)%126;  //零数余
        int remainderOfzero=(year.cumulativeMonth*1+Liyuan.zero)/126;  //零数商

        int businessOfinteger=(year.cumulativeMonth*2+Liyuan.integer)%28;  //整数余
        int remainderOfinteger=(year.cumulativeMonth*2+Liyuan.integer)/28;  //整数商

        return base;
    }

```

## 太阳基数  
1、概念：太阳基数为所求月平朔时太阳距春分点的弧长亦即该时太阳的平黄经。2宿10弧刻58分1息17/67是每一个太阴月内太阳平均行度。0<sup>k</sup>4<sup>q</sup>21'5"43'"为每一太阴日平行弧长。24<sup>k</sup>59<sup>q</sup>6'1"41'"为历元时太阳距春分点弧长。
  
2、




   
