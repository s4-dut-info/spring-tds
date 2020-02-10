package s4.spring.td1.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import s4.spring.td1.models.Element;

@Controller
@RequestMapping("/items")
@SessionAttributes("items")
public class ItemsController {

	@ModelAttribute("items")
	public List<Element> getItems() {
		return Arrays.asList(new Element("EmberJS", 4), new Element("Spring-boot", 5));
	}

	@GetMapping
	public String items() {
		return "/vItems";
	}

	@GetMapping("/clear")
	public RedirectView clear(HttpSession session, RedirectAttributes attributes) {
		session.invalidate();
		attributes.addFlashAttribute("message", "Session clear!");
		return new RedirectView("/items");
	}

	@GetMapping("/inc/{nom}")
	public RedirectView inc(@PathVariable String nom, RedirectAttributes attributes,
			@SessionAttribute List<Element> items) {
		int index = items.indexOf(new Element(nom, 0));
		if (index != -1) {
			Element elm = items.get(index);
			elm.inc();
			attributes.addFlashAttribute("message", "item <b>" + elm + "</b> inc!");
		}
		return new RedirectView("/items");
	}

	@GetMapping("/dec/{nom}")
	public RedirectView dec(@PathVariable String nom, RedirectAttributes attributes,
			@SessionAttribute List<Element> items) {
		int index = items.indexOf(new Element(nom, 0));
		if (index != -1) {
			Element elm = items.get(index);
			elm.dec();
			attributes.addFlashAttribute("message", "item <b>" + elm + "</b> dec!");
		}
		return new RedirectView("/items");
	}
}
