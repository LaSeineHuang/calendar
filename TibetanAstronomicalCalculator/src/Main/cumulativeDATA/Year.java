package Main.cumulativeDATA;

class Year{
    int year;
    int month;
    int cumulativeYear;
    int cumulativeMonth;
    int jiyue;
    int cumulativeYu;
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
    public void setCumulativeMonth1(int liYuanJiyue) {
        this.cumulativeMonth = this.jiyue-liYuanJiyue;
    }

    public void setCumulativeMonth2(int cumulativeMonth) {
        this.cumulativeMonth = cumulativeMonth;
    }

    public static void toString(Year years) {
        if (years.isRunMonth == 1) {
            System.out.println(years.year + "年" + years.month + "闰月：积年：" + years.cumulativeYear + "积月1：" + years.jiyue +"积月2："+years.cumulativeMonth+"算余："+ years.cumulativeYu);
        } else {
            System.out.println(years.year + "年" + years.month + "月：积年：" + years.cumulativeYear + "积月1：" + years.jiyue+"积月2："+years.cumulativeMonth + "算余：" + years.cumulativeYu);
        }

    }
}
