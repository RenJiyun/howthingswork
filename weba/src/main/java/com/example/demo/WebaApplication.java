package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
@Controller
public class WebaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebaApplication.class, args);
    }

    @RequestMapping(value = "getHello", method = RequestMethod.GET)
    public String getHello() {
        return "hello";
    }

    @GetMapping("sayHello")
    @ResponseBody
    public String sayHello(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value = "service", required = true) String service) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.sendRedirect(service);
        return "sayHello=====";
    }

    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public String test() {
        return "";
    }


}
