package com.eggip.howspringsecurityworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableWebSecurity(debug = true)
public class HowspringsecurityworksApplication {

    public static void main(String[] args) {
        SpringApplication.run(HowspringsecurityworksApplication.class, args);
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/world")
    public String world() {
        return "world";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
