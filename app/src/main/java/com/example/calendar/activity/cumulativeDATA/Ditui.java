package com.example.calendar.activity.cumulativeDATA;


public class Ditui {
    public static void mainCumulative(){
        System.out.println((1026-1027)%60);
        int year=1987;
        int month=3;
        int yu=0;
        int jiyue=0,suanyu=0;
        TingYear[] [] years= new TingYear[3000][13];
        years[year][month]=new TingYear(year,month,0,jiyue,suanyu);
        System.out.println(year+"年"+month+"月：积年："+(year-1987)+"积月："+jiyue+"算余："+suanyu);
        //向前递推
        while(year>0){
            while (month >1){
                month--;
                yu = (yu+2)%67;
                jiyue--;
                if(yu!=0){
                    suanyu = 67-yu;

                }else{
                    suanyu = 0;
                }
               // toString(year, month, 60+(year - 1987)%60, jiyue, suanyu);
                years[year][month]=new TingYear(year,month,getCumulativeYear(year,month),jiyue,suanyu);
                //toString1(years[year][month]);

                if(suanyu==52||suanyu==53){
                    System.out.println("前一年有闰月！！！");
                    yu = yu+2;
                    jiyue--;
                    suanyu = ((67-yu) % 67);
                    //toRUNString(year, month-1,60+ (year - 1987)%60, jiyue, suanyu);
                    years[year][0]=new TingYear(year,month,getCumulativeYear(year,month),jiyue,suanyu);
                    //toString1(years[year][12]);
                }
            }
            month=13;
            year--;
            if(year==0){
                year--;
            }
        }

        //向后递推

        year=1987;
        month=3;
        yu=0;
        jiyue=0;
        while(year<2108) {
            while (month < 12){
                month++;
                yu = yu + 2;
                jiyue++;
                suanyu = yu % 67;
               // toString(year, month, (year - 1987), jiyue, suanyu);
                years[year][month]=new TingYear(year,month,getCumulativeYear(year,month),jiyue,suanyu);
               // toString1(years[year][month]);
                if(suanyu==48||suanyu==49){
                    System.out.println("有闰月！！！");
                    yu = yu + 2;
                    jiyue++;
                    suanyu = yu % 67;
                   // toRUNString(year, month, (year - 1987), jiyue, suanyu);
                    years[year][0]=new TingYear(year,month,getCumulativeYear(year,month),jiyue,suanyu);
                   // toString1(years[year][month]);
                }
            }
            month=0;
            year++;
        }
        int Liyuan;
        for(int i=1026;i<2100;i++){
            for(int j=1;j<13;j++){
                Liyuan=getLiyuan(years[i][j].getYear(),years[i][j].getMonth());
                years[i][j].setCumulativeMonth1(years[Liyuan][3].getJiyue());
                years[i][j].toString(years[i][j]);
            }
        }
    }

    public static int getLiyuan(int year,int month) {
        int liyuanNum,liyuan;
        liyuanNum = (year - 1027 )/60;
        liyuan = liyuanNum * 60 + 1027;
        if(liyuan==year&&month<3){
            return liyuan-60;
        }else{
            return liyuan;
        }
    }

    public static int getCumulativeYear(int year,int month){
        int cumulativeYear;
        if(year<=1987){
            if(month>2){
                cumulativeYear=(60+(year - 1987)%60)%60;
            }else{
                cumulativeYear=((60+(year - 1987)%60)-1)%60;
            }
        }else{
            if(month>2){
                cumulativeYear=(year - 1987)%60;
            }else{
                cumulativeYear=((year - 1987)-1)%60;
            }
        }
        return cumulativeYear;
    }


    private static void toString(int year, int month, int jinian, int jiyue, int suanyu) {
        if(month>2){
            System.out.println(year + "年" + month + "月：积年：" + jinian%60 + "积月：" + jiyue+ "算余：" + suanyu);
        }else{
            System.out.println(year + "年" + month + "月：积年：" + (jinian-1)%60 + "积月：" + jiyue + "算余：" + suanyu);
        }

    }

    private static void toRUNString(int year, int month, int jinian, int jiyue, int suanyu) {
        if(month>2){
            System.out.println(year + "年" + month + "闰月：积年：" + jinian%60 + "积月：" + jiyue+ "算余：" + suanyu);
        }else{
            System.out.println(year + "年" + month + "闰月：积年：" + (jinian-1)%60 + "积月：" + jiyue + "算余：" + suanyu);
        }

    }

}
