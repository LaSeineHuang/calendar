package com.example.calendar.activity.cumulativeDATA;

public class TingYear {
    int year;//key
    int month;//key
    int cumulativeYear; //value
    int cumulativeMonth;//value
    int jiyue;//value
    int  liyuan;//value
    int cumulativeYu;//value
    int isRunMonth;

    TingYear(int year,int month,int cumulativeYear,int jiyue,int cumulativeYu){
        this.year=year;
        this.month=month;
        this.cumulativeYear=cumulativeYear;
        this.jiyue=jiyue;
        this.cumulativeYu=cumulativeYu;
        if(cumulativeYu==50||cumulativeYu==51){
            this.isRunMonth=1;
        }else{
            this.isRunMonth=0;
        }
    }
    public void setCumulativeMonth1(int liYuanJiyue,int liyuan) {

        this.cumulativeMonth = this.jiyue - liYuanJiyue;
        this.liyuan =liyuan ;
    }

    public void setCumulativeMonth2(int cumulativeMonth) {
        this.cumulativeMonth = cumulativeMonth;
    }

   /* public static void toString(Year years) {
        if (years.isRunMonth == 1) {
            System.out.println(years.year + "年" + years.month + "闰月：积年：" + years.cumulativeYear + "积月1：" + years.jiyue +"积月2："+years.cumulativeMonth+"算余："+ years.cumulativeYu+"历元"+years.liyuan);
        } else {
            System.out.println(years.year + "年" + years.month + "月：积年：" + years.cumulativeYear + "积月1：" + years.jiyue+"积月2："+years.cumulativeMonth + "算余：" + years.cumulativeYu+"历元"+years.liyuan);
        }


    }*/

    public static void toString(Year years) {
        if (years.isRunMonth == 1) {
            System.out.println(years.year + "年" + years.month + "闰月：" + "算余：" + years.cumulativeYu);
        } else {
            System.out.println(years.year + "年" + years.month + "月：" + "算余：" + years.cumulativeYu);
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getCumulativeYear() {
        return cumulativeYear;
    }

    public void setCumulativeYear(int cumulativeYear) {
        this.cumulativeYear = cumulativeYear;
    }

    public int getCumulativeMonth() {
        return cumulativeMonth;
    }

    public void setCumulativeMonth(int cumulativeMonth) {
        this.cumulativeMonth = cumulativeMonth;
    }

    public int getJiyue() {
        return jiyue;
    }

    public void setJiyue(int jiyue) {
        this.jiyue = jiyue;
    }

    public int getLiyuan() {
        return liyuan;
    }

    public void setLiyuan(int liyuan) {
        this.liyuan = liyuan;
    }

    public int getCumulativeYu() {
        return cumulativeYu;
    }

    public void setCumulativeYu(int cumulativeYu) {
        this.cumulativeYu = cumulativeYu;
    }

    public int getIsRunMonth() {
        return isRunMonth;
    }

    public void setIsRunMonth(int isRunMonth) {
        this.isRunMonth = isRunMonth;
    }
}
