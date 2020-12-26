package com.tuffy.fasdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FasdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FasdemoApplication.class, args);
	}

	@Autowired
	private DemoService demoService;

	@GetMapping("hello")
	public String hello() {
		return demoService.hello();
	}

}
