package es.kiwi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEnum {

    private Integer id;
    private String name;
    private UserTypeEnum userTypeEnum;

}
