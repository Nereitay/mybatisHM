package es.kiwi.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Role implements Serializable {

    private int roleId;
    private String roleName;
    private String roleDesc;

    //多对多关系映射
    private List<User> users;
}
