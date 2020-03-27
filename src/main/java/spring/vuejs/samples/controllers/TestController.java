package spring.vuejs.samples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.jeemv.springboot.vuejs.VueJS;
import spring.vuejs.samples.classes.Sample;

@Controller
public class TestController {
	@Autowired
	private VueJS vue;

	@ModelAttribute(name = "vue")
	private VueJS getVue() {
		return this.vue;
	}

	@RequestMapping("/{(index)?}")
	public String index(ModelMap model) {
		model.put("samples", Sample.all());
		return "index";
	}

	@RequestMapping("/test")
	public String test() {
		vue.addData("message", "Hello world");
		return "test";
	}
}
