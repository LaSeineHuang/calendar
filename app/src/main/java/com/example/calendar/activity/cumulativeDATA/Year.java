package com.example.calendar.activity.cumulativeDATA;

class Year{
    int year;//key
    int month;//key
    int cumulativeYear; //value
    int cumulativeMonth;//value
    int jiyue;
    int  liyuan;//value
    int cumulativeYu;//value
    int isRunMonth;

    Year(int year,int month,int cumulativeYear,int jiyue,int cumulativeYu){
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
    public int getCumulativeMonth(){
        return cumulativeMonth;
    }

    public int getCumulativeYu() {
        return cumulativeYu;
    }

    public void setLiyuan(int liyuan) {
        this.liyuan = liyuan;
    }

    public void setCumulativeMonth1(int liYuanJiyue, int liyuan) {

        this.cumulativeMonth = this.jiyue - liYuanJiyue;
        this.liyuan =liyuan ;
    }

    public void setCumulativeMonth2(int cumulativeMonth) {
        this.cumulativeMonth = cumulativeMonth;
    }

    public static void toString(Year years) {
        if (years.isRunMonth == 1) {
            System.out.println(years.year + "年" + years.month + "闰月：积年：" + years.cumulativeYear  +"积月："+years.cumulativeMonth+"算余："+ years.cumulativeYu+"历元"+years.liyuan);
        } else {
            System.out.println(years.year + "年" + years.month + "月：积年：" + years.cumulativeYear + "积月："+years.cumulativeMonth + "算余：" + years.cumulativeYu+"历元"+years.liyuan);
        }
    }
/*
    public static void toString(Year years) {
        if (years.isRunMonth == 1) {
            System.out.println(years.year + "年" + years.month + "闰月：积年：" + years.cumulativeYear  +"积月："+years.cumulativeMonth+"算余："+years.cumulativeYu);
        } else {
            System.out.println(years.year + "年" + years.month + "月：积年：" + years.cumulativeYear  +"积月："+years.cumulativeMonth+"算余："+ years.cumulativeYu);
        }
    }

 */
}
