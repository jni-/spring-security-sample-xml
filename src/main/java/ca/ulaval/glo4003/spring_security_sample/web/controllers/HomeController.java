package ca.ulaval.glo4003.spring_security_sample.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/users")
	public String users() {
		return "users";
	}
	
	@RequestMapping("/admin/page")
	public String admins() {
		return "admins";
	}
	
	@RequestMapping("/denied")
	public String denied() {
		return "denied";
	}
}
