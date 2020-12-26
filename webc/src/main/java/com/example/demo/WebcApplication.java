package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class WebcApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebcApplication.class, args);
	}

	@GetMapping("sayHello")
	public String sayHello(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "name", required = true) String name) {
		System.out.println("====================");
		System.out.println(request.getHeader("Origin"));
//		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		return "Hello, " + name;
	}


}
