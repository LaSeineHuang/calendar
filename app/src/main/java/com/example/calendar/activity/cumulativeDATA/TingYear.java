package com.example.calendar.activity.cumulativeDATA;

public class TingYear {
    private int year;
    private int month;
    private int cumulativeYear;
    private  int cumulativeMonth;
    private int jiyue;
    private int cumulativeYu;
    private int isRunMonth;
    TingYear(int year, int month, int cumulativeYear, int jiyue, int cumulativeYu){
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
    public void setCumulativeMonth1(int liYuanJiyue) {
        this.cumulativeMonth = this.jiyue-liYuanJiyue;
    }

    public void setCumulativeMonth2(int cumulativeMonth) {
        this.cumulativeMonth = cumulativeMonth;
    }

    public static void toString(TingYear years) {
        if (years.isRunMonth == 1) {
            System.out.println(years.year + "年" + years.month + "闰月：积年：" + years.cumulativeYear + "积月1：" + years.jiyue +"积月2："+years.cumulativeMonth+"算余："+ years.cumulativeYu);
        } else {
            System.out.println(years.year + "年" + years.month + "月：积年：" + years.cumulativeYear + "积月1：" + years.jiyue+"积月2："+years.cumulativeMonth + "算余：" + years.cumulativeYu);
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
