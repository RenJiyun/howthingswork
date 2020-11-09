package com.eggip.howmybatisplusworks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.eggip.howmybatisplusworks.mapper")
public class HowmybatisplusworksApplication {

    public static void main(String[] args) {
        SpringApplication.run(HowmybatisplusworksApplication.class, args);
    }

}
