package proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Copyright: Copyright (c) 2017/7/13 Asiainfo
 * @ClassName: ProxyHandler
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/13 17:18 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/13     xuxiao          v1.1.0               修改原因
 */
public class ProxyHandler implements InvocationHandler {
    private Object proxied;

    public ProxyHandler(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object rtn;
        //在转调具体目标对象之前，可以执行一些功能处理
        before();
        
        //转调具体目标对象的方法
        rtn = method.invoke( proxied, args);

        //在转调具体目标对象之后，可以执行一些功能处理
        after();
        
        return rtn;
    }
    
    public void before(){
        // TODO: 2017/7/13
        System.out.println("代理前");
    }
    
    public void after(){
        // TODO: 2017/7/13
        System.out.println("代理后");
    }
}
