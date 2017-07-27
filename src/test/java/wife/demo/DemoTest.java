package wife.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
    private static Log log = LogFactory.getLog(DemoTest.class);

    @BeforeClass
    public static void beforeClass(){
        log.debug("BeforeClass");
    }

    @AfterClass
    public static void afterClass(){
        log.debug("AfterClass");
    }

    @Before
    public void before(){
        log.debug("Before");
    }

    @After
    public void after(){
        log.debug("After");
    }

    @Test
    public void calculateTaskWorkTime() throws Exception {
        ITaskTimeLineSV iTaskTimeLineSV = new TaskTimeLineSVImpl();
        List<BatTaskCfg> batTaskCfgList = iTaskTimeLineSV.getBatTaskCfgList(null, null, null, null);
        List<List<Integer>> timeLine = iTaskTimeLineSV.batTaskCfgTransferTimeLine(batTaskCfgList);
        TimeLine.drawTimeLine(timeLine);
    }
}
