package wife.bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Copyright: Copyright (c) 2017/7/11 Asiainfo
 * @ClassName: BatTaskCfg
 * @Description: BAT_TASK_CFG的Bean
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/11 11:38 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/11     xuxiao          v1.1.0               修改原因
 */
public class BatTaskCfg implements Comparable{
    private String taskNo;
    private Date taskDate;
    private Timestamp taskBeginTime;
    private Timestamp taskEndTime;

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public Timestamp getTaskBeginTime() {
        return taskBeginTime;
    }

    public void setTaskBeginTime(Timestamp taskBeginTime) {
        this.taskBeginTime = taskBeginTime;
    }

    public Timestamp getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Timestamp taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    /**
     * @Function: BatTaskCfg::compareTo
     * @Description: 实现Comparable重写compareTo
     * @Params: [o]
     * @Return: int
     * @version: v1.0.0
     * @author: xuxiao
     * @date: 2017/7/11 15:36
     * Modification History:
     * Date         Author          Version            Description
     *-------------------------------------------------------------
     *  2017/7/11     xuxiao          v1.1.0               修改原因
     */
    @Override
    public int compareTo(Object o) {
        // TODO: 2017/7/11
        return 0;
    }
}
