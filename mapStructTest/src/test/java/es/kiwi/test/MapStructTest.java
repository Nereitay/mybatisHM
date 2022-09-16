package es.kiwi.test;

import es.kiwi.domain.User;
import es.kiwi.domain.UserEnum;
import es.kiwi.domain.UserTypeEnum;
import es.kiwi.domain.dto.UserDto1;
import es.kiwi.domain.dto.UserDto2;
import es.kiwi.domain.dto.UserDto5;
import es.kiwi.domain.dto.mapper.UserEnumMapper;
import es.kiwi.domain.dto.mapper.UserMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MapStructTest {

    private User user;

    private UserEnum userEnum;

    @Before
    public void before() {
        user = User.builder()
                .id(1)
                .name("张三")
                .createTime("2020-04-01 11:05:07")
                .updateTime(LocalDateTime.now())
                .build();

        userEnum = UserEnum.builder().id(2).name("User Enum").userTypeEnum(UserTypeEnum.Java).build();
    }

    @Test
    public void test01() throws InvocationTargetException, IllegalAccessException {


        List<Object> objectList = new ArrayList<>();

        objectList.add(user);

        // 使用mapstruct
        UserDto1 userDto1 = UserMapper.INSTANCE.toDto1(user);
        User user1 = UserMapper.INSTANCE.fromDto1(userDto1);

        UserDto2 userDto2 = UserMapper.INSTANCE.toDto2(user);

        objectList.add("userDto1:" + userDto1);
        objectList.add("userDto1转换回实体类user:" + user1);
        // 输出转换结果
        objectList.add("userDto2:" + " | " + userDto2);
        // 使用BeanUtils
        UserDto2 userDto22 = new UserDto2();
        BeanUtils.copyProperties(userDto22, user);
        objectList.add("userDto22:" + " | " + userDto22);

        objectList.forEach(System.out::println);

    }

    @Test
    public void test02() throws InvocationTargetException, IllegalAccessException {

        // 使用mapstruct
        UserDto5 userDto5 = UserEnumMapper.INSTANCE.toDto5(userEnum);

        UserEnum userEnum1 = UserEnumMapper.INSTANCE.fromDto5(userDto5);

        System.out.println("UserDto5 : " + userDto5);
        System.out.println("UserEnum : " + userEnum1);

    }
}
