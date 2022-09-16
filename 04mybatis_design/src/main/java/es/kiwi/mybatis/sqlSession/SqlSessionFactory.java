package es.kiwi.mybatis.sqlSession;

public interface SqlSessionFactory {

    /**
     * 用于打开一个新的sqlSession对象
     * @return
     */
    SqlSession openSession();
}
