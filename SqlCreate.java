package sql;

import java.sql.*;

/**
 * @author XJC
 * @version JDK 8
 * @No 202210244314
 * @className SqlCreate
 * @date 2024/4/1 18:35
 */
public class SqlCreate {
    Connection con; // Connection对象
    Statement st;//Statement对象
    String sqlExecute;//sql执行语句
    private static String user;//用户名
    private static String password;//密码
    public static final String dbName = "LibSystem";

    public static void main(String[] args) {
        new SqlCreate().DBCreate();
    }

    //创建数据库
    private Connection DBCreate() {
        user = "root";//数据库登录名
        password = "123456";//密码
        try { // 加载数据库驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 通过访问数据库的URL获取数据库连接对象
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306", user, password);
            //数据库连接成功
            st = con.createStatement();
            //创建数据库(如果不存在)
            sqlExecute = "CREATE DATABASE IF NOT EXISTS " + dbName;
            st.executeUpdate(sqlExecute);
            //关闭
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
