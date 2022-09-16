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

public class SecondLevelCacheTest {

    private InputStream is;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        factory = new SqlSessionFactoryBuilder().build(is);

    }

    @After
    public void destroy() throws IOException {

        is.close();
    }


    /**
     * 测试二级缓存
     */
    @Test
    public void testSecondLevelCache(){
        SqlSession sqlSession1 = factory.openSession();
        IUserDAO userDAO1 = sqlSession1.getMapper(IUserDAO.class);
        User user1 = userDAO1.findById(41);
        System.out.println(user1);
        sqlSession1.close();

        SqlSession sqlSession2 = factory.openSession();
        IUserDAO userDAO2 = sqlSession2.getMapper(IUserDAO.class);
        User user2 = userDAO2.findById(41);
        System.out.println(user2);
        sqlSession2.close();


        /*
        二级缓存存放的是数据而不是对象
         */
        System.out.println(user1 == user2); // false 因为二级缓存存放的是数据而不是对象
    }



}
