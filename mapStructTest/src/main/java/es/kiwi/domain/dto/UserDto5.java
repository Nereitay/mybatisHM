package es.kiwi.domain.dto;

import es.kiwi.domain.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto5 {

    private Integer id;
    private String name;
    private String type;

}
