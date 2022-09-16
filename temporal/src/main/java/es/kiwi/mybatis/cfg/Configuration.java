package es.kiwi.mybatis.cfg;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String, Mapper> mappers = new HashMap<>();

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers); //此处需要使用追加的方式
    }


}


