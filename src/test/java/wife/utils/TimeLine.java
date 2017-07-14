package wife.utils;

import java.util.List;

/**
 * Copyright: Copyright (c) 2017/7/11 Asiainfo
 * @ClassName: TimeLine
 * @Description: 时间轴工具类
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/11 11:25 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/11     xuxiao          v1.1.0               修改原因
 */
public class TimeLine {
    public static final int line1 = 1;
    public static final int line2 = 2;
    public static final int line3 = 3;
    public static final String line1_1 = "-";
    public static final String line2_2 = " ";
    public static final String line3_3 = "*";

    public static void drawTimeLine(List<List<Integer>> timeLinePic){
        if(timeLinePic!=null && timeLinePic.size() > 0 ){
            StringBuilder sb = new StringBuilder();
            for (int i= timeLinePic.size()-1;i>=0;i--) {
                if(timeLinePic.get(i)!=null){
                    for (Integer point : timeLinePic.get(i)) {
                        if(point!=null){
                            if(point==line1){
                                sb.append(line1_1);
                            }else if(point==line2){
                                sb.append(line2_2);
                            }else if(point==line3){
                                sb.append(line3_3);
                            }else{
                                // TODO: 2017/7/11
                            }
                        }
                    }
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
