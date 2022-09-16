package es.kiwi.mybatis.cfg;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nerea
 * 用于封装执行的SQL语句和结果类型的全限定类名
 */
@Getter
@Setter
public class Mapper {

    private String queryString;
    private String resultType;
}
