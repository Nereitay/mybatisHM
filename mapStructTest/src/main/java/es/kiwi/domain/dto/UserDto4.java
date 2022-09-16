package es.kiwi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto4 {
    // 实体类该属性名是id
    private String userId;
    // 实体类该属性名是name
    private String userName;
    private String createTime;
    private String updateTime;
}