package es.kiwi.mybatis.sqlsession.defaults;

import es.kiwi.mybatis.cfg.Configuration;
import es.kiwi.mybatis.sqlsession.SqlSession;
import es.kiwi.mybatis.sqlsession.proxy.MapperProxy;
import es.kiwi.mybatis.utils.DataResourceUtil;
import lombok.AllArgsConstructor;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;


public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        conn = DataResourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建类加载器
     *
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(), conn));

    }


    @Override
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
