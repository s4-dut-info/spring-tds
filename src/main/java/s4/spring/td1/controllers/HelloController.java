package s4.spring.td1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("")
	public @ResponseBody String index() {
		return "Hello world!";
	}
}
