package es.kiwi.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Account implements Serializable {

    private int id;
    private int uid;
    private double money;

    //从表实体应该包含一个主表实体的对象引用
    private User user;
}
