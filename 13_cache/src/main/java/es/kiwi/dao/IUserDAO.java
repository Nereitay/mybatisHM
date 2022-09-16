package es.kiwi.dao;

import es.kiwi.domain.User;

import java.util.List;

public interface IUserDAO {

    List<User> findAll();

    User findById(int id);

    void updateUser(User user);
}
