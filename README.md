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



    



## 四、闰余
