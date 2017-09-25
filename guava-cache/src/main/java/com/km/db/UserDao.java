package com.km.db;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.km.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>操作类</p>
 * Created by zhezhiyong@163.com on 2017/9/25.
 */
public class UserDao {
    public void insert(String sql) {
        DBPoolConnection dbp = DBPoolConnection.getInstance();    //获取数据连接池单例
        DruidPooledConnection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dbp.getConnection();    //从数据库连接池中获取数据库连接
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ps) {
                    ps.close();
                }
                if (null != conn) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public User select(String sql) {
        try (DruidPooledConnection conn = DBPoolConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                String pwd = rs.getString("password");
                return new User((long) id, name, pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }
}
