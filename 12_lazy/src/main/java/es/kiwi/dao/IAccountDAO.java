package es.kiwi.dao;

import es.kiwi.domain.Account;

import java.util.List;

public interface IAccountDAO {


    List<Account> findAll();

    List<Account> findAccountByUid(int uid);

}
