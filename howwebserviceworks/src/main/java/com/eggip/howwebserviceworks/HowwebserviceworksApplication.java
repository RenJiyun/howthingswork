package com.eggip.howwebserviceworks;

import com.eggip.howwebserviceworks.service.impl.HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Endpoint;

@SpringBootApplication
@RestController
@RequestMapping("/aa")
public class HowwebserviceworksApplication {
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		System.out.println("发布webservice");
		Endpoint endpoint = Endpoint.create(new HelloServiceImpl());
		endpoint.publish("http://localhost:8081/HelloService/");
		System.out.println("webservice发布成功");
		SpringApplication.run(HowwebserviceworksApplication.class, args);
	}

	@PostMapping("/test")
	public String test(@RequestBody Person person) {
		return "hello";
	}




}
