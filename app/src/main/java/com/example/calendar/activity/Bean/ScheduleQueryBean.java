package com.example.calendar.activity.Bean;

import java.io.Serializable;

/**
 * 日程查询结果对应的Bean
 */
public class ScheduleQueryBean implements Serializable {
    public ScheduleQueryBean(){

    }
    public ScheduleQueryBean(String title, String location, String startTime, String endTime) {
        this.title = title;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private String title = "";//标题

    private String location="";//地点

    private String startTime="";//开始时间

    private String endTime="";//结束时间

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
