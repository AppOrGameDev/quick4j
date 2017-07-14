package wife.dao.interfaces;

import wife.bean.BatTaskCfg;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Copyright: Copyright (c) 2017/7/11 Asiainfo
 *
 * @ClassName: ITaskTimeLineDAO
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/11 16:36
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/11     xuxiao          v1.1.0               修改原因
 */
public interface ITaskTimeLineDAO {
    /**
     * @Function: ITaskTimeLineDAO::getBatTaskCfgList
     * @Description: 该函数的功能描述
     * @Params: [taskNo, taskDate, taskBeginTime, taskEndTime]
     * @Return: java.util.List<wife.bean.BatTaskCfg>
     * @version: v1.0.0
     * @author: xuxiao
     * @date: 2017/7/11 16:37
     * Modification History:
     * Date         Author          Version            Description
     *-------------------------------------------------------------
     *  2017/7/11     xuxiao          v1.1.0               修改原因
     */
    public List<BatTaskCfg> getBatTaskCfgList(String taskNo, Date taskDate, Timestamp taskBeginTime, Timestamp taskEndTime) throws Exception;
}
