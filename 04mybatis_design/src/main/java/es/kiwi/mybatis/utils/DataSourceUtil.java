package es.kiwi.mybatis.utils;

import es.kiwi.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 用于创建数据源的额工具类
 */
public class DataSourceUtil {
    /**
     * 用于获取一个连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
