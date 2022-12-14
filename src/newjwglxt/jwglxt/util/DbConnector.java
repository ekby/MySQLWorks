package newjwglxt.jwglxt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";      //驱动程序名
    private static final String DBURL = "jdbc:mysql://bj-cynosdbmysql-grp-liyuv41k.sql.tencentcdb.com:25232/jwglxt";//URL指向要访问的数据库名
    private static final String DBUSER = "root";                            //MySQL配置时的用户名
    private static final String DBPASSWORD = "xiaruncheng123!";             //MySQL配置时的密码
    private Connection connection;

    public DbConnector() {
        try {
            Class.forName(DBDRIVER);                                               //注册驱动
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);   //获得连接对象
        } catch (ClassNotFoundException e) {                                       //捕获驱动类无法找到异常
            e.printStackTrace();
        } catch (SQLException e) {                                                 //捕获SQL异常
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
