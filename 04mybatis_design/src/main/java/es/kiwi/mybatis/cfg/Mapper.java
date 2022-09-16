package es.kiwi.mybatis.cfg;

import lombok.Data;

/**
 * 用于封装执行的sql语句和结果类型的全限定类名
 */
@Data
public class Mapper {

    private String queryString; //sql
    private String resultType; //实体类的全限定类名
}
