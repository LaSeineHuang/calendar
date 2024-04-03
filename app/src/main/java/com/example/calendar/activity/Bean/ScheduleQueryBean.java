package com.example.calendar.activity.Bean;

import java.io.Serializable;

/**
 * 日程查询结果对应的Bean
 */
public class ScheduleQueryBean implements Serializable {
    private String content = "";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
