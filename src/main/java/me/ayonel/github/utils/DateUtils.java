package me.ayonel.github.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: ayonel
 * Date: 2017/12/9
 * Blog: https://ayonel.me
 * GitHub: https://github.com/ayonel
 * Email: ayonel@qq.com
 */
public class DateUtils {
    /**
     * 将时间戳转化为格式化之后的时间字符串：1970-01-01 00:00:00
     * @param timeStamp
     * @return
     */
    public static String stampToString(double timeStamp) {
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lcc_time = new Double(timeStamp).longValue();
        timeString = sdf.format(new Date(lcc_time * 1000L));
        return timeString;

    }

}
