package es.kiwi.mybatis.sqlsession;

import es.kiwi.mybatis.cfg.Configuration;
import es.kiwi.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import es.kiwi.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    /**
     *
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {

        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);

        return new DefaultSqlSessionFactory(cfg);

    }
}
