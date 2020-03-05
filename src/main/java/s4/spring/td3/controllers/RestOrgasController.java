package s4.spring.td3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s4.spring.td3.models.Organization;
import s4.spring.td3.repositories.OrgaRepository;

@RestController
@RequestMapping("/rest/orgas/")
public class RestOrgasController {

	@Autowired
	private OrgaRepository repo;

	@ResponseBody
	@GetMapping()
	public List<Organization> get() {
		return repo.findAll();
	}

	@PostMapping()
	public Organization add(@RequestBody Organization orga) {
		return repo.saveAndFlush(orga);
	}

	@PutMapping()
	public Organization update(@RequestBody Organization orga) {
		return repo.save(orga);
	}

	@DeleteMapping()
	public void delete(@RequestBody Organization orga) {
		repo.delete(orga);
	}

}