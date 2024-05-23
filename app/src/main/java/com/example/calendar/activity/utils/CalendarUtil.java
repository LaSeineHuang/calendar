package com.example.calendar.activity.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class CalendarUtil {
    private static CalendarUtil calendarUtil;

    public static CalendarUtil getInstance() {
        if (calendarUtil == null) {
            synchronized (CalendarUtil.class) {
                if (calendarUtil == null) {
                    calendarUtil = new CalendarUtil();
                }
            }
        }
        return calendarUtil;
    }


    public String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public String getTime2(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public String longToStr(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(time);
        return format.format(date);
    }

    public String getYMDHMS() {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return dateString;
    }

    public String getYMDHM() {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return dateString;
    }

    public String getYMD() {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return dateString;
    }

    public String getMD() {
        SimpleDateFormat dff = new SimpleDateFormat("MM-dd");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return dateString;
    }

    public String getTimeYMDHM(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    public int getS() {
        SimpleDateFormat dff = new SimpleDateFormat("ss");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return Integer.parseInt(dateString);
    }

    public int getY() {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return Integer.parseInt(dateString);
    }

    public String getYStr() {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return dateString;
    }

    public int getDataY() {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy");
        String dateString = dff.format(
                new Date(System.currentTimeMillis()));
        return Integer.parseInt(dateString);
    }

    public int getM() {
        SimpleDateFormat dff = new SimpleDateFormat("mm");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return Integer.parseInt(dateString);
    }

    public int getYue() {
        SimpleDateFormat dff = new SimpleDateFormat("MM");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return Integer.parseInt(dateString);
    }

    public int getDay() {
        SimpleDateFormat dff = new SimpleDateFormat("dd");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return Integer.parseInt(dateString);
    }

    public String getHm() {
        SimpleDateFormat dff = new SimpleDateFormat("HH:mm");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return dateString;
    }

    public String getYMDHM(String addTime) {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());

        try {
            int add = Integer.parseInt(addTime);
            Date date = dff.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE, add);
            Date time = calendar.getTime();
            String format = dff.format(time);
            return format;
        } catch (Exception e) {
            e.printStackTrace();
            return dateString;
        }
    }


    public String getYHD() {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return dateString;
    }


    public String getDHMS() {
        SimpleDateFormat dff = new SimpleDateFormat("dd-HH-mm-ss");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return dateString;
    }


    public String getYMDHMSLine() {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());
        return dateString;
    }

    public String dateFormtHMS(String time) {
        try {
            SimpleDateFormat dff = new SimpleDateFormat("HH:mm:ss");
            return dff.format(time);
        } catch (Exception e) {
            e.fillInStackTrace();
            return time;
        }
    }

    public String dateFormtYMD(String time) {
        try {
            SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
            return dff.format(time);
        } catch (Exception e) {
            e.fillInStackTrace();
            return time;
        }
    }

    public String dateFormtHours(long time) {
        Date date = new Date(time);
        int hours = date.getHours();
        return hours + "";
    }

    public String dateFormtYMD(long time) {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date(time));
        return dateString;
    }

    public String dateFormtH(String time) {
        try {
            SimpleDateFormat dff = new SimpleDateFormat("HH");
            return dff.format(time);
        } catch (Exception e) {
            e.fillInStackTrace();
            return time;
        }
    }

    /**
     * @author stf
     * @time 2019-03-14 15:39
     * @remark 时间点比较
     * 相等 0；
     * date1 在date2 前，-1；
     * date1 在date2 后，1；
     */
    public int timeCompare(Date d1, Date d2) {

        int i = 0;
        if (d1.compareTo(d2) > 0) {
            i = 1;
        } else if (d1.compareTo(d2) < 0) {
            i = -1;
        } else if (d1.compareTo(d2) == 0) {
            i = 0;
        }
        return i;
    }

    /**
     * @author stf
     * @time 2019-03-14 15:45
     * @remark 相等 0；
     * date1 在date2 前，-1；
     * date1 在date2 后，1；
     */
    public static int timeCompare(String date1, String date2) {
        try {
            SimpleDateFormat CurrentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date beginTime = CurrentTime.parse(date1);// 它在后面的时候，使用第一个token
            Date endTime = CurrentTime.parse(date2); // 它在后面的时候，使用第二个token
            int i = 0;
            if (beginTime.compareTo(endTime) > 0) {
                i = 1;
            } else if (beginTime.compareTo(endTime) < 0) {
                i = -1;
            } else if (beginTime.compareTo(endTime) == 0) {
                i = 0;
            }
            return i;
        } catch (Exception e) {
            e.fillInStackTrace();
            return -1;
        }
    }

    public int timeCompareYMDHM(String date1, String date2) {
        try {
            SimpleDateFormat CurrentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date beginTime = CurrentTime.parse(date1);// 它在后面的时候，使用第一个token
            Date endTime = CurrentTime.parse(date2); // 它在后面的时候，使用第二个token
            int i = 0;
            if (beginTime.compareTo(endTime) > 0) {
                i = 1;
            } else if (beginTime.compareTo(endTime) < 0) {
                i = -1;
            } else if (beginTime.compareTo(endTime) == 0) {
                i = 0;
            }
            return i;
        } catch (Exception e) {
            e.fillInStackTrace();
            return -1;
        }
    }

    public int timeCompareYMD(String date1, String date2) {
        try {
            SimpleDateFormat CurrentTime = new SimpleDateFormat("yyyy-MM-dd");
            Date beginTime = CurrentTime.parse(date1);// 它在后面的时候，使用第一个token
            Date endTime = CurrentTime.parse(date2); // 它在后面的时候，使用第二个token
            int i = 0;
            if (beginTime.compareTo(endTime) > 0) {
                i = 1;
            } else if (beginTime.compareTo(endTime) < 0) {
                i = -1;
            } else if (beginTime.compareTo(endTime) == 0) {
                i = 0;
            }
            return i;
        } catch (Exception e) {
            e.fillInStackTrace();
            return -1;
        }
    }

    public int timeCompares(String date1, String date2) {
        try {
            SimpleDateFormat CurrentTime = new SimpleDateFormat("yyyy-MM-dd");
            Date beginTime = CurrentTime.parse(date1);// 它在后面的时候，使用第一个token
            Date endTime = CurrentTime.parse(date2); // 它在后面的时候，使用第二个token
            int i = 0;
            if (beginTime.compareTo(endTime) > 0) {
                i = 1;
            } else if (beginTime.compareTo(endTime) < 0) {
                i = -1;
            } else if (beginTime.compareTo(endTime) == 0) {
                i = 0;
            }
            return i;
        } catch (Exception e) {
            e.fillInStackTrace();
            return -1;
        }
    }

    /**
     * @author stf
     * @time 2019-03-27 22:46
     * @remark 和现在的时间相比较
     */
    public Boolean isIntime(String time) {
        // 两个时间做对比
        String ymdhms = CalendarUtil.getInstance().getYMDHMS();
        return (CalendarUtil.getInstance().timeCompare(time, ymdhms) == 1);
    }

    /**
     * @author stf
     * @time 2019-04-05 00:14
     * @remark 字符串转 date
     */

    public Date strToDate(String time) {
        SimpleDateFormat CurrentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date beginTime = CurrentTime.parse(time);
            return beginTime;
        } catch (ParseException e) {
            e.printStackTrace();
            return strToDate(getYMDHMS());
        }
    }


    public Date strToDateYMD(String time2) {
        SimpleDateFormat CurrentTime = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date beginTime = CurrentTime.parse(time2);
            return beginTime;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Date strToDate3(String time) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Date strToDateYMDHM(String time) {
        SimpleDateFormat CurrentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date beginTime = CurrentTime.parse(time);
            return beginTime;
        } catch (ParseException e) {
            e.printStackTrace();
            return strToDate(getYMDHM());
        }
    }

    /**
     * @author stf
     * @time 2019-04-05 00:11
     * @remark 获取当前时间的前多少天时间
     */
    public String getBeforeDay(Date date, int day) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (day == 99) {
            calendar.add(Calendar.MONTH, -1);
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, day);
        }
        Date time = calendar.getTime();
        String format = formatter.format(time);
        return format;
    }


    /**
     * @author stf
     * @time 2019-04-05 00:11
     * @remark 获取当前时间的前多少天时间
     */
    public Date getBeforeDayTime(Date date, int day) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (day == 99) {
            calendar.add(Calendar.MONTH, -1);
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, day);
        }
        Date time = calendar.getTime();

        return time;
    }

    public String setAddYear(Date date, int year) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date time = calendar.getTime();
        String format = formatter.format(time);
        return format;
    }

    public String setAddYear(String nowTime, int year) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try {
            date = formatter.parse(nowTime);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.YEAR, year);
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            Date time = calendar.getTime();
            String format = formatter.format(time);
            return format;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String setJianYear(Date date, int year) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -year);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date time = calendar.getTime();
        String format = formatter.format(time);
        return format;
    }

    public Date setJianYear(int year) {
        Date date = Calendar.getInstance().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -year);
        Date time = calendar.getTime();
        return time;
    }

    public String setJianYearStr(int year) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = Calendar.getInstance().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -year);
        Date time = calendar.getTime();
        String format = formatter.format(time);
        return format;
    }

    public String setAddDay(Date date, int day) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        Date time = calendar.getTime();
        String format = formatter.format(time);
        return format;
    }

    public String setJianDay(Date date, int day) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, -day);
        Date time = calendar.getTime();
        String format = formatter.format(time);
        return format;
    }


    public String getBeforeDay(String date1, int day) {
        Date date = strToDate(date1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (day == 99) {
            calendar.add(Calendar.MONTH, -1);
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, day);
        }
        Date time = calendar.getTime();
        String format = formatter.format(time);
        return format;
    }

    public String getBeforeMonthString(int month) {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -month);
        Date time = calendar.getTime();
        String format = formatter.format(time);
        return format;
    }

    //返回此时此刻的 前几个月的时间
    public Long getBeforeMonthLong(int month) {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -month);
        Date time = calendar.getTime();
        String format = formatter.format(time);
        return time.getTime();
    }


    /**
     * @author stf
     * @time 2019-04-05 00:22
     * @remark 获取本周 ，周一当作第一天
     */
    public long getTimeOfWeekStartLong() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.clear(Calendar.MINUTE);
        ca.clear(Calendar.SECOND);
        ca.clear(Calendar.MILLISECOND);
        ca.set(Calendar.DAY_OF_WEEK, (ca.getFirstDayOfWeek() + Calendar.SUNDAY));
        return ca.getTimeInMillis();
    }

    public String getTimeOfWeekStartStr() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.clear(Calendar.MINUTE);
        ca.clear(Calendar.SECOND);
        ca.clear(Calendar.MILLISECOND);
        ca.set(Calendar.DAY_OF_WEEK, (ca.getFirstDayOfWeek() + Calendar.MONDAY));
        Date time = ca.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(time);
        return format;
    }

    /**
     * @author stf
     * @time 2019-04-05 00:22
     * @remark 获取本月
     */
    public long getTimeOfMonthStart() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.clear(Calendar.MINUTE);
        ca.clear(Calendar.SECOND);
        ca.clear(Calendar.MILLISECOND);
        ca.set(Calendar.DAY_OF_MONTH, 1);
        return ca.getTimeInMillis();
    }

    /**
     * @author stf
     * @time 2019-04-05 00:22
     * @remark 获取本年
     */
    public long getTimeOfYearStart() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.clear(Calendar.MINUTE);
        ca.clear(Calendar.SECOND);
        ca.clear(Calendar.MILLISECOND);
        ca.set(Calendar.DAY_OF_YEAR, 1);
        return ca.getTimeInMillis();
    }

    //获得本周一0点时间
    @SuppressLint("WrongConstant")
    public int getTimesWeekmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    //获得本周日24点时间
    @SuppressLint("WrongConstant")
    public int getTimesWeeknight() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return (int) ((cal.getTime().getTime() + (7 * 24 * 60 * 60 * 1000)) / 1000);
    }

    //获得本月第一天0点时间
    @SuppressLint("WrongConstant")
    public int getTimesMonthmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return (int) (cal.getTimeInMillis() / 1000);
    }

    //获得本月最后一天24点时间
    @SuppressLint("WrongConstant")
    public int getTimesMonthnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    //获得当天0点时间
    public int getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    //获得当天24点时间
    public long getTimesnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 根据身份证的号码算出当前身份证持有者的性别和年龄 18位身份证
     *
     * @return
     * @throws Exception
     */
    public static Map<String, String> getCarInfo(String CardCode)
            throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        if (TextUtils.isEmpty(CardCode)) return map;
        String year = CardCode.substring(6).substring(0, 4);// 得到年份
        String yue = CardCode.substring(10).substring(0, 2);// 得到月份
        String day = CardCode.substring(12).substring(0, 2);//得到日
        String sex;
        if (Integer.parseInt(CardCode.substring(16).substring(0, 1)) % 2 == 0) {// 判断性别
            sex = "女";
        } else {
            sex = "男";
        }

        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());

