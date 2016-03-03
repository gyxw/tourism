package com.iac.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DateUtil extends DateUtils {

	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private static final String[] parsePatterns = new String[] {  
        "yyyy-MM-dd HH:mm:ss",
        "yyyy-MM-dd HH:mm",
        "yyyy-MM-dd",
        "MM/dd/yyyy HH:mm:ss",  
        "MM/dd/yyyy"
        // 这里可以增加更多的日期格式，用得多的放在前面  
    };  
	
	public static String format(Date date, String format) {
		if(date == null) return "";
		
		SimpleDateFormat df = new SimpleDateFormat(StringUtils.defaultIfEmpty(
				format, DEFAULT_FORMAT));
		return df.format(date);
	}
	
	public static String format(Date date) {
		return format(date, DEFAULT_FORMAT);
	}

	public static Date parse(String date) {
		try {
			return parseDate(date, parsePatterns);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	* 判断是否是昨天的某个时间
	 */
	public static boolean isYesterdaySomeTime(Date date) {
    	return isSomeTimeInDay(date, -1);
    }
	
	public static boolean isSomeTimeInDay(Date date, int dayIndex) {
    	if(date == null) return false;
    	
    	Date d2 = addDays(new Date(), dayIndex);
    	return isSameDay(date, d2);
    }
	
	/**
	 *判断两个日期是否是同一天
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		return truncate(date1, Calendar.DAY_OF_MONTH)
				.compareTo(truncate(date2, Calendar.DAY_OF_MONTH)) == 0;
	}
}
