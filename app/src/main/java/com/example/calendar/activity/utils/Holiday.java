package com.example.calendar.activity.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import android.icu.util.ChineseCalendar;
import android.text.TextUtils;
import android.util.Log;

import com.necer.entity.Lunar;

//节假日的判断
public class Holiday {

    //计算两个节日之间的天数 方法1\
    //入参 农历
    public static HashMap<String, String> getLunarPassDayOfMonth(int lunarYears, int lunarMonth, int lunarDay) {
        LinkedHashMap<String, Object> hashMap = new LinkedHashMap<>();
        hashMap.put("day", 0);
        hashMap.put("holiday", "null");
        if (lunarMonth == 1) {
            if (lunarDay > 1 && lunarDay <= 15) {
                hashMap.put("day", 15 - lunarDay);
                hashMap.put("holiday", "元宵节");
            } else if (lunarDay == 1) {
                hashMap.put("day", 0);
                hashMap.put("holiday", "春节");
            } else if (lunarDay > 15) {
                hashMap.put("day", getMaxDayOfMonth(lunarYears, lunarMonth) - lunarDay + 2);
                hashMap.put("holiday", "龙抬头");
            }
        } else if (lunarMonth == 2) {
            if (lunarDay <= 2) {
                hashMap.put("day", 2 - lunarDay);
                hashMap.put("holiday", "龙抬头");
            }

            if (lunarDay > 2) {
                hashMap.put("day", getMaxDayOfMonth(lunarYears, lunarMonth) - lunarDay + 5 + getMaxDayOfMonth(lunarYears, lunarMonth + 1) + getMaxDayOfMonth(lunarYears, lunarMonth + 2));
                hashMap.put("holiday", "端午节");
            }
        } else if (lunarMonth == 3) {
            hashMap.put("day", getMaxDayOfMonth(lunarYears, lunarMonth) - lunarDay + 5 + getMaxDayOfMonth(lunarYears, lunarMonth + 1));
            hashMap.put("holiday", "端午节");
        } else if (lunarMonth == 4) {
            hashMap.put("day", getMaxDayOfMonth(lunarYears, lunarMonth) - lunarDay + 5);
            hashMap.put("holiday", "端午节");
        } else if (lunarMonth == 5) {
            if (lunarDay <= 5) {
                hashMap.put("day", 5 - lunarDay);
                hashMap.put("holiday", "端午节");
            }

            if (lunarDay > 5) {
                hashMap.put("day", getMaxDayOfMonth(lunarYears, lunarMonth) - lunarDay + getMaxDayOfMonth(lunarYears, lunarMonth + 1) + 7);
                hashMap.put("holiday", "七夕");
            }
        } else if (lunarMonth == 6) {
            hashMap.put("day", getMaxDayOfMonth(lunarYears, lunarMonth) - lunarDay + 7);
            hashMap.put("holiday", "七夕");
        } else if (lunarMonth == 7) {

            if (lunarDay <= 7) {
                hashMap.put("day", 7 - lunarDay);
                hashMap.put("holiday", "七夕");
            }

            if (lunarDay > 7 && lunarDay <= 15) {
                hashMap.put("day", 15 - lunarDay);
                hashMap.put("holiday", "中元节");
            }

            if (lunarDay > 15) {
                hashMap.put("day", getMaxDayOfMonth(lunarYears, lunarMonth) - lunarDay + 15);
                hashMap.put("holiday", "中秋节");
            }
        } else if (lunarMonth == 8) {
            if (lunarDay <= 15) {
                hashMap.put("day", 15 - lunarDay);
                hashMap.put("holiday", "中秋节");
            }

            if (lunarDay > 15) {
                hashMap.put("day", getMaxDayOfMonth(lunarYears, lunarMonth) - lunarDay + 9);
                hashMap.put("holiday", "重阳节");
            }
        } else if (lunarMonth == 9) {
            if (lunarDay <= 9) {
                hashMap.put("day", 9 - lunarDay);
                hashMap.put("holiday", "重阳节");
            }

            if (lunarDay > 15) {
                hashMap.put("day", getMaxDayOfMonth(lunarYears, lunarMonth) - lunarDay + 8 + getMaxDayOfMonth(lunarYears, lunarMonth + 1) + getMaxDayOfMonth(lunarYears, lunarMonth + 2));
                hashMap.put("holiday", "腊八节");
            }
        } else if (lunarMonth == 10) {
            hashMap.put("day", getMaxDayOfMonth(lunarYears, lunarMonth) - lunarDay + getMaxDayOfMonth(lunarYears, lunarMonth + 1) + 8);
            hashMap.put("holiday", "腊八节");
        } else if (lunarMonth == 11) {
            hashMap.put("day", getMaxDayOfMonth(lunarYears, lunarMonth) - lunarDay + 8);
            hashMap.put("holiday", "腊八节");
        } else if (lunarMonth == 12) {
            if (lunarDay <= 12) {
                hashMap.put("day", 12 - lunarDay);
                hashMap.put("holiday", "腊八节");
            }

            if (lunarDay > 12 && lunarDay <= 23) {
                hashMap.put("day", 23 - lunarDay);
                hashMap.put("holiday", "小年");
            }

            if (lunarDay > 23) {
                if (isChuxi(lunarYears, 12, 29)) {
                    hashMap.put("day", 29 - lunarDay);
                }

                if (isChuxi(lunarYears, 12, 30)) {
                    hashMap.put("day", 30 - lunarDay);
                }
                hashMap.put("holiday", "除夕");
            }
        }

        LinkedHashMap<String, String> resMap = new LinkedHashMap<>();
        resMap.put("day", hashMap.get("day") + "");
        resMap.put("holiday", hashMap.get("holiday") + "");
        return resMap;
    }

