package Main;

import Main.cumulativeDATA.cumulative;
import Main.cumulativeDATA.ditui;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        for(int i=1988;i<2100;i++){
            for(int j=1;j<13;j++){
                new cumulative().mainCumulative(i,j);

            }
        }
       // new ditui().mainCumulative();
    }
}