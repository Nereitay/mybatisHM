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
import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    public void testFindByName() {
        List<User> users = userDAO.findByName("%王%");
//        List<User> users = userDAO.findByName("王");
        users.forEach(System.out :: println);
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

    @Test
    public void testFindByCondition() {
        User u = new User();
        u.setUserName("老王");
        u.setUserSex("男");
        List<User> users = userDAO.findByCondition(u);
        users.forEach(System.out :: println);
    }


    @Test
    public void testFindInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<>(Arrays.asList(41, 42, 46));
        vo.setIds(list);

        List<User> users = userDAO.findUserInIds(vo);
        users.forEach(System.out :: println);
    }
}
