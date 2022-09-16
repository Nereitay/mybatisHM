package es.kiwi.test;

import es.kiwi.dao.IAccountDAO;
import es.kiwi.dao.IUserDAO;
import es.kiwi.domain.Account;
import es.kiwi.domain.AccountUser;
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

public class AccountTest {

    private SqlSession sqlSession;
    private InputStream is;
    private IAccountDAO accountDAO;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        sqlSession = factory.openSession(true);

        accountDAO = sqlSession.getMapper(IAccountDAO.class);
    }

    @After
    public void destroy() throws IOException {

        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = accountDAO.findAll();
        accounts.forEach(System.out :: println);

    }

    @Test
    public void testFindAllAccountUser() {
        List<AccountUser> aus = accountDAO.findAllAccount();
        aus.forEach(System.out :: println);
    }

}
