package com.company.project.web;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

	@RequestMapping(value = "/hello")
	public String test1(Model model) {
		ArrayList<Object> people = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			HashMap<Object, Object> singlePerson = new HashMap<>();
			singlePerson.put("name", "hanyechao");
			singlePerson.put("age", "12");
			people.add(singlePerson);
		}

		model.addAttribute("singlePerson", people.get(0));
		model.addAttribute("people", people);
		return "helloworld2";
	}
}
