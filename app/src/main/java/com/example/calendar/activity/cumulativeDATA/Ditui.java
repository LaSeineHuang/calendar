package com.example.calendar.activity.cumulativeDATA;


public class Ditui {
    public static void mainCumulative(){
        System.out.println((1026-1027)%60);
        int year=1987;
        int month=3;
        int yu=0;
        int jiyue=0,suanyu=0;
        Year[] [] years= new Year[3000][13];
        years[year][month]=new Year(year,month,0,jiyue,suanyu);
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
                //toString(year, month, 60+(year - 1987)%60, jiyue, suanyu);
                years[year][month]=new Year(year,month,getCumulativeYear(year,month),jiyue,suanyu);
                //toString1(years[year][month]);
//1yue
                if(suanyu==52||suanyu==53){
                    System.out.println("前一个月是闰月！！！");
                    yu = yu+2;
                    jiyue--;
                    suanyu = ((67-yu) % 67);
                    //toRUNString(year, month-1,60+ (year - 1987)%60, jiyue, suanyu);
                    if(month!=1)
                    {
                        years[year][0]=new Year(year,month-1,getCumulativeYear(year,month),jiyue,suanyu);
                    }else {
                        years[year-1][0]=new Year(year-1,12,getCumulativeYear(year,month),jiyue,suanyu);
                    }

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
                years[year][month]=new Year(year,month,getCumulativeYear(year,month),jiyue,suanyu);
                // toString1(years[year][month]);
                if(suanyu==48||suanyu==49){
                    System.out.println("有闰月！！！");
                    yu = yu + 2;
                    jiyue++;
                    suanyu = yu % 67;
                    // toRUNString(year, month, (year - 1987), jiyue, suanyu);
                    years[year][0]=new Year(year,month,getCumulativeYear(year,month),jiyue,suanyu);
                    // toString1(years[year][month]);
                }
            }
            month=0;
            year++;
        }
        int Liyuan;
        for(int i=8;i<2100;i++){
            for(int j=1;j<13;j++){
                Liyuan=getLiyuan(years[i][j].year,years[i][j].month);
                years[i][j].setCumulativeMonth1(years[Liyuan][3].jiyue,Liyuan);
                years[i][j].toString(years[i][j]);
                if(years[i][j].cumulativeYu==48||years[i][j].cumulativeYu==49){
                    years[i][0].toString(years[i][0]);
                }
            }
        }
    }

    public static int getLiyuan(int year,int month) {
        int liyuanNum,liyuan;
        liyuanNum = (year - 1027 )/60;
        if(liyuanNum<0){
            liyuan=(liyuanNum-1)*60+1027;
        }else{
            liyuan = liyuanNum * 60 + 1027;
        }
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
