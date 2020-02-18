package com.iflytek.contoller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Value("${roncoo.secret}")
	private String sercret;
	@GetMapping("/hello")
	public String helloWorld() {
		System.out.println(sercret);
		System.out.println(1);
		return sercret;
	}
}
