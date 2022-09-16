package es.kiwi.mybatis.sqlsession.defaults;

import es.kiwi.mybatis.cfg.Configuration;
import es.kiwi.mybatis.sqlsession.SqlSession;
import es.kiwi.mybatis.sqlsession.SqlSessionFactory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;



    @Override
    public SqlSession openSession() {

        return new DefaultSqlSession(cfg);
    }
}
