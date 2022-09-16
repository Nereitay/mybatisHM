package es.kiwi.test;

import es.kiwi.dao.IUserDAO;
import es.kiwi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    /**
     * 入门案例  基于注解
     *      把IUserDao.xml移除，在dao接口的方法上使用@Select注解，并且指定SQL语句
     * 			同时需要在SqlMapConfig.xml中的mapper配置时，使用class属性指定dao接口的全限定类名。
         * 	明确：
         * 		我们在实际开发中，都是越简便越好，所以都是采用不写dao实现类的方式。
         * 		不管使用XML还是注解配置。
         * 		但是Mybatis它是支持写dao实现类的。
     * mybatis的入门案例
     * 		第一步：读取配置文件
     * 		第二步：创建SqlSessionFactory工厂
     * 		第三步：创建SqlSession
     * 		第四步：创建Dao接口的代理对象
     * 		第五步：执行dao中的方法
     * 		第六步：释放资源
     *
     * 		注意事项：
     * 			不要忘记在映射配置中告知mybatis要封装到哪个实体类中
     * 			配置的方式：指定实体类的全限定类名
     */
    @Test
    public void test01() throws IOException {
        //1. 读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);

        //3.使用工厂生产sqlSession对象
        SqlSession session = factory.openSession();

        //4.使用sqlSession创建dao接口的代理对象
        IUserDAO userDAO = session.getMapper(IUserDAO.class);

        //5.使用代理对象执行方法
        List<User> users = userDAO.findAll();
        for (User user : users) {
            System.out.println(user);
        }

        //6.释放资源
        session.close();
        is.close();

    }
}
