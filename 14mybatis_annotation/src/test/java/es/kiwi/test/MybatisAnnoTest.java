package es.kiwi.test;

import es.kiwi.dao.IUserDAO;
import es.kiwi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {

    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = factory.openSession();

        IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);

        List<User> users = userDAO.findAll();

        users.forEach(System.out :: println);

        sqlSession.close();
        is.close();

    }
}
