package com.eggip.howmybatisplusworks;

import com.eggip.howmybatisplusworks.mapper.UserMapper;
import com.eggip.howmybatisplusworks.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.eggip.howmybatisplusworks.mapper")
@RestController
public class HowmybatisplusworksApplication {

    public static void main(String[] args) {
        SpringApplication.run(HowmybatisplusworksApplication.class, args);
    }

    @Autowired
    private UserMapper userMapper;

    @GetMapping("test")
    public User test() {
        User user = new User();
        user.setId(1000L);
        user.setName("ren=====");
        userMapper.save(user);
        return user;
    }

}
