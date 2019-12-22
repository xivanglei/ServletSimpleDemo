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

    public static String getGMTTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(GMT, Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // 设置时区为GMT
        return sdf.format(System.currentTimeMillis());
    }
}
