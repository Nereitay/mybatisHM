package es.kiwi.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class User implements Serializable {

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

}
