package com.example.calendar.activity.Bean;

import java.io.Serializable;

/**
 * 当前算余积月对应的Item的Bean
 */
public class CurrentSurplusBean implements Serializable {

    public CurrentSurplusBean() {
    }
    public CurrentSurplusBean(String oneContent, String twoContent, String threeContent) {
        this.oneContent = oneContent;
        this.twoContent = twoContent;
        this.threeContent = threeContent;
    }

    private String oneContent = "";

    private String twoContent = "";

    private String threeContent = "";

    public String getOneContent() {
        return oneContent;
    }

    public void setOneContent(String oneContent) {
        this.oneContent = oneContent;
    }

    public String getTwoContent() {
        return twoContent;
    }

    public void setTwoContent(String twoContent) {
        this.twoContent = twoContent;
    }

    public String getThreeContent() {
        return threeContent;
    }

    public void setThreeContent(String threeContent) {
        this.threeContent = threeContent;
    }
}
