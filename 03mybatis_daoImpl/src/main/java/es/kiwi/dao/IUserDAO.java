package es.kiwi.dao;

import es.kiwi.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDAO {

    List<User> findAll();
}
