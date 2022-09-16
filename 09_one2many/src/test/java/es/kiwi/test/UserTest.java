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

        sqlSession.close();
        is.close();
    }


    @Test
    public void testFindAll(){
        List<User> users = userDAO.findAll();
        users.forEach(System.out::println);
    }
    /*
    User(id=41, username=update user clear cache, birthday=Tue Feb 27 18:47:08 CET 2018, sex=男, address=Valencia,
    accounts=[Account(id=1, uid=41, money=1000.0, user=null), Account(id=3, uid=41, money=2000.0, user=null)])

    User(id=45, username=传智播客, birthday=Sun Mar 04 13:04:06 CET 2018, sex=男, address=北京金燕龙, accounts=[Account(id=2,
    uid=45, money=1000.0, user=null)])

     */


    @Test
    public void testFindOne() {
        System.out.println(userDAO.findById(41));
    }


}
