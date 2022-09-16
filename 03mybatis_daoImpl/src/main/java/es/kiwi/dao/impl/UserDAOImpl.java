package es.kiwi.dao.impl;

import es.kiwi.dao.IUserDAO;
import es.kiwi.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDAOImpl implements IUserDAO {

    private SqlSessionFactory factory;

    public UserDAOImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        //1. 使用工厂创建sqlSession对象
        SqlSession session = factory.openSession();
        //2. 使用session执行查询所有方法
        List<User> users = session.selectList("es.kiwi.dao.IUserDAO.findAll");
        session.close();
        //3. 返回查询结果
        return users;
    }
}
