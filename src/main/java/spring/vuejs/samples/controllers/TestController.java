package spring.vuejs.samples.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.jeemv.springboot.vuejs.VueJS;
import spring.vuejs.samples.UserRepository;
import spring.vuejs.samples.classes.Sample;
import spring.vuejs.samples.models.User;

@Controller
public class TestController {
	@Autowired
	private VueJS vue;
	@Autowired
	private UserRepository userRepo;

	@ModelAttribute(name = "vue")
	private VueJS getVue() {
		return this.vue;
	}

	@RequestMapping(value = {"", "/", "index"})
	public String index(ModelMap model) {
		model.put("samples", Sample.all());
		return "index";
	}

	@RequestMapping("/test")
	public String test() {
		vue.addData("message", "Hello world");
		return "test";
	}

	@GetMapping("/addUsers")
	@ResponseBody
	public String addUsers() {
		userRepo.save(new User("Bob"));
		userRepo.save(new User("regina"));
		userRepo.save(new User("Alfred"));
		return "users added";
	}

	@GetMapping("/getUsers")
	public String getUsers(ModelMap model) {
		List<User> users = userRepo.findAll();
		model.put("users", users);
		return "users";
	}
}
