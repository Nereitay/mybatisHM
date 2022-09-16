package es.kiwi.test;

import es.kiwi.dao.IUserDAO;
import es.kiwi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserTest {

    private SqlSession sqlSession;
    private InputStream is;
    private IUserDAO userDAO;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        sqlSession = factory.openSession(true);

        userDAO = sqlSession.getMapper(IUserDAO.class);
    }

    @After
    public void destroy() throws IOException {

        //提交事务
//        sqlSession.commit();

        sqlSession.close();
        is.close();
    }


    @Test
    public void testFindAll(){
        List<User> users = userDAO.findAll();
        users.forEach(System.out::println);
    }



    @Test
    public void testFindOne() {
        System.out.println(userDAO.findById(41));
    }


}
