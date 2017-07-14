package wife.dao.impl;

import wife.bean.BatTaskCfg;
import wife.dao.interfaces.ITaskTimeLineDAO;
import wife.utils.MysqlJdbcUtils;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2017/7/11 Asiainfo
 * @ClassName: TaskTimeLineDAOImpl
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/11 16:37 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/11     xuxiao          v1.1.0               修改原因
 */
public class TaskTimeLineDAOImpl implements ITaskTimeLineDAO{
    @Override
    public List<BatTaskCfg> getBatTaskCfgList(String taskNo, Date taskDate, Timestamp taskBeginTime, Timestamp taskEndTime) throws Exception {
        String sql = "select *from BAT_TASK_CFG";//SQL语句
        MysqlJdbcUtils db1 = new MysqlJdbcUtils(sql);
        ResultSet ret = null;

        ret = db1.pst.executeQuery();//执行语句，得到结果集

        List<BatTaskCfg> batTaskCfgList = new ArrayList<BatTaskCfg>();
        while (ret.next()) {
            BatTaskCfg batTaskCfg = new BatTaskCfg();
            batTaskCfg.setTaskNo(ret.getString("TASK_NO"));
            batTaskCfg.setTaskDate(ret.getDate("TASK_DATE"));
            batTaskCfg.setTaskBeginTime(ret.getTimestamp("TASK_BEGIN_TIME"));
            batTaskCfg.setTaskEndTime(ret.getTimestamp("TASK_END_TIME"));
            batTaskCfgList.add(batTaskCfg);
        }//显示数据
        ret.close();
        db1.close();//关闭连接

        if(batTaskCfgList.size()==0){
            return null;
        }
        return batTaskCfgList;
    }
}
