package es.kiwi.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto1 {

    private Integer id;
    private String name;
    private String createTime;
    private LocalDateTime updateTime;
}
