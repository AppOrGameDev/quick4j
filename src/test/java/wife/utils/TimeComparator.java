package wife.utils;

import java.sql.Timestamp;
import java.util.Comparator;

/**
 * Copyright: Copyright (c) 2017/7/11 Asiainfo
 * @ClassName: TimeComparator
 * @Description: 时间比较器
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/11 15:39 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/11     xuxiao          v1.1.0               修改原因
 */
public class TimeComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Timestamp time1 = (Timestamp) o1;
        Timestamp time2 = (Timestamp) o2;
        if(time1!=null){
            return time1.compareTo(time2);
        }else if(time2!=null){
            return -1;
        }else {
            return 0;
        }
    }
}
