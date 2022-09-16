package es.kiwi.mybatis.sqlSession;

import es.kiwi.mybatis.cfg.Configuration;
import es.kiwi.mybatis.sqlSession.defaults.DefaultSqlSessionFactory;
import es.kiwi.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个sqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个sqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
