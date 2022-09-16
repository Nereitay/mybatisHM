package es.kiwi.mybatis.utils;

import es.kiwi.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DataResourceUtil {

    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return  DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
