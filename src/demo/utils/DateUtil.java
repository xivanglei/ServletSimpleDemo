package demo.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Author:xianglei
 * Date: 2019-12-22 16:06
 * Description:日期
 */
public class DateUtil {

    public static final String GMT = "EEE d MMM yyyy HH:mm:ss 'GMT'";

    public static final String DATE_TIME_1 = "yyyy-MM-dd hh:mm:ss";
    public static final String DATE_TIME_2 = "yyyy-MM-dd--hh:mm:ss";

    public static String getGMTTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(GMT, Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // 设置时区为GMT
        return sdf.format(System.currentTimeMillis());
    }

    public static String getTime(String pattern) {
        return getTime(pattern, System.currentTimeMillis());
    }

    public static String getTime(String pattern, long date) {
        return new SimpleDateFormat(pattern).format(date);
    }
}
