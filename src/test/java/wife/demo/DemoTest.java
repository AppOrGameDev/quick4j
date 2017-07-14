package wife.demo;

import wife.bean.BatTaskCfg;
import wife.service.impl.TaskTimeLineSVImpl;
import wife.service.interfaces.ITaskTimeLineSV;
import wife.utils.TimeLine;

import java.util.List;

/**
 * Copyright: Copyright (c) 2017/7/11 Asiainfo
 * @ClassName: DemoTest
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/11 16:48 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/11     xuxiao          v1.1.0               修改原因
 */
public class DemoTest {

    public void calculateTaskWorkTime() throws Exception {
        ITaskTimeLineSV iTaskTimeLineSV = new TaskTimeLineSVImpl();
        List<BatTaskCfg> batTaskCfgList = iTaskTimeLineSV.getBatTaskCfgList(null, null, null, null);
        List<List<Integer>> timeLine = iTaskTimeLineSV.batTaskCfgTransferTimeLine(batTaskCfgList);
        TimeLine.drawTimeLine(timeLine);
    }
}
