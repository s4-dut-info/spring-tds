package spring.vuejs.samples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.jeemv.springboot.vuejs.VueJS;

@Controller
@RequestMapping("/samples")
public class SamplesController {
	@Autowired
	private VueJS vue;

	@ModelAttribute(name = "vue")
	private VueJS getVue() {
		return this.vue;
	}

	@RequestMapping("/method")
	public String mMethod() {
		vue.addData("message", "Your message...");
		vue.addMethod("clear", "this.message='';");
		return "samples/method";
	}

	@RequestMapping("/computed")
	public String mComputed() {
		vue.addData("message", "Your message...");
		vue.addMethod("clear", "this.message='';");
		vue.addComputed("size", "return 100-this.message.length;");
		vue.addFilter("plural", "if(value==0) return zero;if(value==1) return one;return value+other;", "zero", "one", "other");
		return "samples/computed";
	}
}
