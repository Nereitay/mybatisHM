package es.kiwi.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    /*private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;*/


    private Integer userId;
    private String userName;
    private Date userBirthday;
    private String userSex;
    private String userAddress;

}
