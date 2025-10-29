package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greetingHtml(@RequestParam(name="name", required=false, defaultValue="World") String name,
							   @RequestParam(name="surname", required=false, defaultValue="!") String surname,
							   Model model) {
		model.addAttribute("name", name);
		model.addAttribute("surname", surname);
		return "greeting";
	}

	@GetMapping("/api/greeting")
	@ResponseBody
	public Map<String, String> greetingJson(@RequestParam(name="name", required=false, defaultValue="World") String name,
											@RequestParam(name="surname", required=false, defaultValue="!") String surname) {
		Map<String, String> response = new HashMap<>();
		response.put("message", "Hello " + name + " " + surname);
		return response;
	}

}
