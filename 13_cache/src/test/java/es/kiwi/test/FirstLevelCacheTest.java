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

public class FirstLevelCacheTest {

    private SqlSession sqlSession;
    private InputStream is;
    private IUserDAO userDAO;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        factory = new SqlSessionFactoryBuilder().build(is);

        sqlSession = factory.openSession(true);

        userDAO = sqlSession.getMapper(IUserDAO.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        is.close();
    }


    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache(){
        User user1 = userDAO.findById(41);
        System.out.println(user1);


        User user2 = userDAO.findById(41);
        System.out.println(user2);


        System.out.println(user1 == user2);
    }

    @Test
    public void testFirstLevelCacheCloseSession(){
        User user1 = userDAO.findById(41);
        System.out.println(user1);

       /* sqlSession.close();
        //再次获取sqlSession
        sqlSession = factory.openSession();*/

        //此方法也可以清除缓存
        sqlSession.clearCache();


        userDAO = sqlSession.getMapper(IUserDAO.class);

        User user2 = userDAO.findById(41);
        System.out.println(user2);


        System.out.println(user1 == user2);
    }

    /**
     * 测试缓存的同步
     *  一级缓存是 SqlSession 范围的缓存，
     *  当调用 SqlSession 的修改，添加，删除，commit()，close()等方法时，就会清空一级缓存
     *
     */
    @Test
    public void testClearCache(){
        User user1 = userDAO.findById(41);
        System.out.println(user1);

        user1.setUsername("update user clear cache");
        user1.setAddress("Valencia");
        userDAO.updateUser(user1);

        User user2 = userDAO.findById(41);
        System.out.println(user2);


        System.out.println(user1 == user2);
    }


}
