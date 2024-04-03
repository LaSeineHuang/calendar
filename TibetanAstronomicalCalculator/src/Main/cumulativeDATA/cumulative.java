package Main.cumulativeDATA;

public class cumulative {
    public static void mainCumulative(int year,int month) {
        //int year,month; //1027-2500
        //year=1987; //在此处填入年份
        //month=3;  //在此处填入月份
        int LiYuan;
        LiYuan = getLiyuan(year,month);
        //System.out.println("该年应选取历元："+LiYuan);
        int LiYuanYu;
        LiYuanYu=getLiyuanyu(LiYuan);
        //System.out.println("历元余："+LiYuanYu);
        int cumulativeYear;
        cumulativeYear=getCumulativeYear(year,month,LiYuan);
        if(preYearIsCumulativeYear(year-1)==1){
            //System.out.println("前一年有闰月");
        }else{
           // System.out.println("前一年无闰月");
        }
        //System.out.println("积年："+cumulativeYear);
        int cumulative[] = new int[3];
        cumulative=getCumulativeMonth(year,cumulativeYear,month,LiYuanYu);
        //System.out.println("积月："+cumulative[0]);
        //System.out.println("闰余："+cumulative[1]);
        if(cumulative[2]==1){
           // System.out.println("当月为闰月");
        }else{
            //System.out.println("当月不是闰月");
        }
        Year y=new Year(year,month,cumulativeYear,0,cumulative[1]);
        y.setCumulativeMonth2(cumulative[0]);
        y.toString(y);

    }
    public static int getLiyuan(int year,int month)
    {
        int liyuanNum,liyuan;
        liyuanNum = (year - 1027 )/60;
        liyuan = liyuanNum * 60 + 1027;
        if(liyuan==year&&month<3){
            return liyuan-60;
        }else{
            return liyuan;
        }
    }

    public static int getLiyuanyu(int liyuan)//后面用抓接口获得的数值
    {
        int num,liYuanYu;
        int[] ListofLiyuanyu =new int[]{35,45,57,0,10,20,30,40,52,62,5,15,25,35,45,57,65,10,20,30,40,52,62,5,15};
        num=(liyuan-1027)/60; //0<num<24
        liYuanYu=ListofLiyuanyu[num];
        return liYuanYu;
    }

    public static int getCumulativeYear(int year,int month,int liyuan){
        int CumulativeYear;
        if(month>2){
            CumulativeYear=(year-liyuan)%60;
        } else {
            CumulativeYear = (year - liyuan) % 60 - 1;
        }
        if(CumulativeYear==-1) CumulativeYear=59;
        return CumulativeYear;
    }

    public static int preYearIsCumulativeYear(int preYear){
        int yu = (preYear-1026)%65;
        if(yu==1||yu==4||yu==7||yu==9||yu==12||yu==15||yu==17||yu==20||yu==23||yu==25||yu==28||yu==31||yu==34||yu==36||yu==39||yu==42||yu==44||yu==47||yu==50||yu==53||yu==55||yu==58||yu==61||yu==63){
            return 1;
        }else {
            return 0;
        }
    }

    public static int[]  getCumulativeMonth(int year,int CumulativeYear,int month,int liyuanyu){
        int cumulative[] = new int[3];
        int CumulativeMonth,yu,shang;
        if(month>2){
            shang=((CumulativeYear*12+(month-3)+preYearIsCumulativeYear(year))*2+liyuanyu)/65;
            yu=((CumulativeYear*12+(month-3)+preYearIsCumulativeYear(year))*2+liyuanyu)%65;
            if(yu==50||yu==51){
                CumulativeMonth=CumulativeYear*12+(month-3)+shang;
                yu=yu;
                cumulative[2]=1;
            }else{
                CumulativeMonth=CumulativeYear*12+(month-3)+shang;
                yu=yu;
                cumulative[2]=0;
            }
            if((year-1027)%60==0&&month==3){
                yu=liyuanyu;
            }

        }else{
            shang=((CumulativeYear*12+(month+9)+liyuanyu+preYearIsCumulativeYear(year))*2)/65;
            yu=((CumulativeYear*12+(month+9)+liyuanyu+preYearIsCumulativeYear(year))*2)%65;
            if(yu==50||yu==51){
                CumulativeMonth=CumulativeYear*12+(month+9)+shang;
                yu=yu;
                cumulative[2]=1;
            }else{
                CumulativeMonth=CumulativeYear*12+(month+9)+shang;
                yu=yu;
                cumulative[2]=0;
            }

        }
        cumulative[0]=CumulativeMonth;
        cumulative[1]=yu;
        return cumulative;
    }

}
