package es.kiwi.test;



import es.kiwi.dao.IAccountDao;
import es.kiwi.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class AccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDAO;

    @Before
    public  void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        accountDAO = session.getMapper(IAccountDao.class);
    }

    @After
    public  void destroy()throws  Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountDAO.findAll();
        accounts.forEach(System.out :: println);
    }



}