    //计算两个节日之间的天数 方法2
    public static HashMap<String, String> getLunarHoliday(int nyear, int year, int month, int day) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.putAll(cha(nyear, 1, 1, "春节",year,month,day));
        map.putAll(cha(nyear, 1, 15, "元宵节",year,month,day));
        map.putAll(cha(nyear, 2, 2, "龙抬头",year,month,day));
        map.putAll(cha(nyear, 3, 15, "开耕节",year,month,day));
        map.putAll(cha(nyear, 5, 5, "端午节",year,month,day));
        map.putAll(cha(nyear, 6, 30, "雪顿节",year,month,day));
        map.putAll(cha(nyear, 7, 7, "七夕节",year,month,day));
        map.putAll(cha(nyear, 7, 15, "中元",year,month,day));
        map.putAll(cha(nyear, 8, 15, "中秋节",year,month,day));
        map.putAll(cha(nyear, 9, 9, "重阳节",year,month,day));
        map.putAll(cha(nyear, 10, 15, "仙女节",year,month,day));
        map.putAll(cha(nyear, 12, 8, "腊八节",year,month,day));
        map.putAll(cha(nyear, 12, 23, "小年",year,month,day));
        map.putAll(cha(nyear, 12, 25, "燃灯节",year,month,day));
        if (isChuxi(year, 12, 29)) {
            map.putAll(cha(nyear, 12, 29, "除夕",year,month,day));
        }

        if (isChuxi(year, 12, 30)) {
            map.putAll(cha(nyear, 12, 30, "除夕",year,month,day));
        }

        long time = strToDate(year + "-" + month + "-" + day).getTime();

        LinkedHashMap<String, String> resMap = new LinkedHashMap<>();
        resMap.put("day", "0");
        resMap.put("holiday", "null");
        for (String key : map.keySet()) {
            long l = Long.parseLong(key);
            if (time <= l) {
                String msg = map.get(key);
                String[] split = msg.split("-");
                for (int i = 0; i < split.length; i++) {
                    if(i != 0 && !TextUtils.isEmpty(split[i])){
                        resMap.put("day", split[i]);
                        break;
                    }
                }
                resMap.put("holiday", split[0]);
                return resMap;
            }
        }

