package com.cvnchina.xingwanban.utils;

/**
 * Created by hecuncun on 2020-5-28
 */
public class TimeUtils {
    public static String secondToTime(long second) {
        long days = second / 86400;//转换天数
        second = second % 86400;//剩余秒数
        long hours = second / 3600;//转换小时数
        second = second % 3600;//剩余秒数
        long minutes = second / 60;//转换分钟
        second = second % 60;//剩余秒数
        if (0 < days){
            return days + ":"+hours+":"+minutes+":"+second;
        }else {
            return hours+":"+minutes+":"+second;
        }
    }
}
