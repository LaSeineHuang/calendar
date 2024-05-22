package com.example.calendar.activity.cumulativeDATA;

/*零数与整数*/
public class IntegerAndZero {
    int integer;//整数
    int zero;//零数

    public void setIntegerAndZero(int integer,int zero){
        this.integer=integer;
        this.zero=zero;
    }

    public void toStringIntegerAndZero(){
        System.out.println("整数："+this.integer+"零数："+this.zero);
    }

    public int getInteger() {
        return integer;
    }

    public int getZero() {
        return zero;
    }

    public IntegerAndZero cumulativeIntegerAndZero(Year year, IntegerAndZero Liyuan){
        IntegerAndZero base= new IntegerAndZero();

        int businessOfzero=(year.cumulativeMonth*1+Liyuan.zero)/126;  //零数商
        int remainderOfzero=(year.cumulativeMonth*1+Liyuan.zero)%126;  //零数余
        //System.out.println("a："+businessOfzero+"b："+remainderOfzero);

        int businessOfinteger=(year.cumulativeMonth*2+Liyuan.integer+businessOfzero)/28;  //整数商
        int remainderOfinteger=(year.cumulativeMonth*2+Liyuan.integer+businessOfzero)%28;  //整数余
        //System.out.println("c："+businessOfinteger+"d："+remainderOfinteger);

        base.setIntegerAndZero(remainderOfinteger,remainderOfzero);
        return base;
    }


}
