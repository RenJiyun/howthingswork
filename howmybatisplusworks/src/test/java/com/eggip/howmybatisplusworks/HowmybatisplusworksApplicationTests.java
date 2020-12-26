package com.eggip.howmybatisplusworks;

import com.eggip.howmybatisplusworks.mapper.UserMapper;
import com.eggip.howmybatisplusworks.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HowmybatisplusworksApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void test1() {
        User user = new User();
    }

}
