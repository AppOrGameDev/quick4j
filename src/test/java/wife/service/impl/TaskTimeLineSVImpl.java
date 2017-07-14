package wife.service.impl;

import wife.bean.BatTaskCfg;
import wife.dao.impl.TaskTimeLineDAOImpl;
import wife.dao.interfaces.ITaskTimeLineDAO;
import wife.service.interfaces.ITaskTimeLineSV;
import wife.utils.TimeComparator;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static wife.utils.TimeLine.line1;
import static wife.utils.TimeLine.line2;
import static wife.utils.TimeLine.line3;

/**
 * Copyright: Copyright (c) 2017/7/11 Asiainfo
 * @ClassName: TaskTimeLineSVImpl
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/11 14:19 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/11     xuxiao          v1.1.0               修改原因
 */
public class TaskTimeLineSVImpl implements ITaskTimeLineSV{
    @Override
    public List<List<Integer>> batTaskCfgTransferTimeLine(List<BatTaskCfg> batTaskCfgList) throws Exception {
        if(batTaskCfgList==null || batTaskCfgList.size()<=0){
            return null;
        }
        //基础时间轴
        List<Timestamp> baseTimestamp = getTimePoint4BatTaskCfg(batTaskCfgList);
        //计算空闲时间和运行时间
        freeTime(baseTimestamp,batTaskCfgList);
        List<Integer> baseTimeLine = new ArrayList<Integer>();
        if(baseTimestamp!=null && baseTimestamp.size()>0){
            for (int i = 0; i < baseTimestamp.size()-1; i++) {
                baseTimeLine.add(line3);
                baseTimeLine.add(line1);
            }
            baseTimeLine.add(line3);
        }
        List<List<Integer>> timeLineList = new ArrayList<List<Integer>>();
        timeLineList.add(baseTimeLine);
        //每一条记录时间线
        for (BatTaskCfg one : batTaskCfgList) {
            //单条时间线
            List<Integer> timeLine = generateTiemLine(baseTimestamp,one);
            timeLineList.add(timeLine);
        }
        return timeLineList;
    }

    private void freeTime(List<Timestamp> baseTimestamp,List<BatTaskCfg> batTaskCfgList) throws Exception {
        if(baseTimestamp==null || baseTimestamp.size()<2){
            throw new Exception("基础时间轴节点少于2个"+baseTimestamp);
        }
        if(batTaskCfgList==null || batTaskCfgList.size()<=0){
            throw new Exception("任务时间列表为空"+batTaskCfgList);
        }
        long freeTime = 0L;
        for (int i = 0; i < baseTimestamp.size()-1; i++) {
            boolean isFree = true;
            for (BatTaskCfg batTaskCfg : batTaskCfgList) {
                if(batTaskCfg.getTaskBeginTime().compareTo(baseTimestamp.get(i))<=0 && batTaskCfg.getTaskEndTime().compareTo(baseTimestamp.get(i+1))>=0){
                    //标准时间轴上的每一小段时间段在某个人的始末时间段内，则是工作时间，直接进行标准时间轴上下一小段时间的比较
                    isFree = false;
                    break;
                }
            }
            if(isFree){
                freeTime = freeTime + (baseTimestamp.get(i+1).getTime() - baseTimestamp.get(i).getTime());
            }
        }
        System.out.println("任务群开始时间::"+baseTimestamp.get(0));
        System.out.println("任务群结束时间::"+baseTimestamp.get(baseTimestamp.size()-1));
        System.out.println("任务群总时间::"+(baseTimestamp.get(baseTimestamp.size()-1).getTime() - baseTimestamp.get(0).getTime()));
        System.out.println("任务群空闲时间::"+freeTime);
    }

    private List<Integer> generateTiemLine(List<Timestamp> baseTimestamp,BatTaskCfg batTaskCfg) throws Exception {
        if(baseTimestamp==null || baseTimestamp.size()<=0 || batTaskCfg==null){
            return null;
        }
        List<Integer> timeLine = new ArrayList<Integer>();
        boolean flag = false;
        for (Timestamp one : baseTimestamp) {
            if (!flag && one.before(batTaskCfg.getTaskBeginTime())) {
                timeLine.add(line2);
            }else if(!flag && one.equals(batTaskCfg.getTaskBeginTime())){
                timeLine.add(line3);
                flag = true;
            }else if(flag && one.before(batTaskCfg.getTaskEndTime())){
                timeLine.add(line1);
            }else if(flag && one.equals(batTaskCfg.getTaskEndTime())){
                if(!batTaskCfg.getTaskBeginTime().equals(batTaskCfg.getTaskEndTime())){
                    timeLine.add(line3);
                }
                flag = false;
            }else if(!flag && one.after(batTaskCfg.getTaskEndTime())){
                timeLine.add(line2);
            }
        }
        //填充分隔符
        fillSeparator(timeLine);
        return timeLine;
    }

    private void fillSeparator(List<Integer> timeLine) throws Exception {
        if(timeLine!=null && timeLine.size() > 1){
            int pointNum = 0;
            for (int i = timeLine.size()-1; i >0 ; i--) {
                if(timeLine.get(i) == line1){
                    timeLine.add(i,line1);
                }else if(timeLine.get(i) == line2){
                    timeLine.add(i,line2);
                }else if(timeLine.get(i) == line3){
                    if(pointNum==0){
                        timeLine.add(i,line1);
                    }else if(pointNum==1){
                        timeLine.add(i,line2);
                    }else{
                        throw new Exception("当前时间轴有多个时间节点"+timeLine.toArray());
                    }
                    pointNum++;
                }
            }
            if(pointNum==1){
                //只有一个时间节点
                timeLine.set(timeLine.indexOf(line1),line2);
            }
        }
    }

    /**
     * @Function: TaskTimeLineSVImpl::getTimePoint4BatTaskCfg
     * @Description: 遍历batTaskCfgList的时间点，升序排列
     * @Params: [batTaskCfgList]
     * @Return: java.util.List<java.sql.Timestamp>
     * @version: v1.0.0
     * @author: xuxiao
     * @date: 2017/7/11 15:56
     * Modification History:
     * Date         Author          Version            Description
     *-------------------------------------------------------------
     *  2017/7/11     xuxiao          v1.1.0               修改原因
     */
    private List<Timestamp> getTimePoint4BatTaskCfg(List<BatTaskCfg> batTaskCfgList){
        if(batTaskCfgList==null || batTaskCfgList.size()<=0){
            return null;
        }
        List<Timestamp> baseTimeLine = new ArrayList<Timestamp>();
        //遍历batTaskCfgList所有的begin和end时间点(去除重复的时间点)
        for (BatTaskCfg one : batTaskCfgList) {
            if(!baseTimeLine.contains(one.getTaskBeginTime())){
                baseTimeLine.add(one.getTaskBeginTime());
            }
            if(!baseTimeLine.contains(one.getTaskEndTime())){
                baseTimeLine.add(one.getTaskEndTime());
            }
        }
        //升序排列
        Collections.sort(baseTimeLine, new TimeComparator());
        return baseTimeLine;
    }

    @Override
    public List<BatTaskCfg> getBatTaskCfgList(String taskNo, Date taskDate, Timestamp taskBeginTime, Timestamp taskEndTime) throws Exception {
        ITaskTimeLineDAO iTaskTimeLineDAO = new TaskTimeLineDAOImpl();
        return iTaskTimeLineDAO.getBatTaskCfgList(taskNo,taskDate,taskBeginTime,taskEndTime);
    }
}
