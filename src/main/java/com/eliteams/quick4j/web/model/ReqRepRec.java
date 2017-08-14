package com.eliteams.quick4j.web.model;

import com.alibaba.druid.support.json.JSONUtils;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Copyright: Copyright (c) 2017/8/14 Asiainfo
 * @ClassName: ReqRepRec
 * @Description: 请求相应记录表模型
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/8/14 21:14 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/8/14     xuxiao          v1.1.0               修改原因
 */
public class ReqRepRec implements Serializable {
    private Long logId;
    private String requestInfo;
    private String responseInfo;
    private String result;
    private Timestamp requestTime;
    private Timestamp responseTime;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(String requestInfo) {
        this.requestInfo = requestInfo;
    }

    public String getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(String responseInfo) {
        this.responseInfo = responseInfo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Timestamp requestTime) {
        this.requestTime = requestTime;
    }

    public Timestamp getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Timestamp responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public String toString() {
        return JSONUtils.toJSONString(this);
    }
}
