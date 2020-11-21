package com.eggip.howmybatisplusworks;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.eggip.howmybatisplusworks.mapper.UserMapper;
import com.eggip.howmybatisplusworks.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("test")
    public User test() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, 1);
//        return userMapper.selectOne(wrapper);
        return userMapper.getUserById(1L);
    }

}
