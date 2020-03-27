package spring.vuejs.samples.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import spring.vuejs.samples.classes.User;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String login() {
		return "vLogin";
	}

	@PostMapping("/doLogin")
	public RedirectView doLogin(@RequestParam String name, HttpSession session, @ModelAttribute User activeUser) {
		if (!"".equals(name)) {
			activeUser.setName(name);
			activeUser.setConnected(true);
			session.setAttribute("activeUser", activeUser);
		}
		return new RedirectView("/index");
	}
	@GetMapping("/logout")
	public RedirectView doLogout(HttpSession session) {
		session.invalidate();
		return new RedirectView("/index");
	}
}
