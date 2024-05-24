package com.example.calendar.activity.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 日程查询结果对应的Bean
 */

@Entity
public class ScheduleQueryBean  {
    public ScheduleQueryBean(){

    }
    public ScheduleQueryBean(String title, String location, String startTime, String endTime,String remark) {
        this.title = title;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.remark=remark;
    }
    @Generated(hash = 807576578)
    public ScheduleQueryBean(Long id, String title, String location, String startTime, String endTime, String remark) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.remark = remark;
    }

    @Id(autoincrement = true)//自增ID
    private Long id;

    private String title = "";//标题

    private String location="";//地点

    private String startTime="";//开始时间

    private String endTime="";//结束时间

    private String remark="";//备注

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
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}