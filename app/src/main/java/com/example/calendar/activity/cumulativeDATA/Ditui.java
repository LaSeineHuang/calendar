package com.example.calendar.activity.cumulativeDATA;


public class Ditui {
    public static void mainCumulative(){
        System.out.println((1026-1027)%60);
        int year=1987;
        int month=3;
        int yu=0;
        int jiyue=0,suanyu=0;
        int BCyear;
        Year[] [] years= new Year[5000][13];
        years[year][month]=new Year(year,month,0,jiyue,suanyu);
        //向前递推
        while(year>-500){
            while (month >1){
                month--;
                yu = (yu+2)%67;
                jiyue--;
                if(yu!=0){
                    suanyu = 67-yu;

                }else{
                    suanyu = 0;
                }
                if(year<0)
                {
                    BCyear=year+4500;
                    years[BCyear][month]=new Year(year,month,getCumulativeYear(year,month),jiyue,suanyu);
                }else{
                    years[year][month]=new Year(year,month,getCumulativeYear(year,month),jiyue,suanyu);
                }

//1yue
                if(suanyu==52||suanyu==53){
                    //  System.out.println("前一个月是闰月！！！");
                    yu = yu+2;
                    jiyue--;
                    suanyu = ((67-yu) % 67);
                    if(month!=1)
                    {
                        if(year<0)
                        {
                            BCyear=year+4500;
                            years[BCyear][0]=new Year(year,month-1,getCumulativeYear(year,month),jiyue,suanyu);

                        }else{
                            years[year][0]=new Year(year,month-1,getCumulativeYear(year,month),jiyue,suanyu);
                        }

                    }else {
                        if(year<0)
                        {
                            BCyear=year-1+4500;
                            years[BCyear][0]=new Year(year-1,12,getCumulativeYear(year,month),jiyue,suanyu);
                        }else{
                            years[year-1][0]=new Year(year-1,12,getCumulativeYear(year,month),jiyue,suanyu);
                        }
                    }


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
        while(year<3000) {
            while (month < 12){
                month++;
                yu = yu + 2;
                jiyue++;
                suanyu = yu % 67;
                years[year][month]=new Year(year,month,getCumulativeYear(year,month),jiyue,suanyu);
                if(suanyu==48||suanyu==49){
                    yu = yu + 2;
                    jiyue++;
                    suanyu = yu % 67;
                    years[year][0]=new Year(year,month,getCumulativeYear(year,month),jiyue,suanyu);
                }
            }
            month=0;
            year++;
        }
        int Liyuan;
        int y;
        for(int i=-472;i<3000;i++){
            for(int j=1;j<13;j++){
                if(i<0){
                    y=i+4500;
                }else if(i==0){
                    continue;
                }else{
                    y=i;
                }
                Liyuan=getLiyuan(years[y][j].year,years[y][j].month);
                if(Liyuan<0){
                    Liyuan=+Liyuan+4500;
                    years[y][j].setCumulativeMonth1(years[Liyuan][3].jiyue,Liyuan-4500);
                }else{
                    Liyuan=Liyuan;
                    years[y][j].setCumulativeMonth1(years[Liyuan][3].jiyue,Liyuan);
                }

                years[y][j].toString(years[y][j]);
                if(years[y][j].cumulativeYu==48||years[y][j].cumulativeYu==49){
                    Liyuan=getLiyuan(years[y][0].year,years[y][0].month);
                    if(Liyuan<0){
                        Liyuan=Liyuan+4500;
                        years[y][0].setCumulativeMonth1(years[Liyuan][3].jiyue,Liyuan-4500);
                    }else{
                        Liyuan=Liyuan;
                        years[y][0].setCumulativeMonth1(years[Liyuan][3].jiyue,Liyuan);
                    }
                    years[y][0].toString(years[y][0]);
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
