package com.uap.it1311l.passwordencryptorapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/test")
	String testApi() {
		return "test passed";
	}
}
