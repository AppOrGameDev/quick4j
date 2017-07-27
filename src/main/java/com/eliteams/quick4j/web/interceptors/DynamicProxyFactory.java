package com.eliteams.quick4j.web.interceptors;

import com.eliteams.quick4j.web.interceptors.interfaces.IInterceptor;
import com.eliteams.quick4j.web.interceptors.proxy.DynamicProxyHandler;

import java.lang.reflect.Proxy;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2017/7/27 Asiainfo
 * @ClassName: DynamicProxyFactory
 * @Description: 动态代理工厂类
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/27 20:13 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/27     xuxiao          v1.1.0               修改原因
 */
public class DynamicProxyFactory {
    public static <T> T getProxyInstance(T obj,  IInterceptor proxyInterceptor) {
        DynamicProxyHandler handle = new DynamicProxyHandler(obj,proxyInterceptor);
        Class clazz = obj.getClass();
        Set<Class<?>> interfacesSet = getAllInterfacesForClassAsSet(clazz);
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), interfacesSet.toArray(new Class<?>[0]), handle);
    }


    public static Set<Class<?>> getAllInterfacesForClassAsSet(Class<?> clazz) {
        Set<Class<?>> interfaces = new LinkedHashSet<Class<?>>();
        while (clazz != null) {
            Class<?>[] ifcs = clazz.getInterfaces();
            for(Class<?> ifc : ifcs){
                interfaces.add(ifc);
            }
            clazz = clazz.getSuperclass();
        }
        return interfaces;
    }

    public static <T> T getProxyInstance(Class<?>[] interfaces, T obj, IInterceptor proxyInterceptor){
        DynamicProxyHandler handle = new DynamicProxyHandler(obj,proxyInterceptor);
        Class clazz = obj.getClass();
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), interfaces, handle);
    }
}
