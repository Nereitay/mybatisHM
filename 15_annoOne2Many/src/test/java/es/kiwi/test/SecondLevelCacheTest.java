package es.kiwi.test;

import es.kiwi.dao.IAccountDao;
import es.kiwi.dao.IUserDao;
import es.kiwi.domain.Account;
import es.kiwi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class SecondLevelCacheTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public  void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public  void destroy()throws  Exception{

        in.close();
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(57);
        System.out.println(user);
        session.close();

        session = factory.openSession();
        IUserDao userDao1 = session.getMapper(IUserDao.class);
        User user1 = userDao1.findById(57);
        System.out.println(user1);
        session.close();
    }
}
