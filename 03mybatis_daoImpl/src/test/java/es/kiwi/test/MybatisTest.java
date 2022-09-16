package es.kiwi.test;

import es.kiwi.dao.IUserDAO;
import es.kiwi.dao.impl.UserDAOImpl;
import es.kiwi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    /**
     * 入门案例  自己写实现类
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

        //3.使用工厂创建dao对象
        IUserDAO userDAO = new UserDAOImpl(factory);

        //4.使用代理对象执行方法
        List<User> users = userDAO.findAll();
        for (User user : users) {
            System.out.println(user);
        }

        //6.释放资源

        is.close();

    }
}
