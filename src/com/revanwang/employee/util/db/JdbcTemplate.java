package com.revanwang.employee.util.db;

import com.revanwang.employee.util.result.IResultHandle;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @program: 01_EmployeeDAOStrutsJSP
 * @description: 执行SQL语句模板
 * @author: Revan.Wang
 * @create: 2019-08-05 11:13
 **/
public class JdbcTemplate {

    //私有化构造器
    private JdbcTemplate() {
    }

    /**
     * @param sql   正删改 SQL语句
     * @param args  参数
     * @return      执行SQL语句影响的行
     */
    public static int executeUpdate(String sql, Object... args) {
        //贾琏欲执事
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //2、获取连接对象
            connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, ps, null);
        }
        return 0;
    }

    /**
     * @param sql       查询结构的SQL语句
     * @param handle    实现结构集
     * @param args      参数
     * @param <T>
     * @return
     */
    public static <T> T executeQuery(String sql, IResultHandle<T> handle, Object... args) {
        //贾琏欲执事
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //2、获取连接对象
            connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            return handle.handler(ps.executeQuery());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, ps, null);
        }
        return null;
    }
}
