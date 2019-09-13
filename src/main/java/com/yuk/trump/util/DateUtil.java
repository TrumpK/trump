package com.yuk.trump.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 12:54
 * @description：
 * @modified By：
 */
public class DateUtil {
    /**
     * 日期装字符串
     * @return
     */
    public static String getStringDate(String type){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
        String format = simpleDateFormat.format(date);
        return format;
    }

    public static Date getDate(String type) throws ParseException {
        Date date = new Date();
        SimpleDateFormat dFormat = new SimpleDateFormat(type); //HH表示24小时制；
        String formatDate = dFormat.format(date);
        Date parse = dFormat.parse(formatDate);
        return parse;
    }
}
