package es.kiwi.test;

import es.kiwi.dao.IRoleDAO;
import es.kiwi.dao.IUserDAO;
import es.kiwi.domain.Role;
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
import java.util.List;

public class RoleTest {

    private SqlSession sqlSession;
    private InputStream is;
    private IRoleDAO roleDAO;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        sqlSession = factory.openSession(true);

        roleDAO = sqlSession.getMapper(IRoleDAO.class);
    }

    @After
    public void destroy() throws IOException {

        sqlSession.close();
        is.close();
    }


    @Test
    public void testFindAll(){
        List<Role> roles = roleDAO.findAll();
        roles.forEach(System.out::println);
    }

}
