package es.kiwi.dao;

import es.kiwi.domain.QueryVo;
import es.kiwi.domain.User;

import java.util.List;

public interface IUserDAO {

    List<User> findAll();

    User findById(int id);

    List<User> findByName(String name);

    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件查询
     * @param user
     * @return
     */
    List<User> findByCondition(User user);

    List<User> findUserInIds(QueryVo vo);

}
