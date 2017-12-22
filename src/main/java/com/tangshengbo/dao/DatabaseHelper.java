package com.tangshengbo.dao;

import com.tangshengbo.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by TangShengBo on 2017/12/22.
 */
public class DatabaseHelper {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseHelper.class);

    private static final String DERIVE;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties conf = PropsUtil.loadProps("db-config.properties");
        DERIVE = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");
        try {
            Class.forName(DERIVE);
        } catch (ClassNotFoundException e) {
            logger.error("加载驱动异常:{}", e);
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            logger.error("获取连接异常:{}", e);
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (Objects.nonNull(conn)) {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("连接关闭异常:{}", e);
            }
        }
    }
}
