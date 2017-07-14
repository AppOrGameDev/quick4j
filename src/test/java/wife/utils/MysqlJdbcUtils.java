package wife.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Copyright: Copyright (c) 2017/7/11 Asiainfo
 * @ClassName: MysqlJdbcUtils
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: xuxiao
 * @date: 2017/7/11 11:07 
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2017/7/11     xuxiao          v1.1.0               修改原因
 */
public class MysqlJdbcUtils {
    public static final String url = "jdbc:mysql://localhost:3306/quick4j";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "root";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public MysqlJdbcUtils(String sql) {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            pst = conn.prepareStatement(sql);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
