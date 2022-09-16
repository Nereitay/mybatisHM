package es.kiwi.domain;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
public class AccountUser extends Account{

    private String username;
    private String address;

}
