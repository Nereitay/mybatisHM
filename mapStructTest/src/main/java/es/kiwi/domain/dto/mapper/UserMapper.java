package es.kiwi.domain.dto.mapper;


import es.kiwi.domain.User;
import es.kiwi.domain.dto.UserDto1;
import es.kiwi.domain.dto.UserDto2;
import es.kiwi.domain.dto.UserDto3;
import es.kiwi.domain.dto.UserDto4;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto1 toDto1(User user);

    User fromDto1 (UserDto1 userDto1);

    UserDto2 toDto2(User user);

    @Mappings({
            @Mapping(target = "createTime", expression = "java(es.kiwi.util.DateTransform.strToDate(user.getCreateTime()))"),
    })
    UserDto3 toDto3 (User user);

    User fromDto3 (UserDto3 userDto3);

    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "name", target = "userName")
    })
    UserDto4 toDto4 (User user);

    User fromDto4 (UserDto4 userDto4);


}
