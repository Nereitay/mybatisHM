package es.kiwi.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class User implements Serializable {

    private int id;
    private String username;
    private String sex;
    private String address;
    private Date birthday;
}
