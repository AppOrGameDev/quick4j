package com.eliteams.quick4j.test.interceptor;

import com.eliteams.quick4j.web.interceptors.DynamicProxyFactory;
import com.eliteams.quick4j.web.interceptors.impl.ExceptionInterceptor;
import wife.bean.BatTaskCfg;
import wife.service.impl.TaskTimeLineSVImpl;
import wife.service.interfaces.ITaskTimeLineSV;
import wife.utils.TimeLine;

import java.util.List;

/**
 * Copyright: Copyright (c) 2017/7/27 Asiainfo
 * @ClassName: InterceptorTest
 * @Description: 拦截器测试类
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/27 20:20 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/27     xuxiao          v1.1.0               修改原因
 */
public class InterceptorTest {
    public static void main(String[] args) {
        InterceptorTest test = new InterceptorTest();
        test.test01();
        test.test02();
    }
    public void test01() {
        ITaskTimeLineSV iTaskTimeLineSV = DynamicProxyFactory.getProxyInstance(new TaskTimeLineSVImpl(), new ExceptionInterceptor());
        try {
            List<BatTaskCfg> batTaskCfgList = iTaskTimeLineSV.getBatTaskCfgList(null, null, null, null);
            List<List<Integer>> timeLine = iTaskTimeLineSV.batTaskCfgTransferTimeLine(batTaskCfgList);
            TimeLine.drawTimeLine(timeLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void test02(){
        ITaskTimeLineSV iTaskTimeLineSV = DynamicProxyFactory.getProxyInstance(new Class[]{ITaskTimeLineSV.class},new TaskTimeLineSVImpl(), new ExceptionInterceptor());
        try {
            List<BatTaskCfg> batTaskCfgList = iTaskTimeLineSV.getBatTaskCfgList(null, null, null, null);
            List<List<Integer>> timeLine = iTaskTimeLineSV.batTaskCfgTransferTimeLine(batTaskCfgList);
            TimeLine.drawTimeLine(timeLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
