package es.kiwi.dao;

import es.kiwi.domain.Role;

import java.util.List;

public interface IRoleDAO {

    List<Role> findAll();
}
