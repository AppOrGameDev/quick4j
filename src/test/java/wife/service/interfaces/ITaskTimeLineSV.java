package wife.service.interfaces;

import wife.bean.BatTaskCfg;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Copyright: Copyright (c) 2017/7/11 Asiainfo
 *
 * @ClassName: ITaskTimeLineSV
 * @Description: 任务时间线
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/11 14:18
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/11     xuxiao          v1.1.0               修改原因
 */
public interface ITaskTimeLineSV {
    /**
     * @Function: ITaskTimeLineSV::batTaskCfgTransferTimeLine
     * @Description: 将BAT_TASK_CFG转换成时间线
     * @Params: [batTaskCfgList]
     * @Return: java.util.List<java.util.List<java.lang.Boolean>>
     * @version: v1.0.0
     * @author: xuxiao
     * @date: 2017/7/11 14:24
     * Modification History:
     * Date         Author          Version            Description
     *-------------------------------------------------------------
     *  2017/7/11     xuxiao          v1.1.0               修改原因
     */
    public List<List<Integer>> batTaskCfgTransferTimeLine(List<BatTaskCfg> batTaskCfgList) throws Exception;
    /**
     * @Function: ITaskTimeLineSV::getBatTaskCfgList
     * @Description: 查询BAT_TASK_CFG表
     * @Params: [taskNo, taskDate, taskBeginTime, taskEndTime]
     * @Return: java.util.List<wife.bean.BatTaskCfg>
     * @version: v1.0.0
     * @author: xuxiao
     * @date: 2017/7/11 14:25
     * Modification History:
     * Date         Author          Version            Description
     *-------------------------------------------------------------
     *  2017/7/11     xuxiao          v1.1.0               修改原因
     */
    public List<BatTaskCfg> getBatTaskCfgList(String taskNo, Date taskDate, Timestamp taskBeginTime, Timestamp taskEndTime) throws Exception;

}
