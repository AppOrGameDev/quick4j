package single;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Copyright: Copyright (c) 2017/7/31 Asiainfo
 * @ClassName: SingleInst
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/31 20:48 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/31     xuxiao          v1.1.0               修改原因
 */
public class SingleInst {
    private static Log log = LogFactory.getLog(SingleInst.class);

    private SingleInst(){
    }

    /*
    * 这个就是单例模式的调用方法
     */
    public SingleInst getInstance(){
        return SingleInstFactory.generateInst();
    }

    /*
    * 单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，
    * 这个类的加载过程是线程互斥的。这样当我们第一次调用getInstance的时候，
    * JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕
     */
    public static class SingleInstFactory{
        private static SingleInst singleInst = new SingleInst();

        public static SingleInst generateInst(){
            return singleInst;
        }
    }
}
