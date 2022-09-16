package es.kiwi.mybatis.sqlSession.defaults;

import es.kiwi.mybatis.cfg.Configuration;
import es.kiwi.mybatis.sqlSession.SqlSession;
import es.kiwi.mybatis.sqlSession.SqlSessionFactory;

/**
 * SqlSessionFactory实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }
    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
