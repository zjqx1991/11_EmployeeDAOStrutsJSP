package com.revanwang.employee.util.db;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 连接数据库工具类
 */
public class JdbcUtil {

    private static DataSource dataSource = null;
    /**
     * 私有化构造器
     */
    private JdbcUtil() {}

    /**
     * 加载数据库连接池
     */
    static {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = loader.getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            //使用阿里连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException("加载classpath配置文件失败");
        }
    }

    /**
     * @return 连接对象
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param connection 连接对象
     * @param ps         执行语句
     * @param reSet      结构对象
     */
    public static void close(Connection connection, Statement ps, ResultSet reSet) {
        try {
            if (reSet != null) {
                reSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
