package es.kiwi.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 7372424381741942422L;
    private Integer id;
    private String username;
    private LocalDateTime birthday;
    private String sex;
    private String address;


}
