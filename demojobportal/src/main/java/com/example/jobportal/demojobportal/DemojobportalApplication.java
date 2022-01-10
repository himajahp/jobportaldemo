package com.example.jobportal.demojobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class DemojobportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemojobportalApplication.class, args);
	}

//	@GetMapping("/hello")
////	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//		public String hello() {
//		return "SamplePage";
//		//return "Hello s!";
//	}

	//EmployeeController ec = new EmployeeController();

}
