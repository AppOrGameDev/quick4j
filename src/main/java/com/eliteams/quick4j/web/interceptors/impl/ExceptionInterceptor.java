package com.eliteams.quick4j.web.interceptors.impl;

import com.eliteams.quick4j.web.interceptors.exception.AcceptableException;
import com.eliteams.quick4j.web.interceptors.interfaces.IInterceptor;

import java.lang.reflect.Method;

/**
 * Copyright: Copyright (c) 2017/7/14 Asiainfo
 * @ClassName: ExceptionInterceptor
 * @Description: 异常拦截器
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/14 11:22 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/14     xuxiao          v1.1.0               修改原因
 */
public class ExceptionInterceptor implements IInterceptor{
    IInterceptor interceptor = null;

    public ExceptionInterceptor(){
    }

    public ExceptionInterceptor(IInterceptor interceptor){
        this.interceptor = interceptor;
    }

    @Override
    public void beforeInvoke(Object proxy, Method method, Object[] args) throws AcceptableException, Exception {
        // TODO: 2017/7/14  链式创建连接器时，谁在先就先执行谁的拦截方法
        if(this.interceptor!=null){
            this.interceptor.beforeInvoke(proxy,method,args);
        }
    }

    @Override
    public void afterInvoke(Object proxy, Method method, Object[] args) throws AcceptableException, Exception {
        if(this.interceptor!=null){
            this.interceptor.afterInvoke(proxy,method,args);
        }
        // TODO: 2017/7/14
    }

    @Override
    public void acceptExceptionHandler(Object proxy, Method method, Throwable targetEx) throws AcceptableException, Exception {

    }
}
