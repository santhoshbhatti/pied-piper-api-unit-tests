package com.pp.ut.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PiedPiperRestController {
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
}
