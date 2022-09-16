package es.kiwi.dao;

import es.kiwi.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public interface IAccountDao {

    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     *
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(column = "uid",
                    property = "user",
                    one = @One(select = "es.kiwi.dao.IUserDao.findById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    @Select("select * from account where uid = #{uid}")
    List<Account> findAccountByUid(int uid);

}
