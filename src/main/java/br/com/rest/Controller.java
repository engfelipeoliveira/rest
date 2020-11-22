package br.com.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/get")
	public String get() {
		return "OK";
	}
	
	@GetMapping("/get/sub")
	public String getSub() {
		return "OK";
	}
	
	@RequestMapping("/login")
    public String login() {		
        return "OK";
    }
}