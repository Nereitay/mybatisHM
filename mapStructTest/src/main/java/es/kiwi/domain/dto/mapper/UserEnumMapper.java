package es.kiwi.domain.dto.mapper;

import es.kiwi.domain.UserEnum;
import es.kiwi.domain.dto.UserDto5;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEnumMapper {

    public static final UserEnumMapper INSTANCE = Mappers.getMapper(UserEnumMapper.class);

    @Mapping(source = "userTypeEnum.title", target = "type")
    UserDto5 toDto5 (UserEnum userEnum);

    UserEnum fromDto5 (UserDto5 userDto5);

}
