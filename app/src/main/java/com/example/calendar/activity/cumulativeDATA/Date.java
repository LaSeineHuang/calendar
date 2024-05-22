package com.example.calendar.activity.cumulativeDATA;

public class Date {
    String name;//日期配合名
    String Fname;//前分名
    String Lname;//后分名
    public void setDate(String name,String Fname,String Lname){
        this.name=name;
        this.Fname=Fname;
        this.Lname=Lname;
    }

    public void toStringDate() {
        System.out.println("日期名："+this.name);
        System.out.println("日期前分为："+this.Fname+" 日期后分为："+this.Lname);
    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public static String chooseNameOfDate(int n){
        switch (n){
            case 0:
                return "满日";
            case 1:
                return "喜日";
            case 2:
                return "善日";
            case 3:
                return "胜日";
            case 4:
                return "空日";
        }
        return null;
    }
    public static String chooseFLNameOfDate(int n){
        switch (n){
            case 0:
                return "毗支";
            case 1:
                return "枝稍";
            case 2:
                return "孺童";
            case 3:
                return "具种";
            case 4:
                return "榨麻油";
            case 5:
                return "家生";
            case 6:
                return "商贾";
        }
        return null;
    }
    public static Date cumulativeNameOfDate(int day){
        Date date= new Date();
        int i;
        i=day%5;
        date.name=date.chooseNameOfDate(i);

        int remainder=(day*2-1)%7;
        int NextRemainder;
        if(remainder==0){
            NextRemainder=remainder+6;
        }else{
            NextRemainder=remainder-1;
        }
        date.Fname=date.chooseFLNameOfDate(NextRemainder);
        date.Lname=date.chooseFLNameOfDate(remainder);
        if(day==1){
            date.Fname="不净";
        }else if(day==29){
            date.Lname="吉祥";
        }else if(day==30){
            date.Fname="四足";
            date.Lname="蛟龙";
        }
        date.setDate(date.name,date.Fname, date.Lname);
        return date;
    }

}
