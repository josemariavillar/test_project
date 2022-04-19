package com.test.project.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello() {

		Boolean file1;
		Integer file2;
		Long util3;
		Double util4;
		Float util5;


		return "Hello world!";
	}
}