//        Date date = new Date();// 得到当前的系统时间
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String fyear = dateString.substring(0, 4);// 当前年份
        String fyue = dateString.substring(5, 7);// 月份
        // String fday=format.format(date).substring(8,10);
        int age = 0;

        if (Integer.parseInt(fyue) <= Integer.parseInt(yue)) { // 当前月份大于用户出身的月份表示已过生
            age = Integer.parseInt(fyear) - Integer.parseInt(year) - 1;
        } else {// 当前用户还没过生
            age = Integer.parseInt(fyear) - Integer.parseInt(year);
        }
        map.put("sex", sex);
        if (sex.equals("男")) {
            map.put("sexType", "1");
        } else {
            map.put("sexType", "2");
        }
        map.put("age", age + "");
        map.put("year", year + "-" + yue + "-" + day);
        return map;
    }

    /**
     * 15位身份证的验证
     *
     * @param
     * @throws Exception
     */
    public static Map<String, String> getCarInfo15W(String card)
            throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        String uyear = "19" + card.substring(6, 8);// 年份
        String uyue = card.substring(8, 10);// 月份
        // String uday=card.substring(10, 12);//日
        String usex = card.substring(14, 15);// 用户的性别
        String sex;
        if (Integer.parseInt(usex) % 2 == 0) {
            sex = "女";
        } else {
            sex = "男";
        }

        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
        //        dff.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = dff.format(new Date());

