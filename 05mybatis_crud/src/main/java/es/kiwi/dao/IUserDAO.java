package es.kiwi.dao;

import es.kiwi.domain.QueryVo;
import es.kiwi.domain.User;

import java.util.List;

public interface IUserDAO {

    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    User findById(int id);

    List<User> findByName(String name);

    int findTotal();

    List<User> findUserByVo(QueryVo vo);

}
