package es.kiwi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QueryVo {

    private User user;
    private List<Integer> ids;
}