        return resMap;
    }


    //当月天数
    private static Integer getMaxDayOfMonth(int lunarYears, int lunarMonth) {
        return monthDays(lunarYears, lunarMonth) + getNextMonthRun(lunarYears, lunarMonth);
    }

    //下个是否闰月
    private static Integer getNextMonthRun(int lunarYears, int lunarMonth) {
        int i = leapMonth(lunarYears);
        if (i == lunarMonth + 1) {
            return monthDays(lunarYears, lunarMonth);
        }
        return 0;
    }

    // ====== 传回农历 y年的总天数 1900--2100
    public static int yearDays(int y) {
        int i, sum = 348;
        for (i = 0x8000; i > 0x8; i >>= 1) {
            if ((LUNAR_INFO[y - 1900] & i) != 0)
                sum += 1;
        }
        return (sum + leapDays(y));
    }

    // ====== 传回农历 y年闰月的天数
    public static int leapDays(int y) {
        if (leapMonth(y) != 0) {
            if ((LUNAR_INFO[y - 1899] & 0xf) != 0)
                return 30;
            else
                return 29;
        } else
            return 0;
    }

    // ====== 传回农历 y年闰哪个月 1-12 , 没闰传回 0
    public static int leapMonth(int y) {
        long var = LUNAR_INFO[y - 1900] & 0xf;
        return (int) (var == 0xf ? 0 : var);
    }

    // ====== 传回农历 y年m月的总天数
    public static int monthDays(int y, int m) {
        if ((LUNAR_INFO[y - 1900] & (0x10000 >> m)) == 0)
            return 29;
        else
            return 30;
    }


    /*
     * 计算公历nY年nM月nD日和bY年bM月bD日渐相差多少天
     * */
    public static int getDaysOfTwoDate(int bY, int bM, int bD, int nY, int nM, int nD) {
        Date baseDate = null;
        Date nowaday = null;
        try {
            baseDate = chineseDateFormat.parse(bY + "年" + bM + "月" + bD + "日");
            nowaday = chineseDateFormat.parse(nY + "年" + nM + "月" + nD + "日");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 求出相差的天数
        int offset = (int) ((nowaday.getTime() - baseDate.getTime()) / 86400000L);
        return offset;
    }

    static SimpleDateFormat chineseDateFormat = new SimpleDateFormat(
            "yyyy年MM月dd日");


    /*农历lunYear年lunMonth月lunDay日
     * isLeap 当前年月是否是闰月
     * 从农历日期转换成公历日期
     * */
    private static int year, month, day;

    public static ArrayList<Integer> getSunDate(int lunYear, int lunMonth, int lunDay, boolean isLeap) {
        Calendar calendar = LunarCalender.lunarToSolar(lunYear, lunMonth, lunDay, isLeap);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH)-1;
        Log.i("stf", "---getSunDate-农历->" + lunYear + "-" + lunMonth + "-" + lunDay+"--阳历-->"+ year + "-" + month + "-" + day);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(year);
        list.add(month);
        list.add(day);
        return list;
    }


    public static LinkedHashMap<String, String> cha(int nyear, int nmonth, int nday,String name,int year,int month,int day){
        ArrayList<Integer> sunDateChunJie = getSunDate(nyear, nmonth, nday, leapMonth(nyear) == nmonth);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        Date baseDate = null;
        Date nowaday = null;
        try {
            baseDate = chineseDateFormat.parse(sunDateChunJie.get(0) + "年" + sunDateChunJie.get(1) + "月" + sunDateChunJie.get(2) + "日");
            nowaday = chineseDateFormat.parse(year + "年" + month + "月" + day + "日");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 求出相差的天数
        int offset = (int) ((nowaday.getTime() - baseDate.getTime()) / 86400000L);

        map.put(baseDate.getTime() + "", name+"-" + offset);
        return map;
    }

    public static HashMap<String, String> getMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("01-01", "春节");
        map.put("01-15", "元宵节");
        map.put("02-02", "龙抬头");
        map.put("05-05", "端午节");
        map.put("07-07", "七夕");
        map.put("07-15", "中元节");
        map.put("08-15", "中秋节");
        map.put("09-09", "重阳节");
        map.put("12-08", "腊八节");
        map.put("12-23", "小年");
        map.put("12-29", "除夕");
        map.put("12-30", "除夕");
        return map;
    }

    //查找key在第几个
    public static Integer getIndex(int year, int month, int day) {
        HashMap<String, String> map = getMap();
        ArrayList<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(key);
        }
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            String msg = list.get(i);
            if (msg.equals(month + "-" + day)) {
                index = i;
                break;
            }
        }
        return index;
    }


    public static Date strToDate(String time) {
        SimpleDateFormat CurrentTime = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date beginTime = CurrentTime.parse(time);
            return beginTime;
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    //判断是不是除夕
    public static boolean isChuxi(int year, int month, int day) {
        if (month == 12) {
            if ((((monthDays(year, month) == 29) && day == 29))
                    || ((((monthDays(year, month) == 30) && day == 30)))) {
                return true;
            }
        }
        return false;
    }


    public final static long[] LUNAR_INFO = new long[]{0x04bd8, 0x04ae0,
            0x0a570, 0x054d5, 0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0,
            0x055d2, 0x04ae0, 0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540,
            0x0d6a0, 0x0ada2, 0x095b0, 0x14977, 0x04970, 0x0a4b0, 0x0b4b5,
            0x06a50, 0x06d40, 0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970,
            0x06566, 0x0d4a0, 0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3,
            0x092e0, 0x1c8d7, 0x0c950, 0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0,
            0x1a5b4, 0x025d0, 0x092d0, 0x0d2b2, 0x0a950, 0x0b557, 0x06ca0,
            0x0b550, 0x15355, 0x04da0, 0x0a5d0, 0x14573, 0x052d0, 0x0a9a8,
            0x0e950, 0x06aa0, 0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570,
            0x05260, 0x0f263, 0x0d950, 0x05b57, 0x056a0, 0x096d0, 0x04dd5,
            0x04ad0, 0x0a4d0, 0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0,
            0x195a6, 0x095b0, 0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50,
            0x06d40, 0x0af46, 0x0ab60, 0x09570, 0x04af5, 0x04970, 0x064b0,
            0x074a3, 0x0ea50, 0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0,
            0x0c960, 0x0d954, 0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7,
            0x025d0, 0x092d0, 0x0cab5, 0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50,
            0x055d9, 0x04ba0, 0x0a5b0, 0x15176, 0x052b0, 0x0a930, 0x07954,
            0x06aa0, 0x0ad50, 0x05b52, 0x04b60, 0x0a6e6, 0x0a4e0, 0x0d260,
            0x0ea65, 0x0d530, 0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0,
            0x0a4d0, 0x1d0b6, 0x0d250, 0x0d520, 0x0dd45, 0x0b5a0, 0x056d0,
            0x055b2, 0x049b0, 0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20,
            0x0ada0};

}


