package es.kiwi.domain;


import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Integer id;
    private String name;
    private String createTime;
    private LocalDateTime updateTime;
}