//        Date date = new Date();// 得到当前的系统时间
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fyear = dateString.substring(0, 4);// 当前年份
        String fyue = dateString.substring(5, 7);// 月份
        // String fday=format.format(date).substring(8,10);
        int age = 0;
        if (Integer.parseInt(uyue) <= Integer.parseInt(fyue)) { // 当前月份大于用户出身的月份表示已过生
//            age = Integer.parseInt(fyear) - Integer.parseInt(uyear);
            age = Integer.parseInt(fyear) - Integer.parseInt(uyear) + 1;
        } else {// 当前用户还没过生
            age = Integer.parseInt(fyear) - Integer.parseInt(uyear);
        }
        map.put("sex", sex);
        map.put("age", age + "");
        return map;
    }

    public static int getAge(String idNo) {
        int age = 0;
        try {
            Map<String, String> carInfo = getCarInfo(idNo);
            age = Integer.parseInt(carInfo.get("age"));

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

        return age;
    }


    //获取最近一年的时间 ，按照周统计，周一到周日
    public ArrayList<String> getWeekList() {
        ArrayList<String> weeksList = getLastYearWeeks();
        Collections.reverse(weeksList);
        return weeksList;
    }

    public ArrayList<String> getLastYearWeeks() {
        ArrayList<String> weeks = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar today = Calendar.getInstance();
        Calendar oneYearAgo = (Calendar) today.clone();
        oneYearAgo.add(Calendar.YEAR, -1);

        // Set start date to one year ago
        Calendar start = (Calendar) oneYearAgo.clone();
        start.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        // Move start date to the previous Monday if it's not Monday
        if (start.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            start.add(Calendar.WEEK_OF_YEAR, -1);
            start.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        }

        // Iterate through each week
        while (start.before(today) || isSameDay(start, today)) {
            Calendar end = (Calendar) start.clone();
            end.add(Calendar.DAY_OF_WEEK, 6); // Move to Sunday

            // Adjust end date to today if it surpasses today
            if (end.after(today)) {
                end = (Calendar) today.clone(); // Do not go past today
            }

            String week = sdf.format(start.getTime()) + " ~ " + sdf.format(end.getTime());
            weeks.add(week);

            // Move to next week
            start.add(Calendar.WEEK_OF_YEAR, 1);
        }

        return weeks;
    }

    private boolean isSameDay(Calendar cal1, Calendar cal2) {
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }
}