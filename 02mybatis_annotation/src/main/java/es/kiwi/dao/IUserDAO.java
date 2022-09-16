package es.kiwi.dao;

import es.kiwi.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDAO {

    @Select("select * from user")
    List<User> findAll();
}
