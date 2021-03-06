package com.eggip.howmybatisworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class HowmybatisworksApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowmybatisworksApplication.class, args);
	}

	@GetMapping("/getRequestIp")
	public String getRequestIp(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

}
