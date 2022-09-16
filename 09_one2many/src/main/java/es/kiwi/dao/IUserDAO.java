package es.kiwi.dao;

import es.kiwi.domain.Account;
import es.kiwi.domain.User;

import java.util.List;

public interface IUserDAO {

    /**
     * 查询所有用户，同时获取用户下所有的账户信息
     * @return
     */
    List<User> findAll();

    User findById(int id);

}
