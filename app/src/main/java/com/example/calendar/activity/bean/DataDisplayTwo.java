package com.example.calendar.activity.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class DataDisplayTwo implements MultiItemEntity {
    public int y;
    public int m;
    public int d;

    public int certainCelestial1;
    public int certainCelestial2;
    public int certainCelestial3;
    public int certainCelestial4;
    public int certainCelestial5;
    public int certainCelestial6;

    public int cOfNetAndSun1;
    public int cOfNetAndSun2;
    public int cOfNetAndSun3;
    public int cOfNetAndSun4;
    public int cOfNetAndSun5;
    public int cOfNetAndSun6;

    public int certainSun1;
    public int certainSun2;
    public int certainSun3;
    public int certainSun4;
    public int certainSun5;

    public int meet1;
    public int meet2;
    public int meet3;
    public int meet4;
    public int meet5;
    public String name;
    public String Fname;
    public String Lname;
    public int surplusDay;
    public int median;
    public int inferior;
    public int mars;
    public int jupiter;
    public int saturn;
    public int mercury;
    public int venus;

    public int mars1;
    public int mars2;
    public int mars3;
    public int mars4;
    public int mars5;

    public int jupiter1;
    public int jupiter2;
    public int jupiter3;
    public int jupiter4;
    public int jupiter5;

    public int saturn1;
    public int saturn2;
    public int saturn3;
    public int saturn4;
    public int saturn5;

    public int mercury1;
    public int mercury2;
    public int mercury3;
    public int mercury4;
    public int mercury5;

    public int venus1;
    public int venus2;
    public int venus3;
    public int venus4;
    public int venus5;
    public DataDisplayTwo() {
    }


    @Override
    public int getItemType() {
        return 2;
    }

    public void setDate(int y,int m,int d) {
        this.y=y;
        this.m=m;
        this.d=d;

    }
    public String getDate() {
        return y+"年"+ m+"月"+ d+"日五要素";
    }
    public void setCertainCelestial(int certainCelestial1,int certainCelestial2,int certainCelestial3,int certainCelestial4,int certainCelestial5,int certainCelestial6) {
        this.certainCelestial1=certainCelestial1;
        this.certainCelestial2=certainCelestial2;
        this.certainCelestial3=certainCelestial3;
        this.certainCelestial4=certainCelestial4;
        this.certainCelestial5=certainCelestial5;
        this.certainCelestial6=certainCelestial6;
    }

    public String getcertainCelestial1(){
        return String.valueOf(certainCelestial1);
    }
    public String getcertainCelestial2(){
        return String.valueOf(certainCelestial2);
    }
    public String getcertainCelestial3(){
        return String.valueOf(certainCelestial3);
    }
    public String getcertainCelestial4(){
        return String.valueOf(certainCelestial4);
    }
    public String getcertainCelestial5(){
        return String.valueOf(certainCelestial5);
    }
    public String getcertainCelestial6(){
        return String.valueOf(certainCelestial6);
    }
    public void setCOfNetAndSun(int cOfNetAndSun1,int cOfNetAndSun2,int cOfNetAndSun3,int cOfNetAndSun4,int cOfNetAndSun5,int cOfNetAndSun6) {
        this.cOfNetAndSun1=cOfNetAndSun1;
        this.cOfNetAndSun2=cOfNetAndSun2;
        this.cOfNetAndSun3=cOfNetAndSun3;
        this.cOfNetAndSun4=cOfNetAndSun4;
        this.cOfNetAndSun5=cOfNetAndSun5;
        this.cOfNetAndSun6=cOfNetAndSun6;
    }
    public String getCOfNetAndSun1(){
        return String.valueOf(cOfNetAndSun1);
    }
    public String getCOfNetAndSun2(){
        return String.valueOf(cOfNetAndSun2);
    }
    public String getCOfNetAndSun3(){
        return String.valueOf(cOfNetAndSun3);
    }
    public String getCOfNetAndSun4(){
        return String.valueOf(cOfNetAndSun4);
    }
    public String getCOfNetAndSun5(){
        return String.valueOf(cOfNetAndSun5);
    }
    public String getCOfNetAndSun6(){
        return String.valueOf(cOfNetAndSun6);
    }

    public void setCertainSun(int certainSun1,int certainSun2,int certainSun3,int certainSun4,int certainSun5){
        this.certainSun1=certainSun1;
        this.certainSun2=certainSun2;
        this.certainSun3=certainSun3;
        this.certainSun4=certainSun4;
        this.certainSun5=certainSun5;
    }

    public String getCertainSun1(){
        return String.valueOf(certainSun1);
    }
    public String getCertainSun2(){
        return String.valueOf(certainSun2);
    }
    public String getCertainSun3(){
        return String.valueOf(certainSun3);
    }
    public String getCertainSun4(){
        return String.valueOf(certainSun4);
    }
    public String getCertainSun5(){
        return String.valueOf(certainSun5);
    }
    public void setMeet(int meet1,int meet2,int meet3,int meet4,int meet5){
        this.meet1=meet1;
        this.meet2=meet2;
        this.meet3=meet3;
        this.meet4=meet4;
        this.meet5=meet5;

    }
    public String getMeet1(){
        return String.valueOf(meet1);
    }
    public String getMeet2(){
        return String.valueOf(meet2);
    }
    public String getMeet3(){
        return String.valueOf(meet3);
    }

    public String getMeet4(){
        return String.valueOf(meet4);
    }
    public String getMeet5(){
        return String.valueOf(meet5);
    }
    public void setName(String name,String Fname,String Lname){
        this.name =name ;
        this.Fname =Fname;
        this.Lname=Lname;
    }
    public String getName(){
        return name;
    }
    public String getFname(){
        return Fname;
    }
    public String getLname(){
        return Lname;
    }
    public void setSurplusDay(int surplusDay,int median,int inferior){
        this.surplusDay=surplusDay;
        this.median=median;
        this.inferior=inferior;
    }
    public String getSurplusDay(){
        return String.valueOf(surplusDay);
    }
    public String getMedian(){
        return String.valueOf(median);
    }
    public String getInferior(){
        return String.valueOf(inferior);
    }
    public void setSpecialDay(int mars,int jupiter,int saturn,int mercury,int venus){
        this.mars=mars;
        this.jupiter=jupiter;
        this.saturn=saturn;
        this.mercury=mercury;
        this.venus=venus;
    }

    public String getSDofMars(){
        return String.valueOf(mars);
    }
    public String getSDofjupiter(){
        return String.valueOf(jupiter);
    }
    public String getSDofsaturn(){
        return String.valueOf(saturn);
    }
    public String getSDofmercury(){
        return String.valueOf(mercury);
    }
    public String getSDofvenus(){
        return String.valueOf(venus);
    }

    public void setMars(int mars1,int mars2,int mars3,int mars4,int mars5){
        this.mars1=mars1;
        this.mars2=mars2;
        this.mars3=mars3;
        this.mars4=mars4;
        this.mars5=mars5;
    }
    public void setJupiter(int jupiter1,int jupiter2,int jupiter3,int jupiter4,int jupiter5){
        this.jupiter1=jupiter1;
        this.jupiter2=jupiter2;
        this.jupiter3=jupiter3;
        this.jupiter4=jupiter4;
        this.jupiter5=jupiter5;
    }
    public void setSaturn(int saturn1,int saturn2,int saturn3,int saturn4,int saturn5){
        this.saturn1=saturn1;
        this.saturn2=saturn2;
        this.saturn3=saturn3;
        this.saturn4=saturn4;
        this.saturn5=saturn5;
    }
    public void setMercury(int mercury1,int mercury2,int mercury3,int mercury4,int mercury5){
        this.mercury1=mercury1;
        this.mercury2=mercury2;
        this.mercury3=mercury3;
        this.mercury4=mercury4;
        this.mercury5=mercury5;
    }
    public void setVenus(int venus1,int venus2,int venus3,int venus4,int venus5){
        this.venus1=venus1;
        this.venus2=venus2;
        this.venus3=venus3;
        this.venus4=venus4;
        this.venus5=venus5;
    }
    public String getMars1(){
        return String.valueOf(mars1);
    }
    public String getMars2(){
        return String.valueOf(mars2);
    }

    public String getMars3(){
        return String.valueOf(mars3);
    }
    public String getMars4(){
        return String.valueOf(mars4);
    }
    public String getMars5(){
        return String.valueOf(mars5);
    }
    public String getJupiter1(){
        return String.valueOf(jupiter1);
    }
    public String getJupiter2(){
        return String.valueOf(jupiter2);
    }

    public String getJupiter3(){
        return String.valueOf(jupiter3);
    }
    public String getJupiter4(){
        return String.valueOf(jupiter4);
    }
    public String getJupiter5(){
        return String.valueOf(jupiter5);
    }
    public String getSaturn1(){
        return String.valueOf(saturn1);
    }
    public String getSaturn2(){
        return String.valueOf(saturn2);
    }

    public String getSaturn3(){
        return String.valueOf(saturn3);
    }
    public String getSaturn4(){
        return String.valueOf(saturn4);
    }
    public String getSaturn5(){
        return String.valueOf(saturn5);
    }
    public String getMercury1(){
        return String.valueOf(mercury1);
    }
    public String getMercury2(){
        return String.valueOf(mercury2);
    }

    public String getMercury3(){
        return String.valueOf(mercury3);
    }
    public String getMercury4(){
        return String.valueOf(mercury4);
    }
    public String getMercury5(){
        return String.valueOf(mercury5);
    }
    public String getVenus1(){
        return String.valueOf(venus1);
    }
    public String getVenus2(){
        return String.valueOf(venus2);
    }

    public String getVenus3(){
        return String.valueOf(venus3);
    }
    public String getVenus4(){
        return String.valueOf(venus4);
    }
    public String getVenus5(){
        return String.valueOf(venus5);
    }

}
