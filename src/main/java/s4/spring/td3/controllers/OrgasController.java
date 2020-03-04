package s4.spring.td3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import io.github.jeemv.springboot.vuejs.VueJS;
import io.github.jeemv.springboot.vuejs.utilities.Http;
import io.github.jeemv.springboot.vuejs.utilities.JsArray;
import s4.spring.td3.models.Organization;
import s4.spring.td3.repositories.OrgaRepository;

@Controller
public class OrgasController {

	@Autowired
	private VueJS vue;

	@Autowired
	private OrgaRepository repo;

	@ModelAttribute(name = "vue")
	private VueJS getVue() {
		return this.vue;
	}

	@GetMapping("/orgas")
	public String orgas() {
		List<Organization> orgas = repo.findAll();
		vue.addData("orgas", orgas);
		vue.addDataRaw("headers",
				"[{text:'Name', value:'name'},{text:'Domain', value:'domain'},{text:'Aliases', value:'aliases'},{ text: 'Actions', value: 'actions', sortable: false }]");
		vue.addMethod("deleteItem",
				"var self=this;"
						+ Http.delete("/rest/orgas/", (Object) "{data: item}", JsArray.remove("self.orgas", "item")),
				"item");
		return "orgas/vIndex";
	}
}
