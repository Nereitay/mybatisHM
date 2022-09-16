package es.kiwi.test;


import es.kiwi.dao.IUserDao;
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


public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public  void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public  void destroy()throws  Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public  void  testFindAll(){
        List<User> users = userDao.findAll();
//        users.forEach(System.out :: println);

    }

    /*@CacheNamespace(blocking = true)时，此测试无法停止 原因不知道......*/
    @Test
    public void testFindOne(){
        User user = userDao.findById(58);
        System.out.println(user);

        User user2 = userDao.findById(58);
        System.out.println(user2);

        System.out.println(user == user2);
    }


    @Test
    public  void testFindByName(){
        List<User> users = userDao.findUserByName("%mybatis%");
        for(User user : users){
            System.out.println(user);
        }
    }


}
