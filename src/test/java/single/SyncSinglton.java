package single;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Vector;

/**
 * Copyright: Copyright (c) 2017/7/31 Asiainfo
 * @ClassName: SyncSinglton
 * @Description: 影子实例同步更新单例属性
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/31 21:01 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/31     xuxiao          v1.1.0               修改原因
 */
public class SyncSinglton {
    private static Log log = LogFactory.getLog(SyncSinglton.class);

    private static SyncSinglton syncSinglton = null;
    private Vector properties = null;

    private SyncSinglton(){
    }

    private static synchronized SyncSinglton syncInit(){
        if(syncSinglton==null){
            syncSinglton = new SyncSinglton();
        }
        return syncSinglton;
    }

    public static SyncSinglton getInstance(){
        if (syncSinglton == null){
            return syncInit();
        }
        return syncSinglton;
    }

    private static synchronized void syncUpdate(Vector properties){
        if(properties!=null && !properties.isEmpty()){
            SyncSinglton instance = getInstance();
            instance.properties = properties;
        }
    }
}
