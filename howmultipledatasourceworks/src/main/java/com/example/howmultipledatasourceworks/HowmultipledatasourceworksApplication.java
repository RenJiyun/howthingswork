package com.example.howmultipledatasourceworks;

import com.example.howmultipledatasourceworks.model.db1.User;
import com.example.howmultipledatasourceworks.model.db2.Organization;
import com.example.howmultipledatasourceworks.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@EnableTransactionManagement
@RestController
public class HowmultipledatasourceworksApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowmultipledatasourceworksApplication.class, args);
	}


	@Autowired
	private DemoService demoService;

	@GetMapping("hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("getUser")
	public User getUser(@RequestParam("id") int id) {
		return demoService.getUser(id);
	}

	@GetMapping("getOrg")
	public Organization getOrg(@RequestParam("id") int id) {
		return demoService.getOrg(id);
	}

	@GetMapping("testStream")
	public String testStream() throws IOException {
		demoService.testStream();
		return "ok";
	}

	@GetMapping("testReload")
	public String testReload() {
		return "hello====";
	}


}
