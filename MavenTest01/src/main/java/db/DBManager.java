package db;

import java.sql.*;

/**
 * @author JarvisHsu
 * 写两个静态方法来开启和关闭数据库。
 * public static Connection getConnection();
 * public static void closeConn(Connection conn,PreparedStatement ps,ResultSet rs);
 */


public class DBManager {
    /**
     * 开启数据库连接通道
     */
    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/db1228?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "12345678";
        try {
            Class.forName(Driver.class.getName());
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("连接数据库通道...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接通道
     */
    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                ps.close();
                conn.close();
                System.out.println("关闭数据库通道...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
