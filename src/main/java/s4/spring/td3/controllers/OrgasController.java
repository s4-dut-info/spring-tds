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
		String restUrl = "/rest/orgas/";
		vue.addData("orgas", orgas);
		vue.addDataRaw("headers", "[{text:'Name', value:'name'},{text:'Domain', value:'domain'},{text:'Aliases', value:'aliases'},{ text: 'Actions', value: 'actions', sortable: false }]");
		vue.addMethod("deleteItem", "var self=this;" + Http.delete(restUrl, (Object) "{data: item}", JsArray.remove("self.orgas", "item")), "item");
		vue.addComputed("formTitle", "return this.editedIndex === -1 ? 'New Organization' : 'Edit Organization'");
		vue.addWatcher("dialog", "val || this.close();");
		vue.addData("dialog", false);
		vue.addDataRaw("editedItem", "{}");
		vue.addData("editedIndex", -1);
		vue.addMethod("close", "this.dialog=false;setTimeout(() => {this.editedItem = {};this.editedIndex = -1;}, 300);");
		vue.addMethod("save", "var self=this;let item=this.editedItem;if (this.editedIndex > -1) {" + Http.put(restUrl, (Object) "item", JsArray.replace("self.orgas", "self.editedIndex", "item") + "self.close();") + "}else{" + Http.post(restUrl, (Object) "item", JsArray.add("self.orgas", "item") + "self.close();") + "}");
		vue.addMethod("editItem", "this.editedIndex = this.orgas.indexOf(item);this.editedItem = Object.assign({}, item);this.dialog = true;", "item");
		return "orgas/vIndex";
	}
}
