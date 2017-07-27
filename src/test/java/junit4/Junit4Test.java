package junit4;

import com.eliteams.quick4j.web.interceptors.proxy.DynamicProxyHandler;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wife.bean.BatTaskCfg;
import wife.service.impl.TaskTimeLineSVImpl;
import wife.service.interfaces.ITaskTimeLineSV;
import wife.utils.TimeLine;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Copyright: Copyright (c) 2017/7/13 Asiainfo
 * @ClassName: Junit4Test
 * @Description: 单元测试类
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/13 17:01
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/13     xuxiao          v1.1.0               修改原因
 */
public class Junit4Test {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("每次执行测试类前::before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("每次执行测试类后::after class");
    }

    @Before
    public void before(){
        System.out.println("每次执行方法前::before method");
    }

    @After
    public void after(){
        System.out.println("每次执行方法后::after method");
    }

    @Test
    public void testCalculateTaskWorkTime() throws Exception {
        ITaskTimeLineSV iTaskTimeLineSV = (ITaskTimeLineSV) Proxy.newProxyInstance(ITaskTimeLineSV.class.getClassLoader(), new Class[]{ITaskTimeLineSV.class}, new DynamicProxyHandler(new TaskTimeLineSVImpl(), null));
        //我需要动态代理IOrd4EsbCSV里面的每一个方法
        List<BatTaskCfg> batTaskCfgList = iTaskTimeLineSV.getBatTaskCfgList(null, null, null, null);
        List<List<Integer>> timeLine = iTaskTimeLineSV.batTaskCfgTransferTimeLine(batTaskCfgList);
        TimeLine.drawTimeLine(timeLine);
    }

    @Test
    public void test2() throws Exception {
        System.out.println("method2");
    }


}
