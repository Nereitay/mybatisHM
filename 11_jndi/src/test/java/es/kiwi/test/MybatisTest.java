package es.kiwi.test;

import es.kiwi.dao.IUserDAO;
import es.kiwi.domain.QueryVo;
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
import java.util.Date;
import java.util.List;

public class MybatisTest {

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

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("autocommit");
        user.setUserAddress("Madrid");
        user.setUserBirthday(new Date());
        user.setUserSex("m");
        System.out.println("保存操作前：" + user);
        userDAO.saveUser(user);
        System.out.println("保存操作后：" + user);
        System.out.println(user.getUserId());


    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserId(51);
        user.setUserName("mybatis saveUser");
        user.setUserAddress("Madrid");
        user.setUserBirthday(new Date());
        user.setUserSex("f");

        userDAO.updateUser(user);

    }


    @Test
    public void testDelete() {

        userDAO.deleteUser(51);

    }

    @Test
    public void testFindOne() {
        System.out.println(userDAO.findById(41));
    }

    @Test
    public void testFindByName() {
        List<User> users = userDAO.findByName("%王%");
//        List<User> users = userDAO.findByName("王");
        users.forEach(System.out :: println);
    }

    @Test
    public void testFindTotal() {
        System.out.println(userDAO.findTotal());
    }


    @Test
    public void testFindByVo() {
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUserName("%王%");
        queryVo.setUser(user);
        List<User> users = userDAO.findUserByVo(queryVo);
        users.forEach(System.out :: println);
    }
}
