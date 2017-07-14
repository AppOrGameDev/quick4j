package com.eliteams.quick4j.web.interceptors.interfaces;

import com.eliteams.quick4j.web.interceptors.exception.AcceptableException;

import java.lang.reflect.Method;

/**
 * Copyright: Copyright (c) 2017/7/14 Asiainfo
 *
 * @ClassName: IInterceptor
 * @Description: 拦截器接口
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/14 11:19
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/14     xuxiao          v1.1.0               修改原因
 */
public interface IInterceptor {
    public void beforeInvoke(Object proxy, Method method, Object[] args) throws AcceptableException,Exception;
    public void afterInvoke(Object proxy, Method method, Object[] args) throws AcceptableException,Exception;
    public void acceptExceptionHandler(Object proxy, Method method, Throwable targetEx) throws AcceptableException,Exception;
}
