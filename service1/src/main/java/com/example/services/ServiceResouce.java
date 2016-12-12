package com.example.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/service")
public class ServiceResouce {
	
	@GetMapping
	public String getService(){
		return "teste";
	}

}
