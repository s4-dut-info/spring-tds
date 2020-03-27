package spring.vuejs.samples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import spring.vuejs.samples.classes.Sample;
import spring.vuejs.samples.classes.User;

@Controller
@SessionAttributes("activeUser")
public class ConnectedController {

	@ModelAttribute("activeUser")
	private User getUser() {
		return new User();
	}
	@RequestMapping("/{(index)?}")
	public String index(ModelMap model) {
		model.put("samples", Sample.all());
		return "index";
	}

}
