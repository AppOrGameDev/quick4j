package wife.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTineUtils {
    private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    // TODO: 2017/7/31 根据需求新增其他时间格式

    public static Timestamp getTimestamo(String yyyyMMddHHmmss, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date textDate = sdf.parse(yyyyMMddHHmmss);
        Timestamp ts = new Timestamp(textDate.getTime());
        return ts;
    }

    public static String getString(Timestamp yyyyMMddHHmmss, String format){
        if(yyyyMMddHHmmss == null) {
            return null;
        } else {
            DateFormat dateformat = new SimpleDateFormat(format);
            return dateformat.format(yyyyMMddHHmmss);
        }
    }

    public static Timestamp getTimestamp (String yyyyMMddHHmmss) throws ParseException {
        return getTimestamo(yyyyMMddHHmmss,YYYY_MM_DD_HH_MM_SS);
    }

    public static String getString(Timestamp yyyyMMddHHmmss){
        return getString(yyyyMMddHHmmss,YYYY_MM_DD_HH_MM_SS);
    }

    public static void main(String[] args) throws ParseException {
        String str = getString(new Timestamp(System.currentTimeMillis()));
        System.out.println(str);
        Timestamp timestamp = getTimestamp(str);
        System.out.println(timestamp);

    }
}
