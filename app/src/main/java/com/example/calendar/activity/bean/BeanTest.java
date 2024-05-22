package com.example.calendar.activity.bean;

public class BeanTest {
    int year;
    int month;
    int day;
    int cumulativeMonth;
    public void setYear(int year){
        this.year=year;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int day){
        this.day=day;
    }

    public int getDay() {
        return day;
    }

    public void setCumulativeMonth(int cumulativeMonth) {
        this.cumulativeMonth = cumulativeMonth;
    }

    public int getCumulativeMonth() {
        return cumulativeMonth;
    }
}
